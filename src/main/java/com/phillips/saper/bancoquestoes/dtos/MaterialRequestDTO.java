package com.phillips.saper.bancoquestoes.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class MaterialRequestDTO {

    String fileName;
    String content;
    Date uploadDate;
    int idTeacher;
    
}
