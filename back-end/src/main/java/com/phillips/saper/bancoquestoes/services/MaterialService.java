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
        Optional<MaterialModel> materialOptional = materialRepository.findById(fileId);

        if(materialOptional.isPresent()){

            MaterialModel materialModel = materialOptional.get();
            materialModel.setAmountAccess(materialModel.getAmountAccess()+1);
            materialRepository.save(materialModel);
            
            return materialOptional;
        }

        return null;

    }
    public List<MaterialModel> getFiles(){
        return materialRepository.findAll();
    }

	public ResponseEntity<List<MaterialResponseDTO>> findTop5ByOrderByAmountAccessDesc() {
        return ResponseEntity.status(HttpStatus.OK).body(
            materialRepository.findTop5ByOrderByAmountAccessDesc().stream().map((material)->new MaterialResponseDTO(material)).toList());
	}

    public long countMaterials() {
        return materialRepository.count();
    }

    @Transactional
    public ResponseEntity<MaterialResponseDTO> updateTag(Long id, String tag){

        Optional<MaterialModel> materialOptinal = materialRepository.findById(id);

        if(materialOptinal.isPresent()){
            MaterialModel material = materialOptinal.get();

            material.setTag(tag);
            
            MaterialResponseDTO materialResponseDTO = new MaterialResponseDTO(materialRepository.save(material));
            
            return ResponseEntity.ok().body(materialResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
     }

     public ResponseEntity<List<MaterialResponseDTO>> findByTag(String tag) {
        return ResponseEntity.status(HttpStatus.OK).body(
            materialRepository.findByTag(tag).stream().map((material)->new MaterialResponseDTO(material)).toList());
	}






}
