package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.SubjectModel;

public class SubjectResponseDTO {
     //TODO Adicionar  @Schema(example = "") nos atributos e validações
    private String description;
    private int amountAccess;
    private int idDiscipline;
    
    public SubjectResponseDTO(String description, int amountAccess, int idDiscipline) {
        this.description = description;
        this.amountAccess = amountAccess;
        this.idDiscipline = idDiscipline;
    }
    
    public SubjectResponseDTO(SubjectModel subjectModel){
        this.description = subjectModel.getDescription();
        this.amountAccess = subjectModel.getAmountAccess();
        this.idDiscipline = subjectModel.getIdDiscipline();
    }

    public SubjectResponseDTO() {
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getAmountAccess() {
        return amountAccess;
    }
    public void setAmountAccess(int amountAccess) {
        this.amountAccess = amountAccess;
    }
    public int getIdDscipline() {
        return idDiscipline;
    }
    public void setIdDscipline(int idDiscipline) {
        this.idDiscipline = idDiscipline;
    }
}
