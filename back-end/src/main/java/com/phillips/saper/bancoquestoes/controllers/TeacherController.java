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

import com.phillips.saper.bancoquestoes.dtos.TeacherRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TeacherResponseDTO;
import com.phillips.saper.bancoquestoes.services.TeacherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/teachers")
public class TeacherController {
    
    @Autowired
    TeacherService teacherService;

    @Operation(summary = "Get list of all Teachers",security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public ResponseEntity<List<TeacherResponseDTO>> findAll(){
        return teacherService.findAll(); 
    }

    @Operation(summary = "Register a new Teacher")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<TeacherResponseDTO> save(@RequestBody @Valid TeacherRequestDTO disciplineRequestDTO){
        return teacherService.save(disciplineRequestDTO);
    }

    @Operation(summary = "Update a Teacher",security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody TeacherRequestDTO teacherResquestDTO){

        return teacherService.update(id, teacherResquestDTO);
    }

    @Operation(summary = "Delete a Teacher",security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id){

        return teacherService.delete(id);
    }

}
