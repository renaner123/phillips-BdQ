package com.phillips.saper.bancoquestoes.dtos;

import java.time.LocalDateTime;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;

public class TestRequestDTO {
     //TODO Adicionar  @Schema(example = "") nos atributos e validações
    
    String name;
    //private LocalDateTime dateTest;    
    @Schema(example = "{ \"1\": \"A\", \"2\": \"B\", \"3\": \"C\"}")
    private Map<String, String> answersHash;
    LocalDateTime dateTime;


    public Map<String, String> getAnswersHash() {
        return answersHash;
    }

    public void setAnswersHash(Map<String, String> answersHash) {
        this.answersHash = answersHash;
    }

    public TestRequestDTO(String name, String answers, Map<String, String> answersHash) {
        this.name = name;
        this.answersHash = answersHash;
    }

    public TestRequestDTO(){

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
