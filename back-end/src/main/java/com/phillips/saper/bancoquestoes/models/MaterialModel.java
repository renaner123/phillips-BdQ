package com.phillips.saper.bancoquestoes.models;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;

//@Data
@Entity
public class MaterialModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial;

    private String fileName;
    private String content;
    private Date uploadDate;
    private Long idTeacher;
    private String docType;

    @Lob
	private byte[] data;

    @ManyToMany(
        targetEntity = StudentModel.class)
    @JoinTable(name = "Material_has_Student",
            joinColumns = @JoinColumn(name = "id_material"),
            inverseJoinColumns = @JoinColumn(name = "id_student"))
    Set<StudentModel> students;

    public MaterialModel(String fileName, String content, Date uploadDate, Long idTeacher, String docType, byte[] data) {
        this.fileName = fileName;
        this.content = content;
        this.uploadDate = uploadDate;
        this.idTeacher = idTeacher;
        this.docType = docType;
        this.data = data;
    }

    public String getDocType() {
        return docType;
    }

    public byte[] getData() {
        return data;
    }

    public Set<StudentModel> getStudents() {
        return students;
    }

    public MaterialModel() {
    }

    public MaterialModel(String docname, String contentType, byte[] bytes) {
        this.fileName = docname;
        this.docType = contentType;
        this.data = bytes;
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
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

}
