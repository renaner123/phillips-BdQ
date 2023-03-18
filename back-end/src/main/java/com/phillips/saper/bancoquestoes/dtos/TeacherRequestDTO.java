package com.phillips.saper.bancoquestoes.dtos;

import org.hibernate.validator.constraints.br.CPF;

import com.phillips.saper.bancoquestoes.models.TeacherModel;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TeacherRequestDTO {
     //TODO Adicionar  @Schema(example = "") nos atributos e validações

    @CPF
    @NotBlank(message = "O campo cpf é obrigatório")
    String cpf;

    @Size(min = 3, max = 10, message = "Nome tem tamanho mínimo de 3 e máximo de 10")
    @NotBlank(message = "O campo nome é obrigatório")

    String name;

    @Size(min = 3, max = 10, message = "Password tem tamanho mínimo de 3 e máximo de 10")
    @NotBlank(message = "Password é obrigatório")
    String password;

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

    @NotBlank(message = "confirmação de senha obrigatória")
    String repeated_password;

    @Schema(example = "email@email.com")
    @Email(message = "Informe um email válido")
    @NotBlank(message = "Login é obrigatório")
    String login;
    
    int idDiscipline;

    public TeacherRequestDTO(@CPF @NotBlank(message = "O campo cpf é obrigatório") String cpf,
            @Size(min = 3, max = 10, message = "Nome tem tamanho mínimo de 3 e máximo de 10") @NotBlank(message = "O campo nome é obrigatório") String name,
            @Size(min = 3, max = 10, message = "Password tem tamanho mínimo de 3 e máximo de 10") @NotBlank(message = "Password é obrigatório") String password,
            @NotBlank(message = "confirmação de senha obrigatória") String repeated_password,
            @Email(message = "Informe um email válido") @NotBlank(message = "Login é obrigatório") String login,
            int idDiscipline) {
        this.cpf = cpf;
        this.name = name;
        this.password = password;
        this.repeated_password = repeated_password;
        this.login = login;
        this.idDiscipline = idDiscipline;
    }

    public TeacherRequestDTO(TeacherModel teacherModel){
        this.cpf = teacherModel.getCpf();
        this.name = teacherModel.getName();
        this.idDiscipline = teacherModel.getIdDiscipline();
        this.idDiscipline = teacherModel.getIdDiscipline();
    }
   

    public TeacherRequestDTO() {
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
    public void setName(String nome) {
        this.name = nome;
    }
    public int getIdDiscipline() {
        return idDiscipline;
    }
    public void setIdDiscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
