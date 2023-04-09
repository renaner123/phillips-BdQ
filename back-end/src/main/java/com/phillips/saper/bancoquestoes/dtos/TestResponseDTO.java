package com.phillips.saper.bancoquestoes.dtos;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import com.phillips.saper.bancoquestoes.models.QuestionModel;
import com.phillips.saper.bancoquestoes.models.TestModel;

public class TestResponseDTO {

    private Long idTest;
    private String name;

    private LocalDateTime dateTime;
    private Set<QuestionModel> questions;  

    public TestResponseDTO(Long idTest, String name, LocalDateTime dateTime, Map<String, String> hash, Set<QuestionModel> questions) {
        this.idTest = idTest;
        this.name = name;
        this.dateTime = dateTime;
        this.questions = questions;
    }

    public TestResponseDTO() {
    }

    public TestResponseDTO(TestModel save) {
        this.idTest = save.getIdTest();
        this.name = save.getName();
        this.dateTime = save.getDateTime();
        Set<QuestionModel> questionOcult = save.getQuestions();
        // Informações que o estudante não deve ver
        for(QuestionModel question : questionOcult){
            question.setAnswersSheet(null);
            question.setTeachers(null);
            question.setTests(null);
        }
        this.questions = questionOcult;
    }

    public Long getidTest() {
        return idTest;
    }

    public Set<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionModel> questions) {
        this.questions = questions;
    }

    public void setidTest(Long idTest) {
        this.idTest = idTest;
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
