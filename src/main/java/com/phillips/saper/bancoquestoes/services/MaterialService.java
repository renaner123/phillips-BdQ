package com.phillips.saper.bancoquestoes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.repositories.MaterialRepository;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;
    
}
