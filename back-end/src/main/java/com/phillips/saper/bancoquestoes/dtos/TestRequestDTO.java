package com.phillips.saper.bancoquestoes.dtos;

public class TestRequestDTO {
    
    Long idDiscipline;
    Long idSubject;
    int numberOfQuestions;
    
    public TestRequestDTO(Long idDiscipline, Long idSubject, int numberOfQuestions) {
        this.idDiscipline = idDiscipline;
        this.idSubject = idSubject;
        this.numberOfQuestions = numberOfQuestions;
    }

    public TestRequestDTO() {
    }

    public Long getIdDiscipline() {
        return idDiscipline;
    }

    public void setIdDiscipline(Long idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    public Long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Long idSubject) {
        this.idSubject = idSubject;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }


    
}
