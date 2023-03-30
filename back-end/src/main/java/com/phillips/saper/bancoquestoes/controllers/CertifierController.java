package com.phillips.saper.bancoquestoes.controllers;

import java.util.List;

import static com.phillips.saper.bancoquestoes.configuration.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

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

import com.phillips.saper.bancoquestoes.dtos.CertifierRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.CertifierResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.TeacherRequestDTO;
import com.phillips.saper.bancoquestoes.models.CertifierModel;
import com.phillips.saper.bancoquestoes.services.CertifierService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/v1/certifiers")
public class CertifierController {
    
    @Autowired
    CertifierService certifierService;

    @Operation(summary = "Get a list of all Certifiers", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @GetMapping
    public List<CertifierResponseDTO> findAll(){
        List<CertifierModel> list = certifierService.findAll();

        return list.stream().map(CertifierResponseDTO::new).toList();
    }

    @Operation(summary = "Register a new Certifier", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PostMapping
    public ResponseEntity<CertifierResponseDTO> save(@RequestBody TeacherRequestDTO certifierRequestDTO){
        return certifierService.save(certifierRequestDTO);
    }

    @Operation(summary = "Update a Certifier by Id", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody CertifierRequestDTO certifierResquestDTO){

        return certifierService.update(id, certifierResquestDTO);
    }
    
    @Operation(summary = "Delete a Certifier by Id", security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id){

        return certifierService.delete(id);
    }
    
}
