package com.phillips.saper.bancoquestoes.dtos;


import com.phillips.saper.bancoquestoes.enums.CertifiedValues;

import io.swagger.v3.oas.annotations.media.Schema;

public class QuestionCertifiedEnumDTO {

    @Schema(allowableValues = {"TRUE", "FALSE", "NULL"})
    private CertifiedValues certified;

	public CertifiedValues getCertified() {
		return certified;
	}

	public void setCertified(CertifiedValues certified) {
		this.certified = certified;
	}

	public QuestionCertifiedEnumDTO(CertifiedValues certified) {
		this.certified = certified;
	}

	public QuestionCertifiedEnumDTO() {
	}
    
    
}
