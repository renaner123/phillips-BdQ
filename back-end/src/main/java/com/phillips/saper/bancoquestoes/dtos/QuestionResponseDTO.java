package com.phillips.saper.bancoquestoes.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.phillips.saper.bancoquestoes.models.QuestionModel;

public class QuestionResponseDTO {
    //TODO Adicionar  @Schema(example = "") nos atributos e validações
    private Long id;
    private LocalDateTime updateDate;
    private String question;
    private List<String> answers;
    private int difficulty;    
    private Boolean certified;
    private int amountAccess;
    private Long idDiscipline;
    private String tag;

    public QuestionResponseDTO() {
    }
    private Long idSubject;

    public QuestionResponseDTO(Long id, LocalDateTime updateDate, String question, List<String> answers, int difficulty,int amountAccess, Long idDiscipline, Long idSubject, String tag) {
        this.id = id;
        this.updateDate = updateDate;
        this.question = question;
        this.answers = answers;
        this.difficulty = difficulty;
        this.amountAccess = amountAccess;
        this.idDiscipline = idDiscipline;
        this.idSubject = idSubject;
        this.tag = tag;
    }

    public QuestionResponseDTO(QuestionModel questionModel){
        this.id = questionModel.getIdQuestion();
        this.updateDate = questionModel.getUpdateDate();
        this.question = questionModel.getQuestion();
        this.answers = questionModel.getAnswers();
        this.difficulty = questionModel.getDifficulty();
        this.certified = questionModel.getCertified();
        this.amountAccess = questionModel.getAmountAccess();
        this.idDiscipline = questionModel.getIdDiscipline();
        this.idSubject = questionModel.getIdSubject();   
        this.tag = questionModel.getTag();

    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
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
    public List<String> getAnswers() {
        return answers;
    }
    public void setAnswers(List<String> answers) {
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	} 

        
}
