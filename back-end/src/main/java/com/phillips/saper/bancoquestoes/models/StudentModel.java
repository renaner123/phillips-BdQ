package com.phillips.saper.bancoquestoes.models;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStudent;

    private String cpf;
    private String name;
    private String email;

    @OneToOne(targetEntity = ClientModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client")
    ClientModel clientModel;

    // DUVIDA como inserir uma nova coluna nessa tabela? no caso, precisa inserir o resultado da prova, pro aluno consultar o desempenho depois
    @ManyToMany(
        targetEntity = TestModel.class)
    @JoinTable(name = "Student_has_Test",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_test"))
    Set<TestModel> tests;

}
