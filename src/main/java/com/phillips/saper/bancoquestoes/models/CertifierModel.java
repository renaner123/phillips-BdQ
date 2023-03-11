package com.phillips.saper.bancoquestoes.models;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
@Entity
public class CertifierModel extends TeacherModel {

    @Column(nullable = true)
    int amountCertified;
    // TODO criar set de Subject

    //private ArrayList<SubjectModel> subjects = new ArrayList<SubjectModel>();

    public CertifierModel(int amountCertified, ArrayList<SubjectModel> subjects) {
        this.amountCertified = amountCertified;
    }
    
    public CertifierModel() {
        super();
    }
    
    public int getAmountCertified() {
        return amountCertified;
    }

    public void setAmountCertified(int amountCertified) {
        this.amountCertified = amountCertified;
    }
}
