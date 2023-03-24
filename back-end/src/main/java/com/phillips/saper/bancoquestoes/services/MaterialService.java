package com.phillips.saper.bancoquestoes.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.phillips.saper.bancoquestoes.dtos.MaterialResponseDTO;
import com.phillips.saper.bancoquestoes.models.MaterialModel;
import com.phillips.saper.bancoquestoes.repositories.ClientRepository;
import com.phillips.saper.bancoquestoes.repositories.MaterialRepository;
import com.phillips.saper.bancoquestoes.repositories.TeacherRepository;

import jakarta.transaction.Transactional;

@Service
public class MaterialService {

    @Autowired
    MaterialRepository materialRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    ClientRepository clientRepository;

    public ResponseEntity<List<MaterialResponseDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
            materialRepository.findAll().stream().map((material)->new MaterialResponseDTO(material)).toList());
    }

    // public ResponseEntity<Object> save(MaterialRequestDTO materialRequestDTO) {
    //     MaterialModel materialModel = new MaterialModel();

    //     materialModel.setContent(materialRequestDTO.getContent());
    //     materialModel.setFileName(materialRequestDTO.getFileName());
    //     materialModel.setUploadDate(materialModel.getUploadDate());
    //     materialModel.setIdTeacher(materialRequestDTO.getIdTeacher());

    //     materialRepository.save(materialModel);

    //     return ResponseEntity.status(HttpStatus.CREATED).body(materialRequestDTO);
    // }

    // @Transactional
    // public ResponseEntity<Object> update(Long id, MaterialRequestDTO materialRequestDTO) {
    //     Optional<MaterialModel> materialOptional = materialRepository.findById(id);

    //     if (materialOptional.isPresent()) {
    //         MaterialModel material = materialOptional.get();

    //         if (materialRequestDTO.getContent() != null) {
    //             material.setContent(materialRequestDTO.getContent());
    //         }

    //         if (materialRequestDTO.getFileName() != null) {
    //             material.setFileName(materialRequestDTO.getFileName());
    //         }

    //         if (materialRequestDTO.getUploadDate() != null) {
    //             material.setUploadDate(materialRequestDTO.getUploadDate());
    //         }

    //         if (materialRequestDTO.getIdTeacher() != 0) {
    //             material.setIdTeacher(materialRequestDTO.getIdTeacher());
    //         }

    //         BeanUtils.copyProperties(materialRequestDTO, material);
    //         MaterialResponseDTO materialResponseDTO = new MaterialResponseDTO();

    //         return ResponseEntity.status(HttpStatus.OK).body(materialResponseDTO);
    //     } else {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //     }
    // }

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

    public MaterialModel saveFile(MultipartFile file, String username) {
        String docname = file.getOriginalFilename();
        try {
            MaterialModel doc = new MaterialModel(docname,file.getContentType(),file.getBytes(),0);
            Long clientId = clientRepository.findByLogin(username).get().getId();
            doc.setIdClient(clientId);
            doc.setUploadDate(LocalDateTime.now(ZoneId.of("UTC")));
            return materialRepository.save(doc);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public Optional<MaterialModel> getFile(Long fileId) {
        return materialRepository.findById(fileId);
    }
    public List<MaterialModel> getFiles(){
        return materialRepository.findAll();
    }

	public ResponseEntity<List<MaterialResponseDTO>> findTop5ByOrderByAmountAccessDesc() {
        return ResponseEntity.status(HttpStatus.OK).body(
            materialRepository.findTop5ByOrderByAmountAccessDesc().stream().map((material)->new MaterialResponseDTO(material)).toList());
	}






}
