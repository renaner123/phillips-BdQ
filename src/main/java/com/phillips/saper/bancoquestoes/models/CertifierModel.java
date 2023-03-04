package com.phillips.saper.bancoquestoes.models;

import java.util.ArrayList;

import jakarta.persistence.Entity;
@Entity
public class CertifierModel extends TeacherModel {

    private int amountCertified;

    //private ArrayList<SubjectModel> subjects = new ArrayList<SubjectModel>();

    public CertifierModel(int amountCertified, ArrayList<SubjectModel> subjects) {
        this.amountCertified = amountCertified;
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
}
