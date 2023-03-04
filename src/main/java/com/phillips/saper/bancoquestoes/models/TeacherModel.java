package com.phillips.saper.bancoquestoes.models;

import jakarta.persistence.Column;
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
    private Long idTeacher;

    @Column(nullable = false)
    private String cpf;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String email;
    @Column(nullable = true)
    private int idDiscipline;
       
}
