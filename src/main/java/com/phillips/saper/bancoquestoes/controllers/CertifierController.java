package com.phillips.saper.bancoquestoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.dtos.CertifierResponseDTO;
import com.phillips.saper.bancoquestoes.models.CertifierModel;
import com.phillips.saper.bancoquestoes.services.CertifierService;

@RestController
@RequestMapping("/certifier")
public class CertifierController {
    
    @Autowired
    CertifierService certifierService;

    @GetMapping
    public List<CertifierResponseDTO> findAll(){
        List<CertifierModel> list = certifierService.findAll();

        return list.stream().map(CertifierResponseDTO::new).toList();
    }

    
}
