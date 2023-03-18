package com.phillips.saper.bancoquestoes.dtos;

public class DisciplineRequestDTO {

    String name;
    String description;
    //TODO Adicionar  @Schema(example = "") nos atributos e validações
    
    public DisciplineRequestDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }    

    public DisciplineRequestDTO() {
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    
    
}
