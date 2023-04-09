package com.phillips.saper.bancoquestoes.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.TestRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TestResponseDTO;
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.models.SubjectModel;
import com.phillips.saper.bancoquestoes.models.TestModel;
import com.phillips.saper.bancoquestoes.repositories.DisciplineRepository;
import com.phillips.saper.bancoquestoes.repositories.QuestionRepository;
import com.phillips.saper.bancoquestoes.repositories.SubjectRepository;
import com.phillips.saper.bancoquestoes.repositories.TestRepository;

import jakarta.transaction.Transactional;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    DisciplineRepository disciplinRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<TestResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
            testRepository.findAll().stream().map((test)->new TestResponseDTO(test)).toList());
    }

    // Monta uma prova de acordo com IdDiscipline, IdSubject e numberOfQuestions informado, e incrementa a quantidade de acesso de cada questão usada
    public ResponseEntity<TestResponseDTO> save(TestRequestDTO testRequestDTO) {
        TestModel testModel = new TestModel();
        Optional<DisciplineModel> dOptional = disciplinRepository.findById(testRequestDTO.getIdDiscipline());
        Optional<SubjectModel> sOptional = subjectRepository.findById(testRequestDTO.getIdSubject());
    
        if(dOptional.isPresent() && sOptional.isPresent()){

            List<QuestionModel> questionOptional = questionRepository.findByIdDisciplineAndIdSubjectAndCertifiedTrue(testRequestDTO.getIdDiscipline(),testRequestDTO.getIdSubject());

            //pega uma quantidade aleatório de questões conforme numberOfQuestions
            List<QuestionModel> randonQuestions = questionOptional.stream()
            .distinct()
            .limit(testRequestDTO.getNumberOfQuestions())
            .collect(Collectors.toList());

            Set<QuestionModel> questionSet = new HashSet<>(randonQuestions);

            //incrementa quantidade de acessos
            for(QuestionModel question : questionSet){
                question.setAmountAccess(question.getAmountAccess()+1);
                // Para não retornar as respostas para front, evitar que os estudantes vejam as respostas xD
                question.setAnswersSheet(null);
                question.setTeachers(null);
                question.setTests(null);
            }

            testModel.setDateTime(LocalDateTime.now(ZoneId.of("UTC")));
            testModel.setQuestions(questionSet);
            testModel.setName("Test of discipline `" + dOptional.get().getName() + "` and subject `" + sOptional.get().getDescription()+"`");

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        TestResponseDTO testResponseDTO = new TestResponseDTO(testRepository.save(testModel));
            
        return ResponseEntity.ok().body(testResponseDTO);
    }

    @Transactional
     public ResponseEntity<Object> delete(Long id){

        Optional<TestModel> testOptional = testRepository.findById(id);

        if(testOptional.isPresent()){
            TestModel test = testOptional.get();
            testRepository.delete(test);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

     }   
}
