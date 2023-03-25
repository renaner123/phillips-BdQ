package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.CertifierModel;
import com.phillips.saper.bancoquestoes.models.TeacherModel;

public class CertifierResponseDTO {
    // apenas para teste, irei utilizar alguns atributos e metodos fake para testar
    // a interação do Postman
     //TODO Adicionar  @Schema(example = "") nos atributos e validações
     Long id;
     String cpf;
     String name;
     String email;
     Long idDiscipline;
    int amountCertified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getAmountCertified() {
        return amountCertified;
    }

    public void setAmountCertified(int amountCertified) {
        this.amountCertified = amountCertified;
    }

    public CertifierResponseDTO(String name, int id_dos_brother, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public CertifierResponseDTO() {
    }

    public CertifierResponseDTO(Long id, String cpf, String name, String email, Long idDiscipline, Long idClient,
            int amountCertified) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.idDiscipline = idDiscipline;
        this.amountCertified = amountCertified;
    }

    
    public CertifierResponseDTO(TeacherModel teacherModel){
        this.id = teacherModel.getIdTeacher();
        this.cpf = teacherModel.getCpf();
        this.name = teacherModel.getName();
        this.email = teacherModel.getEmail();
        this.idDiscipline = teacherModel.getIdDiscipline();
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


    

    

}
