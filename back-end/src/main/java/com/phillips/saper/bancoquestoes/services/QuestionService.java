package com.phillips.saper.bancoquestoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.QuestionRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.QuestionResponseDTO;
import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.repositories.QuestionRepository;

import jakarta.transaction.Transactional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<QuestionResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
            questionRepository.findAll().stream().map((question)->new QuestionResponseDTO(question)).toList());
    }

    public ResponseEntity<Object> save(QuestionRequestDTO questionRequestDTO) {
        QuestionModel questionModel = new QuestionModel();

        questionModel.setUpdateDate(questionRequestDTO.getUpdateDate());
        questionModel.setQuestion(questionRequestDTO.getQuestion());
        questionModel.setAnswers(questionRequestDTO.getAnswers());
        questionModel.setDifficulty(questionRequestDTO.getDifficulty());
        questionModel.setCertified(questionRequestDTO.getCertified());
        questionModel.setIdDiscipline(questionRequestDTO.getIdDiscipline());
        
        questionRepository.save(questionModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(questionRequestDTO);
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
            if(questionRequestDTO.getCertified()!=null){
                question.setCertified(questionRequestDTO.getCertified());
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
}
