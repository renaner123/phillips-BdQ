package com.phillips.saper.bancoquestoes.dtos;

import java.sql.Date;

import com.phillips.saper.bancoquestoes.models.MaterialModel;

public class MaterialResponseDTO {
    //TODO Adicionar  @Schema(example = "") nos atributos e validações
    String fileName;
    String content;
    Date uploadDate;
    Long idTeacher;
    String docType;
    

    public MaterialResponseDTO() {
    }

    public MaterialResponseDTO(MaterialModel materialModel) {
        fileName = materialModel.getFileName();
        content = materialModel.getContent();
        uploadDate = (Date) materialModel.getUploadDate();
        idTeacher = materialModel.getIdTeacher();
        docType = materialModel.getDocType();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Long getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(Long idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

}
