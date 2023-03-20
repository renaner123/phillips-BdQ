package com.phillips.saper.bancoquestoes.controllers;

import static com.phillips.saper.bancoquestoes.configuration.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

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

import com.phillips.saper.bancoquestoes.dtos.TeacherRequestDTO;
import com.phillips.saper.bancoquestoes.models.TeacherModel;
import com.phillips.saper.bancoquestoes.services.TeacherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    
    @Autowired
    TeacherService teacherService;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public ResponseEntity<List<TeacherModel>> findAll(){
        return teacherService.findAll();
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid TeacherRequestDTO disciplineRequestDTO){
        return teacherService.save(disciplineRequestDTO);
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody TeacherRequestDTO teacherResquestDTO){

        return teacherService.update(id, teacherResquestDTO);
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id){

        return teacherService.delete(id);
    }

}
