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
import com.phillips.saper.bancoquestoes.dtos.TeacherRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TeacherResponseDTO;
import com.phillips.saper.bancoquestoes.enums.RoleNames;
import com.phillips.saper.bancoquestoes.exceptions.ConflictStoreException;
import com.phillips.saper.bancoquestoes.models.ClientModel;
import com.phillips.saper.bancoquestoes.models.RoleModel;
import com.phillips.saper.bancoquestoes.models.TeacherModel;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.RoleRepository;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;

import jakarta.transaction.Transactional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity<List<TeacherModel>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(teacherRepository.findAll());

    }

    public ResponseEntity<Object> save(TeacherRequestDTO teacherRequestDTO) {
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO();
        BeanUtils.copyProperties(teacherRequestDTO, clientRequestDTO);
        ClientModel client = clientRequestDTO.toClient();

        if(clientRepository.existsByLogin(client.getLogin())){
            throw new ConflictStoreException("login already in use");
        }
        
        Optional<RoleModel> role = roleRepository.findByRole(RoleNames.ROLE_TEACHER);
        List<RoleModel> roles = new ArrayList<>();
        roles.add(role.get());
        client.setRoles(roles);

        clientRepository.save(client);

        TeacherModel teacherModel = new TeacherModel();

        teacherModel.setName(teacherRequestDTO.getName());
        teacherModel.setEmail(teacherRequestDTO.getLogin());
        teacherModel.setCpf(teacherRequestDTO.getCpf());
        teacherModel.setIdDiscipline(teacherRequestDTO.getIdDiscipline());
        teacherModel.setClientModel(client);   

        return ResponseEntity.status(HttpStatus.CREATED).body(new TeacherResponseDTO(teacherRepository.save(teacherModel)));
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, TeacherRequestDTO teacherRequestDTO){

        Optional<TeacherModel> teacherOptional = teacherRepository.findById(id);

        if(teacherOptional.isPresent()){
            TeacherModel teacher = teacherOptional.get();

            if(teacherRequestDTO.getName()!=null){
                teacher.setName(teacherRequestDTO.getName());
            }
            if(teacherRequestDTO.getCpf()!=null){
                teacher.setCpf(teacherRequestDTO.getCpf());
            }
            if(teacherRequestDTO.getIdDiscipline()!=0){
                teacher.setIdDiscipline(teacherRequestDTO.getIdDiscipline());
            }
            
            BeanUtils.copyProperties(teacherRequestDTO, teacher);  
            TeacherResponseDTO teacherResponseDTO = new TeacherResponseDTO(teacherRepository.save(teacher));
            
            return ResponseEntity.status(HttpStatus.OK).body(teacherResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
     }

     @Transactional
     public ResponseEntity<Object> delete(Long id){

        Optional<TeacherModel> teacherOptional = teacherRepository.findById(id);

        if(teacherOptional.isPresent()){
            TeacherModel teacher = teacherOptional.get();
            teacherRepository.delete(teacher);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

     }    
}
