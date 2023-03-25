package com.phillips.saper.bancoquestoes.dtos;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class StudentRequestDTO {

    @Size(min = 3, max = 55, message = "Nome tem tamanho mínimo de 3 e máximo de 55")
    @Schema(example = "User")
    @NotBlank(message = "O campo nome é obrigatório")
    String name;

    @CPF
    @Schema(example = "082.991.529-09")
    @NotBlank(message = "O campo cpf é obrigatório")
    private String cpf;

    @Email(message = "Informe um email válido")
    @Schema(example = "email@email.com")
    @NotBlank(message = "Login é obrigatório")
    String login;

    @Size(min = 8, max = 55, message = "Password tem tamanho mínimo de 8 e máximo de 55")
    @NotBlank(message = "Password é obrigatório")
    String password;

    @Size(min = 8, max = 55, message = "Password tem tamanho mínimo de 8 e máximo de 55")
    @NotBlank(message = "confirmação de senha obrigatória")
    String repeated_password;

    public StudentRequestDTO(String name, String login, String password, String repeated_password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.repeated_password = repeated_password;
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

    public StudentRequestDTO() {
    }

}
