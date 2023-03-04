package com.phillips.saper.bancoquestoes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.services.TestService;

@RestController
public class TestController {
    
    @Autowired
    TestService testService;
}
