package com.phillips.saper.bancoquestoes.models;

import java.util.ArrayList;

public class CertifierModel extends TeacherModel {
    
    private int amountCertified;

    private ArrayList<SubjectModel> subjects = new ArrayList<SubjectModel>();

    public CertifierModel() {
        super();
    }

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
