package com.phillips.saper.bancoquestoes.dtos;

import java.time.LocalDateTime;

public class QuestionRequestDTO {

    private LocalDateTime updateDate;
    private String question;
    private String answers;
    private int difficulty;    
    private Boolean certified;
    private int idDiscipline;
    private int idSubject;

    public QuestionRequestDTO() {
    }

    public QuestionRequestDTO(LocalDateTime updateDate, String question, String answers, int difficulty, Boolean certified,
            int amountAccess, int idDiscipline, int idSubject) {
        this.updateDate = updateDate;
        this.question = question;
        this.answers = answers;
        this.difficulty = difficulty;
        this.certified = certified;
        this.idDiscipline = idDiscipline;
        this.idSubject = idSubject;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswers() {
        return answers;
    }
    public void setAnswers(String answers) {
        this.answers = answers;
    }
    public int getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
    public Boolean getCertified() {
        return certified;
    }
    public void setCertified(Boolean certified) {
        this.certified = certified;
    }
    public int getIdDiscipline() {
        return idDiscipline;
    }
    public void setIdDiscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }
    public int getIdSubject() {
        return idSubject;
    }
    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    } 

    
}
