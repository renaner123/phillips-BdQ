package com.phillips.saper.bancoquestoes.dtos;

import java.time.LocalDateTime;

import com.phillips.saper.bancoquestoes.models.TestModel;

public class TestResponseDTO {

    private String name;
    //private LocalDateTime dateTest;    
    private String answers;
    private LocalDateTime dateTime;

    
    public TestResponseDTO(String name, String answers, LocalDateTime dateTime) {
        this.name = name;
        this.answers = answers;
        this.dateTime = dateTime;
    }

    public TestResponseDTO(TestModel save) {
        this.name = save.getName();
        this.answers = save.getAnswers();
        this.dateTime = save.getDateTime();
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
