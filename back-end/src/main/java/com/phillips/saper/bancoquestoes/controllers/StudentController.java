package com.phillips.saper.bancoquestoes.controllers;

import static com.phillips.saper.bancoquestoes.configuration.SwaggerConfig.BASIC_AUTH_SECURITY_SCHEME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.dtos.StudentRequestDTO;
import com.phillips.saper.bancoquestoes.services.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    // Por causa do CLinet e das relações, isso imprime 1000000000000000 linhas, deixar

/*     @GetMapping
    public ResponseEntity<List<StudentModel>> findAll() {
        return studentService.findAll();
    } */

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PostMapping
    public ResponseEntity<Object> save(
        @RequestBody @Valid StudentRequestDTO studentRequestDTO    ){
        return studentService.save(studentRequestDTO);
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
        @PathVariable(name = "id") Long id,
        @RequestBody StudentRequestDTO studentRequestDTO
    ){
        return studentService.update(id, studentRequestDTO);
    }

    @Operation(security = {@SecurityRequirement(name = BASIC_AUTH_SECURITY_SCHEME)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(
        @PathVariable(name = "id") Long id
    ){
        return studentService.delete(id);
    }


    /*
     * Não pagar. Será necessário essa lógica
     * 
     * Student student = new Student();
        Test test = new Test();
        StudentTest studentTest = new StudentTest();
        studentTest.setId(new StudentTestPK(student.getId(), test.getId()));
        studentTest.setTestScore(90.0);
        student.getStudentTests().add(studentTest);
        test.getStudentTests().add(studentTest);
        studentRepository.save(student);
        testRepository.save(test);
     * 
     * 
     */
}
