package com.phillips.saper.bancoquestoes.dtos;

import java.util.Objects;

import com.phillips.saper.bancoquestoes.models.TeacherModel;

import io.swagger.v3.oas.annotations.media.Schema;

public class TeacherResponseDTO {

    Long id;
    @Schema(example = "123.456.789-09")
    String cpf;
    @Schema(example = "User ")
    String name;
    @Schema(example = "email@email.com")
    String email;
    @Schema(example = "1")
    Long idDiscipline;


    public TeacherResponseDTO(Long id, String cpf, String nome, String email, Long idDiscipline, Long idClient) {
        this.id = id;
        this.cpf = cpf;
        this.name = nome;
        this.email = email;
        this.idDiscipline = idDiscipline;
    }

    public TeacherResponseDTO(){

    }

    public TeacherResponseDTO(TeacherModel teacherModel){
        this.id = teacherModel.getIdTeacher();
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TeacherResponseDTO other = (TeacherResponseDTO) obj;
        return Objects.equals(cpf, other.cpf) &&
                name == other.name && email == other.email;
    }
        
}
