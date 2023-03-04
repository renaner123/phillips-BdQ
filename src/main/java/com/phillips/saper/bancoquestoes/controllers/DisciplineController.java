package com.phillips.saper.bancoquestoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phillips.saper.bancoquestoes.dtos.DisciplineRequestDTO;
import com.phillips.saper.bancoquestoes.dtos.DisciplineResponseDTO;
import com.phillips.saper.bancoquestoes.models.DisciplineModel;
import com.phillips.saper.bancoquestoes.services.DisciplineService;

@RestController
@RequestMapping("/discipline")
public class DisciplineController {

    @Autowired
    DisciplineService disciplineService;


    @GetMapping
    public List<DisciplineResponseDTO> findAll(){
        List<DisciplineModel> list = disciplineService.findAll();

        return list.stream().map(DisciplineResponseDTO::new).toList();
    }

    @PostMapping
    public DisciplineRequestDTO save(@RequestBody DisciplineRequestDTO disciplineRequestDTO){
        return disciplineService.save(disciplineRequestDTO);
    }

    
}
