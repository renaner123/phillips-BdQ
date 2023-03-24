package com.phillips.saper.bancoquestoes.models;

import java.time.LocalDateTime;
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
    private LocalDateTime uploadDate;
    private Long idClient;
    private String docType;
    private int amountAccess;
    private String tag;

    @Lob
	private byte[] data;

    @ManyToMany(
        targetEntity = StudentModel.class)
    @JoinTable(name = "Material_has_Student",
            joinColumns = @JoinColumn(name = "id_material"),
            inverseJoinColumns = @JoinColumn(name = "id_student"))
    Set<StudentModel> students;

    public MaterialModel(String fileName, String content, LocalDateTime uploadDate, Long idClient, String docType, byte[] data, int amountAccess, String tag) {
        this.fileName = fileName;
        this.content = content;
        this.uploadDate = uploadDate;
        this.idClient = idClient;
        this.docType = docType;
        this.data = data;
        this.amountAccess = amountAccess;
        this.tag = tag;
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

    public MaterialModel(String docname, String contentType, byte[] bytes, int amountAccess, String tag) {
        this.fileName = docname;
        this.docType = contentType;
        this.data = bytes;
        this.amountAccess = amountAccess;
        this.tag = tag;
    }

    public MaterialModel(String docname, String contentType, byte[] bytes, int amountAccess) {
        this.fileName = docname;
        this.docType = contentType;
        this.data = bytes;
        this.amountAccess = amountAccess;
    }

    public void setDocType(String docType) {
		this.docType = docType;
	}

	public int getAmountAccess() {
		return amountAccess;
	}

	public void setAmountAccess(int amountAccess) {
		this.amountAccess = amountAccess;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public void setStudents(Set<StudentModel> students) {
		this.students = students;
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

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
