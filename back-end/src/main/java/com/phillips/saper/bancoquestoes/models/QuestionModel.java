package com.phillips.saper.bancoquestoes.models;

import java.time.LocalDateTime;
import java.util.Set;

import org.aspectj.weaver.ast.Test;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String answers;
    private int difficulty;    
    private Boolean certified;
    private int amountAccess;
    private int idDiscipline;
    private int idSubject;

    @ManyToMany(
        targetEntity = TestModel.class,
        mappedBy = "questions")
    Set<TestModel> tests;

    @ManyToMany(
        targetEntity = TeacherModel.class,
        mappedBy = "questions")
    Set<TeacherModel> teachers;

}
