package com.phillips.saper.bancoquestoes.controllers;

import static com.phillips.saper.bancoquestoes.configuration.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.dtos.QuestionRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.QuestionResponseDTO;
import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.services.QuestionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Operation(summary = "Get a list of all Questions", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public ResponseEntity<List<QuestionResponseDTO>> findAll() {
        return questionService.findAll();
    }

    @Operation(summary = "Get a list of all Questions certifieds", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("/certifieds")
    public ResponseEntity<List<QuestionResponseDTO>> findAllCertified() {
        return questionService.findByCertifiedTrue();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register a new Question", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PostMapping
    public ResponseEntity<QuestionResponseDTO> save(
            @RequestBody QuestionRequestDTO questionRequestDTO) {
                
        return questionService.save(questionRequestDTO);
    }

    @Operation(summary = "Update a question", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.update(id, questionRequestDTO);
    }

    @Operation(summary = "Get all questions by Tag", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("/{tag}")
    public ResponseEntity<List<QuestionResponseDTO>> questionByTag(
            @PathVariable(name = "tag") String tag) {
        return questionService.findByTag(tag);
    }

    @Operation(summary = "Update a tag of the question", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/tags/{id}")
    public ResponseEntity<QuestionResponseDTO> updateTag(
            @RequestParam(name = "tag") String tag,
            @PathVariable(name = "id") Long id) {
        return questionService.updateTag(id, tag);
    }

    @Operation(summary = "Delete a Question", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id) {
                return questionService.delete(id);
    }

    @Operation(summary = "Return the number of questions stored in the database")
    @GetMapping("/count")
    public long count(){
        return questionService.countQuestions();}

        
}
