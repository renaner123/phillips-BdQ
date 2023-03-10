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
    String name_discipline;
    @Column(nullable = false)
    String descrption_discipline;

    public DisciplineModel(Long idDiscipline, String name, String description) {
        this.idDiscipline = idDiscipline;
        this.name_discipline = name;
        this.descrption_discipline = description;
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
        return name_discipline;
    }

    public void setName(String name) {
        this.name_discipline = name;
    }

    public String getDescrption_Discipline() {
        return descrption_discipline;
    }

    public void setdescrption_discipline(String descrption_discipline) {
        this.descrption_discipline = descrption_discipline;
    }

    
    

    
}
