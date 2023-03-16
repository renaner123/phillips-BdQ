package com.phillips.saper.bancoquestoes.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

}
