package com.phillips.saper.bancoquestoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phillips.saper.bancoquestoes.dtos.DisciplineRequestDTO;
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.repositories.DisciplineRepository;

@Service
public class DisciplineService {

    @Autowired
    DisciplineRepository disciplineRepository;

    public List<DisciplineModel> findAll() {
        return disciplineRepository.findAll();
    }

    public DisciplineRequestDTO save(DisciplineRequestDTO disciplineRequestDTO) {
        DisciplineModel disciplineModel = new DisciplineModel();

        disciplineModel.setName(disciplineRequestDTO.getName());
        disciplineModel.setDescription(disciplineRequestDTO.getDescription());
        
        disciplineRepository.save(disciplineModel);

        return disciplineRequestDTO;
    }
    
}
