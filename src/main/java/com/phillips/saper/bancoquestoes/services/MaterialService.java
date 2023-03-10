package com.phillips.saper.bancoquestoes.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.DisciplineResponseDTO;
import com.phillips.saper.bancoquestoes.dtos.MaterialRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.MaterialResponseDTO;
import com.phillips.saper.bancoquestoes.models.MaterialModel;
import com.phillips.saper.bancoquestoes.repositories.MaterialRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.transaction.Transactional;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    public ResponseEntity<List<MaterialModel>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(materialRepository.findAll());
    }

    public ResponseEntity<Object> save(MaterialRequestDTO materialRequestDTO) {
        MaterialModel materialModel = new MaterialModel();

        materialModel.setContent(materialRequestDTO.getContent());
        materialModel.setFileName(materialRequestDTO.getFileName());
        materialModel.setUploadDate(materialModel.getUploadDate());
        materialModel.setIdTeacher(materialRequestDTO.getIdTeacher());

        materialRepository.save(materialModel);

        return ResponseEntity.status(HttpStatus.CREATED).body(materialRequestDTO);
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, MaterialRequestDTO materialRequestDTO) {
        Optional<MaterialModel> materialOptional = materialRepository.findById(id);

        if (materialOptional.isPresent()) {
            MaterialModel material = materialOptional.get();

            if (materialRequestDTO.getContent() != null) {
                material.setContent(materialRequestDTO.getContent());
            }

            if (materialRequestDTO.getFileName() != null) {
                material.setFileName(materialRequestDTO.getFileName());
            }

            if (materialRequestDTO.getUploadDate() != null) {
                material.setUploadDate(materialRequestDTO.getUploadDate());
            }

            if (materialRequestDTO.getIdTeacher() != 0) {
                material.setIdTeacher(materialRequestDTO.getIdTeacher());
            }

            BeanUtils.copyProperties(materialRequestDTO, material);
            MaterialResponseDTO materialResponseDTO = new MaterialResponseDTO();

            return ResponseEntity.status(HttpStatus.OK).body(materialResponseDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @Transactional
    public ResponseEntity<Object> delete(Long id) {
        Optional<MaterialModel> materialOptional = materialRepository.findById(id);

        if(materialOptional.isPresent()){
            MaterialModel material = materialOptional.get();
            materialRepository.delete(material);
            
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
