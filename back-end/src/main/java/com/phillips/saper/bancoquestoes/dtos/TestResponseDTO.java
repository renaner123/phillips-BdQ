package com.phillips.saper.bancoquestoes.dtos;

import java.time.LocalDateTime;
import java.util.Map;

import com.phillips.saper.bancoquestoes.models.TestModel;

import io.swagger.v3.oas.annotations.media.Schema;

public class TestResponseDTO {

    private Long id;
    private String name;

    @Schema(example = "{ \"1\": \"A\", \"2\": \"B\", \"3\": \"C\"}")
    private Map<String, String> answersHash;
    private LocalDateTime dateTime;
    
    public Map<String, String> getAnswersHash() {
        return answersHash;
    }

    public void setAnswersHash(Map<String, String> answersHash) {
        this.answersHash = answersHash;
    }

    public TestResponseDTO(Long id, String name, LocalDateTime dateTime, Map<String, String> hash) {
        this.id = id;
        this.name = name;
        this.dateTime = dateTime;
        this.answersHash = hash;
    }

    public TestResponseDTO(TestModel save) {
        this.id = save.getIdTest();
        this.name = save.getName();
        this.dateTime = save.getDateTime();
        this.answersHash = save.getAnswersHash();
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

   


    

}
