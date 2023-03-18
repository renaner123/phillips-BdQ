package com.phillips.saper.bancoquestoes.dtos;

import java.time.LocalDateTime;

import com.phillips.saper.bancoquestoes.models.QuestionModel;

public class QuestionResponseDTO {
    //TODO Adicionar  @Schema(example = "") nos atributos e validações
    private LocalDateTime updateDate;
    private String question;
    private String answers;
    private int difficulty;    
    private Boolean certified;
    private int amountAccess;
    private int idDiscipline;

    public QuestionResponseDTO() {
    }
    private int idSubject;
    public QuestionResponseDTO(LocalDateTime updateDate, String question, String answers, int difficulty, Boolean certified,
            int amountAccess, int idDiscipline, int idSubject) {
        this.updateDate = updateDate;
        this.question = question;
        this.answers = answers;
        this.difficulty = difficulty;
        this.certified = certified;
        this.amountAccess = amountAccess;
        this.idDiscipline = idDiscipline;
        this.idSubject = idSubject;
    }

    public QuestionResponseDTO(QuestionModel questionModel){
        this.updateDate = questionModel.getUpdateDate();
        this.question = questionModel.getQuestion();
        this.answers = questionModel.getAnswers();
        this.difficulty = questionModel.getDifficulty();
        this.certified = questionModel.getCertified();
        this.amountAccess = questionModel.getAmountAccess();
        this.idDiscipline = questionModel.getIdDiscipline();
        this.idSubject = questionModel.getIdSubject();   

    }
    public LocalDateTime getUpdateLocalDateTime() {
        return updateDate;
    }
    public void setUpdateLocalDateTime(LocalDateTime updateDate) {
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
    public int getAmountAccess() {
        return amountAccess;
    }
    public void setAmountAccess(int amountAccess) {
        this.amountAccess = amountAccess;
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
