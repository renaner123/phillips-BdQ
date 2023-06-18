package com.phillips.saper.bancoquestoes.models;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class SubjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSubject;

    private String description;
    private int amountAccess;
    private int idDiscipline;

    
    public SubjectModel(String description, int amountAccess, int idDiscipline) {
        this.description = description;
        this.amountAccess = amountAccess;
        this.idDiscipline = idDiscipline;
    }


    public SubjectModel() {
    }
    
   

    
    
}
