package com.phillips.saper.bancoquestoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.DisciplineRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.DisciplineResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentResponseDTO;
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.models.StudentModel;
import com.phillips.saper.bancoquestoes.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public ResponseEntity<List<StudentModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());
    }

    public ResponseEntity<Object> save(StudentRequestDTO studentRequestDTO) {
        StudentModel studentModel = new StudentModel();

        studentModel.setCpf(studentRequestDTO.getCpf());
        studentModel.setEmail(studentRequestDTO.getEmail());
        studentModel.setName(studentRequestDTO.getName());

        studentRepository.save(studentModel);

        return ResponseEntity.status(HttpStatus.OK).body(studentRequestDTO);
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, StudentRequestDTO studentRequestDTO) {

        Optional<StudentModel> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            StudentModel student = studentOptional.get();

            if (studentRequestDTO.getCpf() != null) {
                student.setCpf(studentRequestDTO.getCpf());
            }

            if (studentRequestDTO.getEmail() != null) {
                student.setEmail(studentRequestDTO.getEmail());
            }

            if (studentRequestDTO.getName() != null) {
                student.setName(studentRequestDTO.getName());
            }

            BeanUtils.copyProperties(studentRequestDTO, student);
            StudentResponseDTO studentResponseDTO = new StudentResponseDTO(studentRepository.save(student));

            return ResponseEntity.status(HttpStatus.OK).body(studentResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Optional<StudentModel> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            StudentModel student = studentOptional.get();

            studentRepository.delete(student);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
