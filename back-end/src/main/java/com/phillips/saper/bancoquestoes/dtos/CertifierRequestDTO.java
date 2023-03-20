package com.phillips.saper.bancoquestoes.dtos;

public class CertifierRequestDTO {
    // apenas para teste, irei utilizar alguns atributos e metodos fake para testar
    // a interação do Postman

     //TODO Adicionar  @Schema(example = "") nos atributos e validações

    String name;
    int amountCertified;
    String cpf;
    String email;
    Long idDiscipline;

    public CertifierRequestDTO(String name, int amountCertified, String cpf, String email,
    Long idDiscipline) {
        this.name = name;
        this.amountCertified = amountCertified;
        this.cpf = cpf;
        this.email = email;
        this.idDiscipline = idDiscipline;
    }

    public CertifierRequestDTO() {
    }

    public int getAmountCertified() {
        return amountCertified;
    }

    public void setAmountCertified(int amountCertified) {
        this.amountCertified = amountCertified;
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

    public Long getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(Long idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

}
