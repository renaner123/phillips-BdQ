package com.phillips.saper.bancoquestoes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class DisciplineModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDiscipline;

    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String description;

    public DisciplineModel(Long idDiscipline, String name, String description) {
        this.idDiscipline = idDiscipline;
        this.name = name;
        this.description = description;
    }

    public DisciplineModel() {
    }

    public Long getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(Long idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    

    
}
