package com.phillips.saper.bancoquestoes.controllers;

import static com.phillips.saper.bancoquestoes.configuration.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.dtos.StudentRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentTestResponseDTO;
import com.phillips.saper.bancoquestoes.services.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Operation(summary = "Get list of all Students")
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> findAll() {
        return studentService.findAll();
    } 

    @Operation(summary = "Get student''s performance on Tests", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping("performance/{id}")
    public ResponseEntity<List<StudentTestResponseDTO>> studentPerformance(
        @PathVariable(name = "id") Long id
    ){
        return studentService.findResultById(id);
    }

    @Operation(summary = "Register a new Student")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<StudentResponseDTO> save(
        @RequestBody @Valid StudentRequestDTO studentRequestDTO    ){
        return studentService.save(studentRequestDTO);
    }

    @Operation(summary = "Update a Student", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody StudentRequestDTO studentRequestDTO
    ){
        return studentService.update(id, studentRequestDTO);
    }

    @Operation(summary = "Delete a Student", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
        @PathVariable(name = "id") Long id
    ){
        return studentService.delete(id);
    }
}
