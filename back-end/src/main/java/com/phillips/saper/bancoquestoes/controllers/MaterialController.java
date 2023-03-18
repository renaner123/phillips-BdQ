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

import com.phillips.saper.bancoquestoes.dtos.MaterialRequestDTO;
import com.phillips.saper.bancoquestoes.models.MaterialModel;
import com.phillips.saper.bancoquestoes.services.MaterialService;

// TODO adicionar Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)}) nos recursos

@RestController
@RequestMapping("/materials")
public class MaterialController {

    @Autowired
    MaterialService materialService;

    @GetMapping
    public ResponseEntity<List<MaterialModel>> findAll() {
        return materialService.findAll();
    }

    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody MaterialRequestDTO materialRequestDTO) {
        return materialService.save(materialRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody MaterialRequestDTO materialRequestDTO) {
        return materialService.update(id, materialRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id) {
                return materialService.delete(id);
    }

}
