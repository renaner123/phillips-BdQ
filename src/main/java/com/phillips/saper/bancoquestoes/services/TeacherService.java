package com.phillips.saper.bancoquestoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.TeacherRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TeacherResponseDTO;
import com.phillips.saper.bancoquestoes.models.TeacherModel;
import com.phillips.saper.bancoquestoes.models.TeacherModel;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;

import jakarta.transaction.Transactional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public ResponseEntity<List<TeacherModel>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(teacherRepository.findAll());

    }

    public ResponseEntity<Object> save(TeacherRequestDTO teacherRequestDTO) {
        TeacherModel teacherModel = new TeacherModel();

        teacherModel.setName(teacherRequestDTO.getName());
        teacherModel.setEmail(teacherRequestDTO.getEmail());
        teacherModel.setCpf(teacherRequestDTO.getEmail());
        teacherModel.setIdDiscipline(teacherRequestDTO.getIdDiscipline());
        
        teacherRepository.save(teacherModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(teacherRequestDTO);
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, TeacherRequestDTO teacherRequestDTO){

        Optional<TeacherModel> teacherOptional = teacherRepository.findById(id);

        if(teacherOptional.isPresent()){
            TeacherModel teacher = teacherOptional.get();

            if(teacherRequestDTO.getName()!=null){
                teacher.setName(teacherRequestDTO.getName());
            }
            if(teacherRequestDTO.getEmail()!=null){
                teacher.setEmail(teacherRequestDTO.getEmail());
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
