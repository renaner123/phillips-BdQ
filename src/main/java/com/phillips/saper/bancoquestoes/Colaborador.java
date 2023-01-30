package com.phillips.saper.bancoquestoes;

import lombok.Data;

//O lombok faz a função do get/set
@Data

public class Colaborador extends Pessoa {
    private int nivel = 10;

    private String areaDeAtuacao = "Tecnologia";


}

