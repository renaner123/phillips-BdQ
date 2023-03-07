package com.phillips.saper.bancoquestoes.controllers;

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

import com.phillips.saper.bancoquestoes.dtos.DisciplineRequestDTO;
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.services.DisciplineService;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {

    @Autowired
    DisciplineService disciplineService;


    @GetMapping
    public ResponseEntity<List<DisciplineModel>> findAll(){
        return disciplineService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody DisciplineRequestDTO disciplineRequestDTO){
        return disciplineService.save(disciplineRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody DisciplineRequestDTO disciplineResquestDTO){

        return disciplineService.update(id, disciplineResquestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id){

        return disciplineService.delete(id);
    }

    
}
