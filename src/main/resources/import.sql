INSERT INTO STUDENT_MODEL(CPF, EMAIL, NAME) VALUES ('07983136927', '123@GMAIL.COM', 'GIOVANNI');
INSERT INTO STUDENT_MODEL(CPF, EMAIL, NAME) VALUES ('07981111127', '456@GMAIL.COM', 'NATHALY');

INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_TEACHER) VALUES ('CONTEUDO', 'ARQUIVO.PDF', '50509');
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_TEACHER) VALUES ('CONTEUDO1', '23.PDF', '50509');
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_TEACHER) VALUES ('CONTEUDO2', 'APOSTILA.PDF', '50519');

INSERT INTO TEACHER_MODEL(DTYPE, CPF, EMAIL, ID_DISCIPLINE, NOME, AMOUNT_CERTIFIED) VALUES ('COISA', '079.831.369-27', 'EMAIL@GMAIL.COM', 509071355, 'não sei', 5050);
INSERT INTO TEACHER_MODEL(DTYPE, CPF, EMAIL, ID_DISCIPLINE, NOME, AMOUNT_CERTIFIED) VALUES ('COISA', '079.831.369-27', 'EMAIL1@GMAIL.COM', 509071352, 'não sei', 5052);
INSERT INTO TEACHER_MODEL(DTYPE, CPF, EMAIL, ID_DISCIPLINE, NOME, AMOUNT_CERTIFIED) VALUES ('COISA', '079.831.88822', 'EMAIL123@GMAIL.COM', 509071351, 'não sei', 5051);

INSERT INTO SUBJECT_MODEL(AMOUNT_ACCESS, DESCPTION, ID_DSCIPLINE) VALUES (105030, 'vamos estudar cambada', 1234567);

INSERT INTO DISCIPLINE_MODEL (DESCRPTION_DISCIPLINE, NAME_DISCIPLINE) VALUES ('oi', 'Prog tbm');
INSERT INTO DISCIPLINE_MODEL (DESCRPTION_DISCIPLINE, NAME_DISCIPLINE) VALUES ('oi2', 'Prog tbm2');
INSERT INTO DISCIPLINE_MODEL (DESCRPTION_DISCIPLINE, NAME_DISCIPLINE) VALUES ('oi2', 'Prog tbm3');

/* Os Insert's até aqui foram testados e validos no banco de dados
Funcionaram também com o POSTMAN para recuperar   */
