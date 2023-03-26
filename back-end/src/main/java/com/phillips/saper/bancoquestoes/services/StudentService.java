package com.phillips.saper.bancoquestoes.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Set;

import com.phillips.saper.bancoquestoes.Embeddables.StudentTestPK;
import com.phillips.saper.bancoquestoes.dtos.ClientRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.StudentTestResponseDTO;
import com.phillips.saper.bancoquestoes.enums.RoleNames;
import com.phillips.saper.bancoquestoes.exceptions.ConflictStoreException;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.models.RoleModel;
import com.phillips.saper.bancoquestoes.models.StudentModel;
import com.phillips.saper.bancoquestoes.models.StudentTest;
import com.phillips.saper.bancoquestoes.models.TestModel;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.RoleRepository;
import com.phillips.saper.bancoquestoes.repositories.StudentRepository;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;
import com.phillips.saper.bancoquestoes.repositories.TestRepository;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    TestRepository testRepository;

    @Autowired
    TeacherRepository teacherRepository;


    public ResponseEntity<List<StudentResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
            studentRepository.findAll().stream().map((student)->new StudentResponseDTO(student)).toList());
    }

    public ResponseEntity<StudentResponseDTO> save(StudentRequestDTO studentRequestDTO) {

        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(studentRequestDTO, clientRequestDTO);
        ClientModel client = clientRequestDTO.toClient();

        if(clientRepository.existsByLogin(client.getLogin())){
            throw new ConflictStoreException("login already in use");
        }

        // FIXME [Renan] certo seria deixar o cpf na tabela cliente para evitar essa double query. Alterar futuramente
        if(teacherRepository.existsByCpf(studentRequestDTO.getCpf()) || studentRepository.existsByCpf(studentRequestDTO.getCpf())){
            throw new ConflictStoreException("cpf already in use");
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

	public ResponseEntity<List<StudentTestResponseDTO>> findResultById(Long id) {

        Optional<StudentModel> studentOptional = studentRepository.findById(id);
        Set<StudentTest> studentTests =  studentOptional.get().getStudentTests();
        List<StudentTestResponseDTO> listStudentsTest = new ArrayList<>();

        for (StudentTest studentTest : studentTests) {
            listStudentsTest.add(new StudentTestResponseDTO(studentTest.getId().getIdTest(), studentTest.getResult(), 
            testRepository.findById(studentTest.getId().getIdTest()).get().getDateTime(), testRepository.findById(studentTest.getId().getIdTest()).get().getName()));                       
        }

        

        return ResponseEntity.ok().body(listStudentsTest);
    }

}
