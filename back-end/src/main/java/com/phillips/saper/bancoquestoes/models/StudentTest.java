package com.phillips.saper.bancoquestoes.models;

import java.io.Serializable;

import com.phillips.saper.bancoquestoes.Embeddable.StudentTestPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student_has_test")
public class StudentTest implements Serializable {

    @EmbeddedId
    private StudentTestPK id;

    @Column(name = "result")
    private double result;
    
}
