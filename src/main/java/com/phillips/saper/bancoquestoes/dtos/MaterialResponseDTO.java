package com.phillips.saper.bancoquestoes.dtos;

import java.sql.Date;

import com.phillips.saper.bancoquestoes.models.MaterialModel;

public class MaterialResponseDTO {

    private String fileName;
    private String content;
    private Date uploadDate;
    private int idTeacher;

    

    public MaterialResponseDTO() {
    }

    public MaterialResponseDTO(MaterialModel materialModel) {
        fileName = materialModel.getFileName();
        content = materialModel.getContent();
        uploadDate = (Date) materialModel.getUploadDate();
        idTeacher = materialModel.getIdTeacher();
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

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

}
