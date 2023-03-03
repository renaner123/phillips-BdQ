package com.phillips.saper.bancoquestoes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Teacher {

    public Teacher() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idTeacher;

    private String cpf;
    private String nome;
    private String email;
    private int idDiscipline;
       
}
