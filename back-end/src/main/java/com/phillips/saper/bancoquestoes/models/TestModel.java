package com.phillips.saper.bancoquestoes.models;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class TestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTest;

    private String name;
    private String answers;
    private LocalDateTime dateTime;

    @ManyToMany(
              targetEntity = QuestionModel.class)
    @JoinTable(name = "Test_has_Question",
                joinColumns = @JoinColumn(name = "id_test"),
                inverseJoinColumns = @JoinColumn(name = "id_quest"))
    Set<QuestionModel> questions;

    @ManyToMany(
        targetEntity = StudentModel.class,
        mappedBy = "tests")
    Set<StudentModel> students;
     

}
