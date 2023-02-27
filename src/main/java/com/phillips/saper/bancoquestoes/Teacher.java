package com.phillips.saper.bancoquestoes;

import lombok.Data;

@Data
public class Teacher {

    public Teacher() {
    }

    private int idTeacher;
    private String cpf;
    private String nome;
    private String email;
    private int idDiscipline;
       
}
