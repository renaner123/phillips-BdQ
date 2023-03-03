package com.phillips.saper.bancoquestoes.models;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idStudent;

    private String cpf;
    private String name;
    private String email;
    
}
