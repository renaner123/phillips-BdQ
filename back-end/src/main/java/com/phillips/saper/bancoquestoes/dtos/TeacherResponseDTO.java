package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.TeacherModel;

public class TeacherResponseDTO {
     //TODO Adicionar  @Schema(example = "") nos atributos e validações
    
    Long id;
    String cpf;
    String name;
    String email;
    Long idDiscipline;
    Long idClient;


    public TeacherResponseDTO(Long id, String cpf, String nome, String email, Long idDiscipline, Long idClient) {
        this.id = id;
        this.cpf = cpf;
        this.name = nome;
        this.email = email;
        this.idDiscipline = idDiscipline;
        this.idClient = idClient;
    }

    public TeacherResponseDTO(TeacherModel teacherModel){
        this.id = teacherModel.getIdTeacher();
        this.cpf = teacherModel.getCpf();
        this.name = teacherModel.getName();
        this.email = teacherModel.getEmail();
        this.idDiscipline = teacherModel.getIdDiscipline();
        this.idClient = teacherModel.getClientModel().getId();
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
    public void setName(String nome) {
        this.name = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getIdDiscipline() {
        return idDiscipline;
    }
    public void setIdDiscipline(Long idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
        
}
