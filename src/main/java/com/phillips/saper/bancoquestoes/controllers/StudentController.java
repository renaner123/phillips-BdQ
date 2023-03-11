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

import com.phillips.saper.bancoquestoes.dtos.StudentRequestDTO;
import com.phillips.saper.bancoquestoes.models.StudentModel;
import com.phillips.saper.bancoquestoes.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentModel>> findAll() {
        return studentService.findAll();
    }

    @PutMapping
    public ResponseEntity<Object> save(
        @RequestBody StudentRequestDTO studentRequestDTO    ){
        return studentService.save(studentRequestDTO);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody StudentRequestDTO studentRequestDTO
    ){
        return studentService.update(id, studentRequestDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
        @PathVariable(name = "id") Long id
    ){
        return studentService.delete(id);
    }

}
