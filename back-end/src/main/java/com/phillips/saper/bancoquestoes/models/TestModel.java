package com.phillips.saper.bancoquestoes.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class TestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_test")
    private Long idTest;

    @NotBlank
    private String name;

    @ElementCollection
    @CollectionTable(name = "answersHash", joinColumns = @JoinColumn(name = "test_id"))
    @MapKeyColumn(name = "key")
    @Column(name = "value")
    private Map<String, String> answersHash;
    private LocalDateTime dateTime;

    @ManyToMany(
              targetEntity = QuestionModel.class)
    @JoinTable(name = "Test_has_Question",
                joinColumns = @JoinColumn(name = "id_test"),
                inverseJoinColumns = @JoinColumn(name = "id_question"))
    Set<QuestionModel> questions;

    @ManyToMany(mappedBy = "tests")
    private Set<StudentModel> students = new HashSet<>();

    @OneToMany(mappedBy = "id.idTest", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StudentTest> studentTestSet = new HashSet<>();
     

}
