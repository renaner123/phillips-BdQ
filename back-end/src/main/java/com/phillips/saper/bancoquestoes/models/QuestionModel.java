package com.phillips.saper.bancoquestoes.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class QuestionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuestion;

    private LocalDateTime updateDate;
    private String question;
    @ElementCollection
    @CollectionTable(name = "answersList", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "value")
    private List<String> answers;
    
    @ElementCollection
    @CollectionTable(name = "answersSheetList", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "value")
    private List<String> answersSheet;
    private int difficulty;    
    private Boolean certified;
    private int amountAccess;
    private Long idDiscipline;
    private Long idSubject;
    private String tag;

    @ManyToMany(
        targetEntity = TestModel.class,
        mappedBy = "questions")
    Set<TestModel> tests;

    @ManyToMany(
        targetEntity = TeacherModel.class,
        mappedBy = "questions")
    Set<TeacherModel> teachers;

    public QuestionModel(String question, List<String> answers, List<String> answersSheet, int difficulty,
            Long idDiscipline, Long idSubject) {
        this.question = question;
        this.answers = answers;
        this.answersSheet = answersSheet;
        this.difficulty = difficulty;
        this.idDiscipline = idDiscipline;
        this.idSubject = idSubject;
    }

    public QuestionModel() {
    }

    

}
