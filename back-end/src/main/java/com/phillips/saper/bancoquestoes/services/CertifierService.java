package com.phillips.saper.bancoquestoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.CertifierRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.TeacherResponseDTO;
import com.phillips.saper.bancoquestoes.models.CertifierModel;
import com.phillips.saper.bancoquestoes.repositories.CertifierRepository;

import jakarta.transaction.Transactional;

@Service
public class CertifierService {

    @Autowired
    CertifierRepository certifierRepository;

    public List<CertifierModel> findAll() {
        return certifierRepository.findAll();
    }

    // TODO inserir lógica para verificar se o cpf do professor existe, para ai sim, cadastrar como certificador e vincular
    public CertifierRequestDTO save(CertifierRequestDTO certifierRequestDTO) {
        CertifierModel certifierModel = new CertifierModel(certifierRequestDTO.getCpf(), certifierRequestDTO.getEmail(), certifierRequestDTO.getName(), certifierRequestDTO.getIdDiscipline(), certifierRequestDTO.getAmountCertified());
        
        certifierRepository.save(certifierModel);

        return certifierRequestDTO;
    }

    @Transactional
    public ResponseEntity<Object> update(Long id, CertifierRequestDTO certifierRequestDTO){

        Optional<CertifierModel> certifierOptional = certifierRepository.findById(id);

        if(certifierOptional.isPresent()){
            CertifierModel certifier = certifierOptional.get();

            if(certifierRequestDTO.getName()!=null){
                certifier.setName(certifierRequestDTO.getName());
            }
            if(certifierRequestDTO.getEmail()!=null){
                certifier.setEmail(certifierRequestDTO.getEmail());
            }
            if(certifierRequestDTO.getCpf()!=null){
                certifier.setCpf(certifierRequestDTO.getCpf());
            }
            if(certifierRequestDTO.getAmountCertified()!=0){
                certifier.setAmountCertified(certifierRequestDTO.getAmountCertified());
            }
            if(certifierRequestDTO.getIdDiscipline()!=0){
                certifier.setIdDiscipline(certifierRequestDTO.getIdDiscipline());
            }
            
            BeanUtils.copyProperties(certifierRequestDTO, certifier);  
            TeacherResponseDTO certifierResponseDTO = new TeacherResponseDTO(certifierRepository.save(certifier));
            
            return ResponseEntity.status(HttpStatus.OK).body(certifierResponseDTO);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
     }

     @Transactional
     public ResponseEntity<Object> delete(Long id){

        Optional<CertifierModel> certifierOptional = certifierRepository.findById(id);

        if(certifierOptional.isPresent()){
            CertifierModel certifier = certifierOptional.get();
            certifierRepository.delete(certifier);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();  
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

     } 

}
