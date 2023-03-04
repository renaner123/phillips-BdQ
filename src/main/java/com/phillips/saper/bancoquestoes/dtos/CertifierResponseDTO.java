package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.CertifierModel;

public class CertifierResponseDTO {
    // apenas para teste, irei utilizar alguns atributos e metodos fake para testar
    // a interação do Postman

    String name;
    int id_dos_brother;
    String cpf;

    public CertifierResponseDTO(String name, int id_dos_brother, String cpf) {
        this.name = name;
        this.id_dos_brother = id_dos_brother;
        this.cpf = cpf;
    }

    public CertifierResponseDTO() {
    }

    public CertifierResponseDTO(CertifierModel certifier) {
        name = certifier.getNome();
        cpf = certifier.getCpf();
        id_dos_brother = certifier.getIdDiscipline();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_dos_brother() {
        return id_dos_brother;
    }

    public void setId_dos_brother(int id_dos_brother) {
        this.id_dos_brother = id_dos_brother;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    

}
