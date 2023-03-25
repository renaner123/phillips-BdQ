package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.StudentModel;

import io.swagger.v3.oas.annotations.media.Schema;

public class StudentResponseDTO {

    Long id;
    @Schema(example = "123.456.789-09")
    String cpf;
    @Schema(example = "User")
    String name;
    Long id_client;

    public StudentResponseDTO(StudentModel studentModel) {
        cpf = studentModel.getCpf();
        name = studentModel.getName();
        id = studentModel.getIdStudent();
        id_client = studentModel.getClientModel().getId();
    }

    public StudentResponseDTO(Long id, String cpf, String name, Long id_client) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.id_client = id_client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }

    public StudentResponseDTO() {
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

}
