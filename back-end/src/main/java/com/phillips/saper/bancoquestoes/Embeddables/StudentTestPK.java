package com.phillips.saper.bancoquestoes.Embeddables;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class StudentTestPK implements Serializable {

        @Column(name = "id_student")
        private Long idStudent;
    
        @Column(name = "id_test")
        private Long idTest;

        public StudentTestPK(Long idStudent, Long idTest) {
                this.idStudent = idStudent;
                this.idTest = idTest;
        }

        public StudentTestPK() {
        }

        public Long getIdStudent() {
                return idStudent;
        }

        public void setIdStudent(Long idStudent) {
                this.idStudent = idStudent;
        }

        public Long getIdTest() {
                return idTest;
        }

        public void setIdTest(Long idTest) {
                this.idTest = idTest;
        }


}
    

