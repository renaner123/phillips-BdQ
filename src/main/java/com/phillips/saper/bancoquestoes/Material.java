package com.phillips.saper.bancoquestoes;
import java.util.Date;

import lombok.Data;

@Data
public class Material {

    private int idMaterial;
    private String fileName;
    private String content;
    private Date uploadDate;
    private int idTeacher;
    
}
