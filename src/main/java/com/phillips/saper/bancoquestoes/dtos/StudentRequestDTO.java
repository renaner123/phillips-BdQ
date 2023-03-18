package com.phillips.saper.bancoquestoes.dtos;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO {
    //TODO Adicionar  @Schema(example = "") nos atributos e validações
       
    @Size(min = 3, max = 10, message = "Nome tem tamanho mínimo de 3 e máximo de 10")
    @NotBlank(message = "O campo nome é obrigatório")
    String name;

    @CPF
    @NotBlank(message = "O campo cpf é obrigatório")
    private String cpf;

    @Email(message = "Informe um email válido")
    @NotBlank(message = "Login é obrigatório")
    String login;

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

    @Size(min = 3, max = 10, message = "Password tem tamanho mínimo de 3 e máximo de 10")
    @NotBlank(message = "Password é obrigatório")
    String password;

    @NotBlank(message = "confirmação de senha obrigatória")
    String repeated_password;

    public StudentRequestDTO(String name, String login, String password, String repeated_password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.repeated_password = repeated_password;
    }

    public StudentRequestDTO() {
    }

    

}
