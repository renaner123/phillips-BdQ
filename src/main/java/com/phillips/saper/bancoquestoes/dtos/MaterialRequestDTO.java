package com.phillips.saper.bancoquestoes.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class MaterialRequestDTO {

    private String fileName;
    private String content;
    private Date uploadDate;
    private int idTeacher;
    
}
