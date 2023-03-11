package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.StudentModel;

public class StudentResponseDTO {

    private String cpf;
    private String name;
    private String email;

    public StudentResponseDTO(StudentModel studentModel) {
        cpf = studentModel.getCpf();
        name = studentModel.getName();
        email = studentModel.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
