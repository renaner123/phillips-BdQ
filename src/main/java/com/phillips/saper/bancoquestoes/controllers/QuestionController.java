package com.phillips.saper.bancoquestoes.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.dtos.QuestionRequestDTO;
import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.services.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    
    @GetMapping
    public ResponseEntity<List<QuestionModel>> findAll() {
        return questionService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody QuestionRequestDTO questionRequestDTO) {
        
        questionRequestDTO.setUpdateDate(LocalDateTime.now(ZoneId.of("UTC")));

        return questionService.save(questionRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.update(id, questionRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id) {
                return questionService.delete(id);
    }
}
