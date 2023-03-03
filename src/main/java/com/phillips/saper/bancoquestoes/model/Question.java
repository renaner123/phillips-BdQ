package com.phillips.saper.bancoquestoes.model;

import java.util.Date;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idQuestion;

    private Date updateDate;
    private String question;
    private String answers;
    private int difficulty;    

}
