package com.phillips.saper.bancoquestoes.dtos;

import java.sql.Date;
import java.time.LocalDateTime;

import com.phillips.saper.bancoquestoes.models.MaterialModel;

public class MaterialResponseDTO {
    //TODO Adicionar  @Schema(example = "") nos atributos e validações
    Long id;
    String fileName;
    LocalDateTime uploadDate;
    Long idClient;
    String docType;
    int amountAccess;
    

    public MaterialResponseDTO() {
    }

    public MaterialResponseDTO(MaterialModel materialModel) {
        id = materialModel.getIdMaterial();
        fileName = materialModel.getFileName();
        uploadDate = materialModel.getUploadDate();
        idClient = materialModel.getIdClient();
        docType = materialModel.getDocType();
        amountAccess = materialModel.getAmountAccess();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public int getAmountAccess() {
		return amountAccess;
	}

	public void setAmountAccess(int amountAccess) {
		this.amountAccess = amountAccess;
	}

}
