package com.phillips.saper.bancoquestoes.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class TeacherModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeacher;

    private String cpf;
    private String name;
    private String email;
    private int idDiscipline;

    @OneToOne(targetEntity = ClientModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    ClientModel clientModel;
    
    public TeacherModel() {

    }
    public TeacherModel(String cpf, String name, String email, int idDiscipline) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.idDiscipline = idDiscipline;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }
    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getIdDiscipline() {
        return idDiscipline;
    }
    public void setIdDiscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }
       


    
}
