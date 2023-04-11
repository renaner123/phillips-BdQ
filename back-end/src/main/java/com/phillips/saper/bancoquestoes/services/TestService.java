package com.phillips.saper.bancoquestoes.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.Embeddables.StudentTestPK;
import com.phillips.saper.bancoquestoes.dtos.StudentTestResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.TestCorrectRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TestRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TestResponseDTO;
import com.phillips.saper.bancoquestoes.exceptions.ConflictStoreException;
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.models.StudentModel;
import com.phillips.saper.bancoquestoes.models.StudentTest;
import com.phillips.saper.bancoquestoes.models.SubjectModel;
import com.phillips.saper.bancoquestoes.models.TestModel;
import com.phillips.saper.bancoquestoes.repositories.DisciplineRepository;
import com.phillips.saper.bancoquestoes.repositories.QuestionRepository;
import com.phillips.saper.bancoquestoes.repositories.StudentRepository;
import com.phillips.saper.bancoquestoes.repositories.SubjectRepository;
import com.phillips.saper.bancoquestoes.repositories.TestRepository;
import com.phillips.saper.bancoquestoes.utils.Formatter;

import jakarta.transaction.Transactional;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    StudentRepository studentRepository;

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
    public ResponseEntity<StudentTestResponseDTO> update(Long id, TestCorrectRequestDTO testRequestDTO){

        Optional<TestModel> testOptional = testRepository.findById(id);
        System.out.println("ID client -: " + testRequestDTO.getIdStudent());
        Optional<StudentModel> studentOptional = studentRepository.findByClientModelId(testRequestDTO.getIdStudent());
        Set<QuestionModel> questionSet = testOptional.get().getQuestions();
        System.out.println("ID Student -: " + studentOptional.get().getIdStudent());
        int hits = 0;
        double result = 0.0;
               
        if(!testOptional.isPresent()){
            for(StudentTest student : studentOptional.get().getStudentTests()){
                if(student.getId().getIdStudent()==testRequestDTO.getIdStudent() && student.getId().getIdTest()==id){
                    throw new ConflictStoreException("This test has already been answered");
                }
            }
        }

        for(QuestionModel question : questionSet){
            if(testRequestDTO.getAnswersHash().get(String.valueOf(question.getIdQuestion())) != null){
                if(testRequestDTO.getAnswersHash().get(String.valueOf(question.getIdQuestion())).equals(question.getAnswersSheet())){
                    hits = hits + 1;
                }
            }else{
                throw new IllegalArgumentException("IdQuestion missing!");
            }

        }

        StudentModel studentModel = studentOptional.get();
        TestModel testModel = testOptional.get();
        StudentTest studentTest = new StudentTest();


        if(testOptional.isPresent() && studentOptional.isPresent()){
            studentTest.setId(new StudentTestPK(studentOptional.get().getIdStudent(), id));
            // FIXME calcula uma nota simples, pode ser possível alterar a lógica da nota posteriormente
            result = (Formatter.FormatterDoubleTwoCases((hits*10.0)/questionSet.size()));
            studentTest.setResult(result);
            studentModel.getStudentTests().add(studentTest);
            testModel.getStudentTestSet().add(studentTest);
            studentRepository.save(studentModel);
            testRepository.save(testModel);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }      

        StudentTestResponseDTO studentTestResponseDTO = new StudentTestResponseDTO(id, result, testModel.getDateTime(), testModel.getName());

        return ResponseEntity.ok().body(studentTestResponseDTO);
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

    public ResponseEntity<TestResponseDTO> findById(Long id) {
        Optional<TestModel> testOptional = testRepository.findById(id);

        TestModel testModel = testOptional.get();

        TestResponseDTO questionResponseDTO = new TestResponseDTO(testModel);

        return ResponseEntity.ok().body(questionResponseDTO);
    }   

}
