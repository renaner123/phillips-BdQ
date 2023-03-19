package com.phillips.saper.bancoquestoes.Embeddables;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class StudentTestPK implements Serializable {

        @Column(name = "id_student")
        private Long idStudent;
    
        @Column(name = "id_test")
        private Long idTest;

}
    

