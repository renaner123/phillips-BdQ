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

import com.phillips.saper.bancoquestoes.dtos.MaterialRequestDTO;
import com.phillips.saper.bancoquestoes.models.MaterialModel;
import com.phillips.saper.bancoquestoes.services.MaterialService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/materials")
public class MaterialController {

    @Autowired
    MaterialService materialService;
    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public ResponseEntity<List<MaterialModel>> findAll() {
        return materialService.findAll();
    }
    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PostMapping
    public ResponseEntity<Object> save(
            @RequestBody MaterialRequestDTO materialRequestDTO) {
        return materialService.save(materialRequestDTO);
    }
    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable(name = "id") Long id,
            @RequestBody MaterialRequestDTO materialRequestDTO) {
        return materialService.update(id, materialRequestDTO);
    }
    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
            @PathVariable(name = "id") Long id) {
                return materialService.delete(id);
    }

}
