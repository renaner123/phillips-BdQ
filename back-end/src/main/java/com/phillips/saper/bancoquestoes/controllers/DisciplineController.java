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

import com.phillips.saper.bancoquestoes.dtos.DisciplineRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.DisciplineResponseDTO;
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.services.DisciplineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/v1/disciplines")
public class DisciplineController {

    @Autowired
    DisciplineService disciplineService;

    @Operation(summary = "Get a list of all Disciplines", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public ResponseEntity<List<DisciplineModel>> findAll(){
        return disciplineService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register a Discipline", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PostMapping
    public ResponseEntity<DisciplineResponseDTO> save(@RequestBody DisciplineRequestDTO disciplineRequestDTO){
        return disciplineService.save(disciplineRequestDTO);
    }

    @Operation(summary = "Update a Discipline", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})    
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody DisciplineRequestDTO disciplineResquestDTO){

        return disciplineService.update(id, disciplineResquestDTO);
    }
    @Operation(summary = "Delete a Discipline", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id){

        return disciplineService.delete(id);
    }

    
}
