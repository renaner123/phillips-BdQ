package com.phillips.saper.bancoquestoes.models;
import java.util.Date;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class MaterialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idMaterial;

    private String fileName;
    private String content;
    private Date uploadDate;
    private int idTeacher;
    
}
