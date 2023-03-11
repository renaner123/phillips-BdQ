package com.phillips.saper.bancoquestoes.dtos;

public class SubjectRequestDTO {
    private String description;
    private int idDiscipline;

    public SubjectRequestDTO(String description, int amountAccess, int idDiscipline) {
        this.description = description;
        this.idDiscipline = idDiscipline;
    }
    public SubjectRequestDTO() {
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdDiscipline() {
        return idDiscipline;
    }
    public void setIdDiscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }

    
   
}
