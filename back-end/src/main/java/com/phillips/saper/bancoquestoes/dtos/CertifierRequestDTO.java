package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.CertifierModel;

public class CertifierRequestDTO {
    // apenas para teste, irei utilizar alguns atributos e metodos fake para testar
    // a interação do Postman

     //TODO Adicionar  @Schema(example = "") nos atributos e validações

    String name;
    String cpf;
    String login;
    String password;
    String repeated_password;
    Long idDiscipline;
    
    public CertifierRequestDTO(String name, String cpf, String login, String password, String repeated_password,
            Long idDiscipline) {
        this.name = name;
        this.cpf = cpf;
        this.login = login;
        this.password = password;
        this.repeated_password = repeated_password;
        this.idDiscipline = idDiscipline;
    }

    public CertifierRequestDTO(CertifierModel certifierModel){
        this.cpf = certifierModel.getCpf();
        this.name = certifierModel.getName();
        this.idDiscipline = certifierModel.getIdDiscipline();
        this.idDiscipline = certifierModel.getIdDiscipline();
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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRepeated_password() {
        return repeated_password;
    }
    public void setRepeated_password(String repeated_password) {
        this.repeated_password = repeated_password;
    }
    public Long getIdDiscipline() {
        return idDiscipline;
    }
    public void setIdDiscipline(Long idDiscipline) {
        this.idDiscipline = idDiscipline;
    }


}
