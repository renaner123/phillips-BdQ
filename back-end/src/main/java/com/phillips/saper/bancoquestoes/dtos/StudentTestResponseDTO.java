package com.phillips.saper.bancoquestoes.dtos;
import java.time.LocalDateTime;

public class StudentTestResponseDTO {
    //TODO Adicionar  @Schema(example = "") nos atributos e validações

    Long idTest;
    double result;
    LocalDateTime date;
	String name;
    
	public StudentTestResponseDTO(Long idTest, double result, LocalDateTime date, String name) {
		this.idTest = idTest;
		this.result = result;
		this.date = date;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}







}
