package com.phillips.saper.bancoquestoes.dtos;

import com.phillips.saper.bancoquestoes.models.StudentModel;
import java.time.LocalDateTime;

public class StudentTestResponseDTO {
    //TODO Adicionar  @Schema(example = "") nos atributos e validações

    Long idTest;
    double result;
    LocalDateTime date;
    
	public StudentTestResponseDTO(Long idTest, double result, LocalDateTime date) {
		this.idTest = idTest;
		this.result = result;
		this.date = date;
	}
	public Long getIdTest() {
		return idTest;
	}
	public void setIdTest(Long idTest) {
		this.idTest = idTest;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}







}
