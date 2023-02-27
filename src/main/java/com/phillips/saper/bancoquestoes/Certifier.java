package com.phillips.saper.bancoquestoes;
import java.util.ArrayList;

public class Certifier extends Teacher {
    
    private int amountCertified;

    private ArrayList<Subject> subjects = new ArrayList<Subject>();

    public Certifier() {
        super();
    }

    public int getAmountCertified() {
        return amountCertified;
    }

    public void setAmountCertified(int amountCertified) {
        this.amountCertified = amountCertified;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }


    
}
