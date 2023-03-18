package com.phillips.saper.bancoquestoes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.ClientRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentResponseDTO;
import com.phillips.saper.bancoquestoes.enums.RoleNames;
import com.phillips.saper.bancoquestoes.exception.exceptions.ConflictStoreException;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.models.RoleModel;
import com.phillips.saper.bancoquestoes.models.StudentModel;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.RoleRepository;
import com.phillips.saper.bancoquestoes.repositories.StudentRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ClientRepository clientRepository;



    public ResponseEntity<List<StudentModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());
    }

    public ResponseEntity<Object> save(StudentRequestDTO studentRequestDTO) {

        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(studentRequestDTO, clientRequestDTO);
        ClientModel client = clientRequestDTO.toClient();

        if(clientRepository.existsByLogin(client.getLogin())){
            throw new ConflictStoreException("login already in use");
        }

        Optional<RoleModel> role = roleRepository.findByRole(RoleNames.ROLE_STUDENT);
        List<RoleModel> roles = new ArrayList<>();
        roles.add(role.get());
        client.setRoles(roles);

        clientRepository.save(client);

        StudentModel student = new StudentModel();

        //TODO: Fazer lógica de cadastro
        student.setCpf(studentRequestDTO.getCpf());
        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getLogin());
        student.setClientModel(client);

        return ResponseEntity.status(HttpStatus.CREATED).body(new StudentResponseDTO(studentRepository.save(student)));
    }

















    public ResponseEntity<Object> findById(Long id) {
        Optional<StudentModel> studentOptional = studentRepository.findById(id);

        if(studentOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new StudentResponseDTO(studentOptional.get()));
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Estudante não encontrado.");
        }
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, StudentRequestDTO studentRequestDTO) {

        Optional<StudentModel> studentOptional = studentRepository.findById(id);

        if (studentOptional.isPresent()) {
            StudentModel student = studentOptional.get();

            if (studentRequestDTO.getCpf() != null) {
                student.setCpf(studentRequestDTO.getCpf());
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
