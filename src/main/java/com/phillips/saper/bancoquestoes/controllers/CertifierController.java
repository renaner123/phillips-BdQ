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

import com.phillips.saper.bancoquestoes.dtos.CertifierRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.CertifierResponseDTO;
import com.phillips.saper.bancoquestoes.models.CertifierModel;
import com.phillips.saper.bancoquestoes.services.CertifierService;

@RestController
@RequestMapping("/certifiers")
public class CertifierController {
    
    @Autowired
    CertifierService certifierService;

    @GetMapping
    public List<CertifierResponseDTO> findAll(){
        List<CertifierModel> list = certifierService.findAll();

        return list.stream().map(CertifierResponseDTO::new).toList();
    }

    @PostMapping
    public CertifierRequestDTO save(@RequestBody CertifierRequestDTO certifierRequestDTO){
        return certifierService.save(certifierRequestDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody CertifierRequestDTO certifierResquestDTO){

        return certifierService.update(id, certifierResquestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(name = "id") Long id){

        return certifierService.delete(id);
    }
    
}
