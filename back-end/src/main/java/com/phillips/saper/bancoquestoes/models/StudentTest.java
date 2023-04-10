package com.phillips.saper.bancoquestoes.models;

import java.io.Serializable;

import com.phillips.saper.bancoquestoes.Embeddables.StudentTestPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_has_test")
public class StudentTest implements Serializable {

    @EmbeddedId
    private StudentTestPK id;
    

    public StudentTest(StudentTestPK id) {
        this.id = id;
    }    

    public StudentTest(StudentTestPK id, double result) {
        this.id = id;
        this.result = result;
    }   

    public StudentTest() {
    }

    @Column(name = "result")
    private double result;

    public StudentTestPK getId() {
        return id;
    }

    public void setId(StudentTestPK id) {
        this.id = id;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    
}
