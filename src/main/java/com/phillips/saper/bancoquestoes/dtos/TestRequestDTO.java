package com.phillips.saper.bancoquestoes.dtos;

import java.time.LocalDateTime;

public class TestRequestDTO {
    
    String name;
    //private LocalDateTime dateTest;    
    String answers;
    LocalDateTime dateTime;


    public TestRequestDTO(String name, String answers) {
        this.name = name;
        this.answers = answers;
    }

    public TestRequestDTO(){

    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAnswers() {
        return answers;
    }
    public void setAnswers(String answers) {
        this.answers = answers;
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
