package com.phillips.saper.bancoquestoes.utils;

import java.text.DecimalFormat;

public class Formatter {


    public static double FormatterDoubleTwoCases(double numberDouble){
        DecimalFormat df = new DecimalFormat("#.##"); // Define o formato com duas casas decimais
        String formattedResult = df.format(numberDouble); // Formata o resultado
        double roundedResult = Double.parseDouble(formattedResult); // Converte o resultado formatado de volta para double
        return roundedResult;        
    }
    
}
