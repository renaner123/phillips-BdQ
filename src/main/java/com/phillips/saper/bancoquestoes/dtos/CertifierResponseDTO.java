package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.CertifierModel;

public class CertifierResponseDTO {
    // apenas para teste, irei utilizar alguns atributos e metodos fake para testar
    // a interação do Postman

    String name;
    String cpf;
    String idTeacher;

    public CertifierResponseDTO(String name, int id_dos_brother, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public CertifierResponseDTO() {
    }

    public CertifierResponseDTO(CertifierModel certifier) {
        name = certifier.getName();
        cpf = certifier.getCpf();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(String idTeacher) {
        this.idTeacher = idTeacher;
    }

    

    

}
