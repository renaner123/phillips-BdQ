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
    
    public TestModel(Long idTest, @NotBlank String name, Map<String, String> answersHash, LocalDateTime dateTime,
            Set<QuestionModel> questions, Set<StudentModel> students, Set<StudentTest> studentTestSet) {
        this.idTest = idTest;
        this.name = name;
        this.answersHash = answersHash;
        this.dateTime = dateTime;
        this.questions = questions;
        this.students = students;
        this.studentTestSet = studentTestSet;
    }

    public TestModel() {
    }

    public Long getIdTest() {
        return idTest;
    }

    public void setIdTest(Long idTest) {
        this.idTest = idTest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAnswersHash() {
        return answersHash;
    }

    public void setAnswersHash(Map<String, String> answersHash) {
        this.answersHash = answersHash;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Set<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<QuestionModel> questions) {
        this.questions = questions;
    }

    public Set<StudentModel> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentModel> students) {
        this.students = students;
    }

    public Set<StudentTest> getStudentTestSet() {
        return studentTestSet;
    }

    public void setStudentTestSet(Set<StudentTest> studentTestSet) {
        this.studentTestSet = studentTestSet;
    }
     
    

}
