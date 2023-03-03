package com.phillips.saper.bancoquestoes.model;
import java.util.Date;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idMaterial;

    private String fileName;
    private String content;
    private Date uploadDate;
    private int idTeacher;
    
}
