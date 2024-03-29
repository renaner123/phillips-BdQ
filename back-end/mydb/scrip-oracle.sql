-- Generated by Oracle SQL Developer Data Modeler 22.2.0.165.1149
--   at:        2023-02-21 23:47:19 BRT
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE system.certifier (
    certifier_id       NUMBER NOT NULL,
    amount_certified   NUMBER(10),
    id_teacher         NUMBER(10) NOT NULL,
    teacher_id_teacher NUMBER(10)
);

CREATE UNIQUE INDEX system."SYSTEM.CERTIFIER__IDX" ON
    system.certifier (
        id_teacher
    ASC );

ALTER TABLE system.certifier ADD CONSTRAINT certifier_pk PRIMARY KEY ( certifier_id );

CREATE TABLE system.certifier_has_subject (
    certifier_teacher_id_teacher           NUMBER(10) NOT NULL,
    subject_id_subject                     NUMBER(10) NOT NULL, 
--  ERROR: Column name length exceeds maximum allowed length(30) 
    "SYSTEM.CERTIFIER_SYSTEM.CERTIFIER_ID" NUMBER NOT NULL
);

CREATE TABLE system.discipline (
    id_discipline          NUMBER(10) NOT NULL,
    discipline_name        VARCHAR2(45 CHAR) NOT NULL,
    discipline_description VARCHAR2(45 CHAR) NOT NULL
);

ALTER TABLE system.discipline ADD CONSTRAINT discipline_pk PRIMARY KEY ( id_discipline );

CREATE TABLE system.material (
    id_material        NUMBER(10) NOT NULL,
    file_name          VARCHAR2(45 CHAR) NOT NULL,
    content            VARCHAR2(45 CHAR) NOT NULL,
    upload_date        DATE NOT NULL,
    teacher_id_teacher NUMBER(10) NOT NULL
);

ALTER TABLE system.material ADD CONSTRAINT material_pk PRIMARY KEY ( id_material );

CREATE TABLE system.material_has_student (
    material_id_material        NUMBER(10) NOT NULL,
    "SYSTEM.STUDENT_ID_STUDENT" NUMBER(10) NOT NULL
);

CREATE TABLE system.question (
    id_question              NUMBER(10) NOT NULL,
    update_date              DATE,
    answer                   VARCHAR2(45 CHAR) NOT NULL,
    difficulty               NUMBER(10) NOT NULL,
    certified                NUMBER(10) NOT NULL,
    amount_access            NUMBER(10) NOT NULL,
    discipline_id_discipline NUMBER(10) NOT NULL,
    subject_id_subject       NUMBER(10) NOT NULL
);

ALTER TABLE system.question ADD CONSTRAINT question_pk PRIMARY KEY ( id_question );

CREATE TABLE system.student (
    id_student    NUMBER(10) NOT NULL,
    student_cpf   VARCHAR2(11),
    student_name  VARCHAR2(45),
    student_email VARCHAR2(45)
);

ALTER TABLE system.student ADD CONSTRAINT "SYSTEM.STUDENT_PK" PRIMARY KEY ( id_student );

CREATE TABLE system.student_has_test (
    result                      NUMBER,
    "SYSTEM.STUDENT_ID_STUDENT" NUMBER(10) NOT NULL,
    test_id_test                NUMBER(10) NOT NULL
);

CREATE TABLE system.subject (
    id_subject               NUMBER(10) NOT NULL,
    subject_description      VARCHAR2(45 CHAR) NOT NULL,
    amount_access            NUMBER(10) NOT NULL,
    discipline_id_discipline NUMBER(10) NOT NULL
);

ALTER TABLE system.subject ADD CONSTRAINT subject_pk PRIMARY KEY ( id_subject );

CREATE TABLE system.teacher (
    id_teacher               NUMBER(10) NOT NULL,
    teacher_cpf              VARCHAR2(11 CHAR) NOT NULL,
    teacher_name             VARCHAR2(45 CHAR) NOT NULL,
    teacher_email            VARCHAR2(45 CHAR) NOT NULL,
    discipline_id_discipline NUMBER(10) NOT NULL
);

ALTER TABLE system.teacher ADD CONSTRAINT teacher_pk PRIMARY KEY ( id_teacher );

CREATE TABLE system.teacher_has_question (
    teacher_id_teacher   NUMBER(10) NOT NULL,
    question_id_question NUMBER(10) NOT NULL
);

CREATE TABLE system.test (
    id_test   NUMBER(10) NOT NULL,
    test_name VARCHAR2(45 CHAR) NOT NULL,
    test_date DATE NOT NULL,
    answers   VARCHAR2(45 CHAR)
);

ALTER TABLE system.test ADD CONSTRAINT test_pk PRIMARY KEY ( id_test );

CREATE TABLE system.test_has_question (
    test_id_test         NUMBER(10) NOT NULL,
    question_id_question NUMBER(10) NOT NULL
);

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE system.certifier_has_subject
    ADD CONSTRAINT certifier_has_subject_certifier_fk FOREIGN KEY ( "SYSTEM.CERTIFIER_SYSTEM.CERTIFIER_ID" )
        REFERENCES system.certifier ( certifier_id );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE system.certifier_has_subject
    ADD CONSTRAINT certifier_has_subject_subject_fk FOREIGN KEY ( subject_id_subject )
        REFERENCES system.subject ( id_subject );

ALTER TABLE system.certifier
    ADD CONSTRAINT certifier_teacher_fk FOREIGN KEY ( id_teacher )
        REFERENCES system.teacher ( id_teacher );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE system.material_has_student
    ADD CONSTRAINT material_has_student_material_fkv1 FOREIGN KEY ( material_id_material )
        REFERENCES system.material ( id_material );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE system.material_has_student
    ADD CONSTRAINT material_has_student_student_fk FOREIGN KEY ( "SYSTEM.STUDENT_ID_STUDENT" )
        REFERENCES system.student ( id_student );

ALTER TABLE system.material
    ADD CONSTRAINT material_teacher_fk FOREIGN KEY ( teacher_id_teacher )
        REFERENCES system.teacher ( id_teacher );

ALTER TABLE system.question
    ADD CONSTRAINT question_discipline_fk FOREIGN KEY ( discipline_id_discipline )
        REFERENCES system.discipline ( id_discipline );

ALTER TABLE system.question
    ADD CONSTRAINT question_subject_fk FOREIGN KEY ( subject_id_subject )
        REFERENCES system.subject ( id_subject );

ALTER TABLE system.student_has_test
    ADD CONSTRAINT student_has_test_student_fk FOREIGN KEY ( "SYSTEM.STUDENT_ID_STUDENT" )
        REFERENCES system.student ( id_student );

ALTER TABLE system.student_has_test
    ADD CONSTRAINT student_has_test_test_fk FOREIGN KEY ( test_id_test )
        REFERENCES system.test ( id_test );

ALTER TABLE system.subject
    ADD CONSTRAINT subject_discipline_fk FOREIGN KEY ( discipline_id_discipline )
        REFERENCES system.discipline ( id_discipline );

ALTER TABLE system.teacher
    ADD CONSTRAINT teacher_discipline_fk FOREIGN KEY ( discipline_id_discipline )
        REFERENCES system.discipline ( id_discipline );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE system.teacher_has_question
    ADD CONSTRAINT teacher_has_question_question_fk FOREIGN KEY ( question_id_question )
        REFERENCES system.question ( id_question );

--  ERROR: FK name length exceeds maximum allowed length(30) 
ALTER TABLE system.teacher_has_question
    ADD CONSTRAINT teacher_has_question_teacher_fk FOREIGN KEY ( teacher_id_teacher )
        REFERENCES system.teacher ( id_teacher );

ALTER TABLE system.test_has_question
    ADD CONSTRAINT test_has_question_question_fk FOREIGN KEY ( question_id_question )
        REFERENCES system.question ( id_question );

ALTER TABLE system.test_has_question
    ADD CONSTRAINT test_has_question_test_fk FOREIGN KEY ( test_id_test )
        REFERENCES system.test ( id_test );

CREATE SEQUENCE system.certifier_certifier_id_seq START WITH 1 NOCACHE ORDER;

CREATE OR REPLACE TRIGGER system.certifier_certifier_id_trg BEFORE
    INSERT ON system.certifier
    FOR EACH ROW
    WHEN ( new.certifier_id IS NULL )
BEGIN
    :new.certifier_id := system.certifier_certifier_id_seq.nextval;
END;
/



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                            13
-- CREATE INDEX                             1
-- ALTER TABLE                             24
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           1
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          1
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   7
-- WARNINGS                                 0
