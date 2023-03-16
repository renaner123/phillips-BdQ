package com.phillips.saper.bancoquestoes.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.TestRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TestResponseDTO;
import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.models.TestModel;
import com.phillips.saper.bancoquestoes.repositories.QuestionRepository;
import com.phillips.saper.bancoquestoes.repositories.TestRepository;

import jakarta.transaction.Transactional;

@Service
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Autowired
    QuestionRepository questionRepository;

    public ResponseEntity<List<TestModel>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(testRepository.findAll());
    }

    public ResponseEntity<Object> save(TestRequestDTO testRequestDTO) {
        TestModel testModel = new TestModel();
    
        testModel.setName(testRequestDTO.getName());
        testModel.setAnswers(testRequestDTO.getAnswers());
        testModel.setDateTime(testRequestDTO.getDateTime());
        // TODO buscar o Set de questões que vai compor a prova, talvez receber os IDs das questões no request
        //testModel.setQuestions(questionsList);

        testRepository.save(testModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(testRequestDTO);
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, TestRequestDTO testRequestDTO){

        Optional<TestModel> testOptional = testRepository.findById(id);

        if(testOptional.isPresent()){
            TestModel test = testOptional.get();

            if(testRequestDTO.getName()!=null){
                test.setName(testRequestDTO.getName());
            }
            if(testRequestDTO.getAnswers()!=null){
                test.setAnswers(testRequestDTO.getAnswers());
            }

            if(testRequestDTO.getDateTime()!=null){
                test.setDateTime(testRequestDTO.getDateTime());
            }
            
            TestResponseDTO testResponseDTO = new TestResponseDTO(testRepository.save(test));
            
            return ResponseEntity.status(HttpStatus.OK).body(testResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
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
