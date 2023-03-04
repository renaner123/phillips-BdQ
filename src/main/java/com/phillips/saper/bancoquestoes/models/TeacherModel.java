package com.phillips.saper.bancoquestoes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class TeacherModel {

    public TeacherModel() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTeacher;

    private String cpf;
    private String nome;
    private String email;
    private int idDiscipline;
       
}
