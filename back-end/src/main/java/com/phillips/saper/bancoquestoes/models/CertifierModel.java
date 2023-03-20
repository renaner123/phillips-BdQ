package com.phillips.saper.bancoquestoes.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CertifierModel extends TeacherModel {

    @Column(nullable = true)
    private int amountCertified;
    // TODO criar set de Subject

    //private ArrayList<SubjectModel> subjects = new ArrayList<SubjectModel>();
    
    public CertifierModel(String cpf, String name, String email, Long idDiscipline, int amountCertified, boolean certifier) {
        super(cpf, name, email, idDiscipline, false);
        this.amountCertified = amountCertified;
    }
    
    public CertifierModel(int amountCertified) {
        this.amountCertified = amountCertified;
    }

    public CertifierModel(){};

    public int getAmountCertified() {
        return amountCertified;
    }

    public void setAmountCertified(int amountCertified) {
        this.amountCertified = amountCertified;
    }
}
