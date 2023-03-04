package com.phillips.saper.bancoquestoes.models;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;
@Entity
public class CertifierModel extends TeacherModel {

    private int amountCertified;

    private ArrayList<SubjectModel> subjects = new ArrayList<SubjectModel>();

    public CertifierModel(int amountCertified, ArrayList<SubjectModel> subjects) {
        this.amountCertified = amountCertified;
        this.subjects = subjects;
    }

    /*
     * public CertifierModel() {
     * super();
     * }
     */
    public int getAmountCertified() {
        return amountCertified;
    }

    public void setAmountCertified(int amountCertified) {
        this.amountCertified = amountCertified;
    }

    public ArrayList<SubjectModel> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<SubjectModel> subjects) {
        this.subjects = subjects;
    }

}
