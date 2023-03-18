package com.phillips.saper.bancoquestoes.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class MaterialRequestDTO {
     //TODO Adicionar  @Schema(example = "") nos atributos e validações
    String fileName;
    String content;
    Date uploadDate;
    int idTeacher;
    
}
