package com.phillips.saper.bancoquestoes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    
}
