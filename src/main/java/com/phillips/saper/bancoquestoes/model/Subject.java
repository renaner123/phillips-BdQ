package com.phillips.saper.bancoquestoes.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idSubject;

    private String descption;
    private int amountAccess;
    private int idDscipline;
    
}
