package com.phillips.saper.bancoquestoes.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
    private int idTest;

    private String name;
    private Date date;
    //Map<Integer,String> example = new HashMap<Integer,String>();
    
}
