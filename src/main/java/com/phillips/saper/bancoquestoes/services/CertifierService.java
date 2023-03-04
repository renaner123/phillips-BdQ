package com.phillips.saper.bancoquestoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.CertifierRequestDTO;
import com.phillips.saper.bancoquestoes.models.CertifierModel;
import com.phillips.saper.bancoquestoes.repositories.CertifierRepository;

@Service
public class CertifierService {

    @Autowired
    CertifierRepository certifierRepository;

    public List<CertifierModel> findAll() {
        return certifierRepository.findAll();
    }

    public CertifierRequestDTO save(CertifierRequestDTO certifierRequestDTO) {
        CertifierModel certifierModel = new CertifierModel();
        certifierModel.setCpf(certifierRequestDTO.getCpf());
        certifierModel.setAmountCertified(certifierRequestDTO.getAmountCertified()+1);
        certifierModel.setEmail(certifierRequestDTO.getEmail());
        certifierModel.setIdDiscipline(certifierRequestDTO.getIdDiscipline());
        certifierModel.setNome(certifierRequestDTO.getName());
        
        certifierRepository.save(certifierModel);

        return certifierRequestDTO;
    }


}
