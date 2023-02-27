package com.phillips.saper.bancoquestoes;

import java.util.Date;

import lombok.Data;

@Data
public class Question {

    private int idQuestion;
    private Date updateDate;
    private String question;
    private String answers;
    private int difficulty;    

}
