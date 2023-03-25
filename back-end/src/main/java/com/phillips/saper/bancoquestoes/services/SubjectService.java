package com.phillips.saper.bancoquestoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.SubjectRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.SubjectResponseDTO;
import com.phillips.saper.bancoquestoes.models.SubjectModel;
import com.phillips.saper.bancoquestoes.repositories.SubjectRepository;

import jakarta.transaction.Transactional;

@Service
public class SubjectService {

    @Autowired
    SubjectRepository subjectRepository;

    public ResponseEntity<List<SubjectModel>> findAll() {

        return ResponseEntity.status(HttpStatus.OK).body(subjectRepository.findAll());

    }

    public ResponseEntity<SubjectResponseDTO> save(SubjectRequestDTO subjectRequestDTO) {
        SubjectModel subjectModel = new SubjectModel();

        subjectModel.setDescription(subjectRequestDTO.getDescription());
        subjectModel.setIdDiscipline(subjectRequestDTO.getIdDiscipline());
        

        SubjectResponseDTO subjectResponseDTO = new SubjectResponseDTO(subjectRepository.save(subjectModel));   

        return ResponseEntity.ok().body(subjectResponseDTO);
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, SubjectRequestDTO subjectRequestDTO){

        Optional<SubjectModel> subjectOptional = subjectRepository.findById(id);

        if(subjectOptional.isPresent()){
            SubjectModel subject = subjectOptional.get();

            if(subjectRequestDTO.getDescription()!=null){
                subject.setDescription(subjectRequestDTO.getDescription());
            }
            if(subjectRequestDTO.getIdDiscipline()!=0){
                subject.setIdDiscipline(subjectRequestDTO.getIdDiscipline());
            }
            //BeanUtils.copyProperties(subjectRequestDTO, subject);  
            SubjectResponseDTO subjectResponseDTO = new SubjectResponseDTO(subjectRepository.save(subject));
            
            return ResponseEntity.status(HttpStatus.OK).body(subjectResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
     }

     @Transactional
     public ResponseEntity<Object> delete(Long id){

        Optional<SubjectModel> subjectOptional = subjectRepository.findById(id);

        if(subjectOptional.isPresent()){
            SubjectModel subject = subjectOptional.get();
            subjectRepository.delete(subject);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

     }

    public ResponseEntity<List<SubjectResponseDTO>> findTop5ByOrderByAmountAccessDesc() {
        return ResponseEntity.status(HttpStatus.OK).body(
            subjectRepository.findTop5ByOrderByAmountAccessDesc().stream().map((subject)->new SubjectResponseDTO(subject)).toList());
	}
}
