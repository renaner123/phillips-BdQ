package com.phillips.saper.bancoquestoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.services.MaterialService;

@RestController
@RequestMapping("/material")
public class MaterialController {
    
    @Autowired
    MaterialService materialService;
}
