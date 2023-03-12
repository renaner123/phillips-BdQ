package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.StudentModel;

public class StudentResponseDTO {

    Long id;
    String cpf;
    String name;
    Long client_id;

    public StudentResponseDTO(StudentModel studentModel) {
        cpf = studentModel.getCpf();
        name = studentModel.getName();
        id = studentModel.getIdStudent();
        client_id = studentModel.getIdStudent();
    }

    public StudentResponseDTO(Long id, String cpf, String name, Long client_id) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.client_id = client_id;
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
