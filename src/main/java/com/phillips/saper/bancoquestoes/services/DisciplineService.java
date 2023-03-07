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
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.repositories.DisciplineRepository;

import jakarta.transaction.Transactional;

@Service
public class DisciplineService {

    @Autowired
    DisciplineRepository disciplineRepository;

    public ResponseEntity<List<DisciplineModel>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(disciplineRepository.findAll());

    }

    public ResponseEntity<Object> save(DisciplineRequestDTO disciplineRequestDTO) {
        DisciplineModel disciplineModel = new DisciplineModel();

        disciplineModel.setName(disciplineRequestDTO.getName());
        disciplineModel.setDescription(disciplineRequestDTO.getDescription());
        
        disciplineRepository.save(disciplineModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(disciplineRequestDTO);
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, DisciplineRequestDTO disciplineRequestDTO){

        Optional<DisciplineModel> disciplineOptional = disciplineRepository.findById(id);

        if(disciplineOptional.isPresent()){
            DisciplineModel discipline = disciplineOptional.get();

            if(disciplineRequestDTO.getName()!=null){
                discipline.setName(disciplineRequestDTO.getName());
            }
            if(disciplineRequestDTO.getDescription()!=null){
                discipline.setDescription(disciplineRequestDTO.getDescription());
            }

            
            BeanUtils.copyProperties(disciplineRequestDTO, discipline);  
            DisciplineResponseDTO disciplineResponseDTO = new DisciplineResponseDTO(disciplineRepository.save(discipline));
            
            return ResponseEntity.status(HttpStatus.OK).body(disciplineResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
     }

     @Transactional
     public ResponseEntity<Object> delete(Long id){

        Optional<DisciplineModel> disciplineOptional = disciplineRepository.findById(id);

        if(disciplineOptional.isPresent()){
            DisciplineModel discipline = disciplineOptional.get();
            disciplineRepository.delete(discipline);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

     }
    
}
