package com.phillips.saper.bancoquestoes.dtos;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

public class TestCorrectRequestDTO {
    
    private Long idStudent;
    @Schema(example = "{ \"idQuestion1\": [\"1\"], \"idQuestion2\": [\"1\"], \"idQuestion3\": [\"1\",\"2\"]}")
    private Map<String, List<String>> answersHash;    

    public TestCorrectRequestDTO() {
    }

    public TestCorrectRequestDTO(Long idTest, Long idStudent ,Map<String, List<String>> answersHash) {
        this.answersHash = answersHash;
        this.idStudent = idStudent;
    }

    public Map<String, List<String>> getAnswersHash() {
        return answersHash;
    }

    public void setAnswersHash(Map<String, List<String>> answersHash) {
        this.answersHash = answersHash;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }



    
}
