package com.phillips.saper.bancoquestoes.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.QuestionRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.QuestionResponseDTO;
import com.phillips.saper.bancoquestoes.enums.CertifiedValues;
import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.models.TeacherModel;
import com.phillips.saper.bancoquestoes.repositories.QuestionRepository;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<QuestionResponseDTO> findAll(Pageable pageable) {
        Page<QuestionModel> questionPage = questionRepository.findAll(pageable);

        List<QuestionResponseDTO> questionResponseDTO = questionPage.getContent().stream()
            .map(product -> modelMapper.map(product, QuestionResponseDTO.class))
            .collect(Collectors.toList());
        return new PageImpl<>(questionResponseDTO, pageable, questionPage.getTotalElements());
    }

    public ResponseEntity<QuestionResponseDTO> save(QuestionRequestDTO questionRequestDTO) {
        QuestionModel questionModel = new QuestionModel();

        questionModel.setQuestion(questionRequestDTO.getQuestion());
        questionModel.setAnswers(questionRequestDTO.getAnswers());
        questionModel.setDifficulty(questionRequestDTO.getDifficulty());
        questionModel.setIdDiscipline(questionRequestDTO.getIdDiscipline());     
        questionModel.setIdSubject(questionRequestDTO.getIdSubject());  
        questionModel.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));
        questionModel.setAnswersSheet(questionRequestDTO.getAnswersSheet());
        
        QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO(questionRepository.
        save(questionModel));

        return ResponseEntity.ok().body(questionResponseDTO);
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, QuestionRequestDTO questionRequestDTO){

        Optional<QuestionModel> questionOptional = questionRepository.findById(id);

        if(questionOptional.isPresent()){
            QuestionModel question = questionOptional.get();

            if(questionRequestDTO.getQuestion()!=null){
                question.setQuestion(questionRequestDTO.getQuestion());
            }
            if(questionRequestDTO.getAnswers()!=null){
                question.setAnswers(questionRequestDTO.getAnswers());
            }
            if(questionRequestDTO.getDifficulty()!=0){
                question.setDifficulty(questionRequestDTO.getDifficulty());
            }
            if(questionRequestDTO.getIdDiscipline()!=0){
                question.setIdDiscipline(questionRequestDTO.getIdDiscipline());
            }
            
           // BeanUtils.copyProperties(questionRequestDTO, question);  
            QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO(questionRepository.save(question));
            
            return ResponseEntity.status(HttpStatus.OK).body(questionResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
     }

     @Transactional
     public ResponseEntity<Object> delete(Long id){

        Optional<QuestionModel> questionOptional = questionRepository.findById(id);

        if(questionOptional.isPresent()){
            QuestionModel question = questionOptional.get();
            questionRepository.delete(question);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

     }   
     public long countQuestions() {
        return questionRepository.count();
    }

	public ResponseEntity<List<QuestionResponseDTO>> findByCertifiedTrue() {
        return ResponseEntity.status(HttpStatus.OK).body(
            questionRepository.findByCertifiedTrue().stream().map((question)->new QuestionResponseDTO(question)).toList());
	}

    public ResponseEntity<List<QuestionResponseDTO>> findByCertified(CertifiedValues certified) {

        if(certified==(CertifiedValues.NULL)){
            return ResponseEntity.status(HttpStatus.OK).body(
                questionRepository.findByCertifiedIsNull().stream().map((question)->new QuestionResponseDTO(question)).toList());
        }else if(certified==(CertifiedValues.FALSE)){
            return ResponseEntity.status(HttpStatus.OK).body(
                questionRepository.findByCertifiedFalse().stream().map((question)->new QuestionResponseDTO(question)).toList());
        }else{
            return ResponseEntity.status(HttpStatus.OK).body(
                questionRepository.findByCertifiedTrue().stream().map((question)->new QuestionResponseDTO(question)).toList());
        }
	}

    @Transactional
    public ResponseEntity<QuestionResponseDTO> updateTag(Long id, String tag){

        Optional<QuestionModel> questionOptional = questionRepository.findById(id);

        if(questionOptional.isPresent()){
            QuestionModel question = questionOptional.get();

            question.setTag(tag);
            
            QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO(questionRepository.save(question));
            
            return ResponseEntity.ok().body(questionResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
     }

    public ResponseEntity<QuestionResponseDTO> updateCertified(Long id, Boolean certified) {
        Optional<QuestionModel> questionOptional = questionRepository.findById(id);

        if(questionOptional.isPresent()){
            QuestionModel question = questionOptional.get();

            question.setCertified(certified);
            
            QuestionResponseDTO questionResponseDTO = new QuestionResponseDTO(questionRepository.save(question));
            
            return ResponseEntity.ok().body(questionResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

	public ResponseEntity<List<QuestionResponseDTO>> findByTag(String tag) {
        return ResponseEntity.status(HttpStatus.OK).body(
            questionRepository.findByTag(tag).stream().map((question)->new QuestionResponseDTO(question)).toList());
	}

    public ResponseEntity<List<QuestionResponseDTO>> findByidDisciplineAndidSubject(Long idDiscipline, Long idSubject) {
        return ResponseEntity.status(HttpStatus.OK).body(
            questionRepository.findByIdDisciplineAndIdSubjectAndCertifiedTrue(idDiscipline, idSubject).stream().map((question)->new QuestionResponseDTO(question)).toList());
    }

    public ResponseEntity<List<QuestionResponseDTO>> findByIdClient(Long id) {

        Optional<TeacherModel> optionalTeacher = teacherRepository.findByClientModelId(id);
        
        return ResponseEntity.status(HttpStatus.OK).body(
            questionRepository.findByIdDisciplineAndCertifiedIsNull(optionalTeacher.get().getIdDiscipline()).stream().map((question)->new QuestionResponseDTO(question)).toList());
    }
}
