package com.phillips.saper.bancoquestoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.models.CertifierModel;
import com.phillips.saper.bancoquestoes.repositories.CertifierRepository;

@Service
public class CertifierService {

    @Autowired
    CertifierRepository certifierRepository;

    public List<CertifierModel> findAll() {
        return certifierRepository.findAll();
    }


}
