package com.phillips.saper.bancoquestoes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Test {

    private int idTest;
    private String name;
    private Date date;
    Map<Integer,String> example = new HashMap<Integer,String>();
    
}
