package com.phillips.saper.bancoquestoes.dtos;

import java.util.Objects;

import com.phillips.saper.bancoquestoes.models.DisciplineModel;


public class DisciplineResponseDTO {
    //TODO Adicionar  @Schema(example = "") nos atributos e validações
    String name;
    String description;
    
    public DisciplineResponseDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }    

    public DisciplineResponseDTO() {
    }

    public DisciplineResponseDTO(DisciplineModel disciplineModel) {
        name = disciplineModel.getName();
        description = disciplineModel.getDescrption_Discipline();
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DisciplineResponseDTO other = (DisciplineResponseDTO) obj;
        return Objects.equals(description, other.description) &&
                name == other.name;
    }
    
}
