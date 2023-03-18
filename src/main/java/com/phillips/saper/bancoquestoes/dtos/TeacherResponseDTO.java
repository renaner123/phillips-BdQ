package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.TeacherModel;

public class TeacherResponseDTO {
     //TODO Adicionar  @Schema(example = "") nos atributos e validações
    
    String cpf;
    String name;
    String email;
    int idDiscipline;

    public TeacherResponseDTO(String cpf, String nome, String email, int idDiscipline) {
        this.cpf = cpf;
        this.name = nome;
        this.email = email;
        this.idDiscipline = idDiscipline;
    }

    public TeacherResponseDTO(TeacherModel teacherModel){
        this.cpf = teacherModel.getCpf();
        this.name = teacherModel.getName();
        this.email = teacherModel.getEmail();
        this.idDiscipline = teacherModel.getIdDiscipline();
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
    public int getIdDiscipline() {
        return idDiscipline;
    }
    public void setIdDiscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }
        
}
