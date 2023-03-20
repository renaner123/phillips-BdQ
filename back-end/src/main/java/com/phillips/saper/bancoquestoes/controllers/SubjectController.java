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

import com.phillips.saper.bancoquestoes.dtos.SubjectRequestDTO;
import com.phillips.saper.bancoquestoes.models.SubjectModel;
import com.phillips.saper.bancoquestoes.services.SubjectService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public ResponseEntity<List<SubjectModel>> findAll(){
        return subjectService.findAll();
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody SubjectRequestDTO subjectRequestDTO){
        return subjectService.save(subjectRequestDTO);
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody SubjectRequestDTO subjectResquestDTO){

        return subjectService.update(id, subjectResquestDTO);
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id){

        return subjectService.delete(id);
    }    
}
