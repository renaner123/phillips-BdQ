package com.phillips.saper.bancoquestoes.dtos;

import java.time.LocalDateTime;

import com.phillips.saper.bancoquestoes.models.TestModel;

public class TestResponseDTO {

    private Long id;
    private String name;
    //private LocalDateTime dateTest;    
    private String answers;
    private LocalDateTime dateTime;

    
    public TestResponseDTO(Long id, String name, String answers, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.answers = answers;
        this.dateTime = dateTime;
    }

    public TestResponseDTO(TestModel save) {
        this.id = save.getIdTest();
        this.name = save.getName();
        this.answers = save.getAnswers();
        this.dateTime = save.getDateTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
