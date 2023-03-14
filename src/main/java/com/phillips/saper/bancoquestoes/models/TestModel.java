package com.phillips.saper.bancoquestoes.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    // Map<Long,String> example = new HashMap<Long,String>();

}
