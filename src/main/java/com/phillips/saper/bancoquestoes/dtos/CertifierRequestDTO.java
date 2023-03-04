package com.phillips.saper.bancoquestoes.dtos;



public class CertifierRequestDTO {
    //apenas para teste, irei utilizar alguns atributos e metodos fake para testar a interação do Postman

    String name;

    int number;

    public CertifierRequestDTO(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public CertifierRequestDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    

    
    
}
