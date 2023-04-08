INSERT INTO ROLE_MODEL(ROLE) VALUES ('ROLE_TEACHER');
INSERT INTO ROLE_MODEL(ROLE) VALUES ('ROLE_STUDENT');
INSERT INTO ROLE_MODEL(ROLE) VALUES ('ROLE_CERTIFIER');
INSERT INTO ROLE_MODEL(ROLE) VALUES ('ROLE_ADMIN');


INSERT INTO CLIENT_MODEL(NAME, LOGIN, PASSWORD) VALUES ('RenanE','renane','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
INSERT INTO STUDENT_MODEL(CPF, EMAIL, NAME, id_client) VALUES ('07983136927', '123@GMAIL.COM', 'Renan', 1);
INSERT INTO CLIENT_ROLE(id_client, ROLE_ID) VALUES (1, 2);

INSERT INTO CLIENT_MODEL(NAME, LOGIN, PASSWORD) VALUES ('Giovanie','giovanie','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
INSERT INTO STUDENT_MODEL(CPF, EMAIL, NAME, id_client) VALUES ('07983136928', '789@GMAIL.COM', 'GIOVANNI', 2);
INSERT INTO CLIENT_ROLE(id_client, ROLE_ID) VALUES (2, 2);

INSERT INTO CLIENT_MODEL(NAME, LOGIN, PASSWORD) VALUES ('Algueme','algueme','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
INSERT INTO STUDENT_MODEL(CPF, EMAIL, NAME, id_client) VALUES ('07983136929', '456@GMAIL.COM', 'Alguem', 3);
INSERT INTO CLIENT_ROLE(id_client, ROLE_ID) VALUES (3, 2);

INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_CLIENT, AMOUNT_ACCESS) VALUES ('CONTEUDO', 'ARQUIVO.PDF', '1',7);
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_CLIENT, AMOUNT_ACCESS) VALUES ('CONTEUDO1', '23.PDF', '2',5);
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_CLIENT, AMOUNT_ACCESS) VALUES ('CONTEUDO2', 'APOSTILA.PDF', '2',0);
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_CLIENT, AMOUNT_ACCESS) VALUES ('CONTEUDO3', 'ARQUIVO.PDF', '1',3);
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_CLIENT, AMOUNT_ACCESS) VALUES ('CONTEUDO4', '23.PDF', '3',4);
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_CLIENT, AMOUNT_ACCESS) VALUES ('CONTEUDO5', 'APOSTILA.PDF', '4',0);
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_CLIENT, AMOUNT_ACCESS) VALUES ('CONTEUDO6', 'ARQUIVO.PDF', '3',0);
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_CLIENT, AMOUNT_ACCESS) VALUES ('CONTEUDO7', '23.PDF', '2',10);
INSERT INTO MATERIAL_MODEL(CONTENT, FILE_NAME, ID_CLIENT, AMOUNT_ACCESS) VALUES ('CONTEUDO8', 'APOSTILA.PDF', '2',30);

INSERT INTO CLIENT_MODEL(NAME, LOGIN, PASSWORD) VALUES ('Renan','renan','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
INSERT INTO TEACHER_MODEL(DTYPE, CPF, EMAIL, ID_DISCIPLINE, NAME, CERTIFIER, ID_CLIENT) VALUES ('COISA', '079.831.369-27', 'EMAIL@GMAIL.COM', 509071355, 'Renan', 0, 4);
INSERT INTO CLIENT_ROLE(id_client, ROLE_ID) VALUES (4, 1);

INSERT INTO CLIENT_MODEL(NAME, LOGIN, PASSWORD) VALUES ('Giovani','giovani','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
INSERT INTO TEACHER_MODEL(DTYPE, CPF, EMAIL, ID_DISCIPLINE, NAME, CERTIFIER, ID_CLIENT) VALUES ('COISA', '079.831.369-27', 'EMAIL1@GMAIL.COM', 509071352, 'Pedro', 0, 5);
INSERT INTO CLIENT_ROLE(id_client, ROLE_ID) VALUES (5, 1);

INSERT INTO CLIENT_MODEL(NAME, LOGIN, PASSWORD) VALUES ('admin','admin','$2a$10$224Y56.QHRu.7XDU9CwlG.ZMfVWUWm0YBvslnF.hdmsKXTJlgb/YK');
INSERT INTO TEACHER_MODEL(DTYPE, CPF, EMAIL, ID_DISCIPLINE, NAME, CERTIFIER, ID_CLIENT) VALUES ('COISA', '079.831.88822', 'EMAIL123@GMAIL.COM', 509071351, 'Lara',0, 6);
INSERT INTO CLIENT_ROLE(id_client, ROLE_ID) VALUES (6, 4);

INSERT INTO DISCIPLINE_MODEL (DESCRPTION_DISCIPLINE, NAME_DISCIPLINE) VALUES ('Calculos', 'Matematica');
INSERT INTO DISCIPLINE_MODEL (DESCRPTION_DISCIPLINE, NAME_DISCIPLINE) VALUES ('Calculos', 'Fisica');
INSERT INTO DISCIPLINE_MODEL (DESCRPTION_DISCIPLINE, NAME_DISCIPLINE) VALUES ('Coisas da vida', 'Biologia');


INSERT INTO TEST_MODEL (NAME, DATE_TIME) VALUES ('Prova de sip', TO_DATE('2023-04-11', 'yyyy-mm-dd'));
INSERT INTO TEST_MODEL (NAME, DATE_TIME) VALUES ('Prova de The Winter',TO_DATE('2023-05-17', 'yyyy-mm-dd'));
INSERT INTO TEST_MODEL (NAME, DATE_TIME) VALUES ('Prova de Sum', TO_DATE('2023-06-15', 'yyyy-mm-dd'));

INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (1,'1', 'A');
INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (1,'2', 'B');
INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (1,'3', 'D');

INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (2,'1', 'A');
INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (2,'2', 'A');
INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (2,'3', 'C');
INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (2,'4', 'B');

INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (3,'1', 'B');
INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (3,'2', 'D');
INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (3,'3', 'C');
INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (3,'4', 'B');
INSERT INTO ANSWERS_HASH (TEST_ID, KEY, VALUE) VALUES (3,'5', 'D');


INSERT INTO QUESTION_MODEL (QUESTION, DIFFICULTY, CERTIFIED, ID_DISCIPLINE, ID_SUBJECT, AMOUNT_ACCESS, UPDATE_DATE) VALUES ('Porque o codigo funciona', 1, 1, 1, 1, 0, TO_DATE('2023-04-11', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (QUESTION, DIFFICULTY, CERTIFIED, ID_DISCIPLINE, ID_SUBJECT, AMOUNT_ACCESS, UPDATE_DATE) VALUES ('Porque o codigo nunca funciona', 2, 1, 3, 2,0,TO_DATE('2023-04-11', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (QUESTION, DIFFICULTY, CERTIFIED, ID_DISCIPLINE, ID_SUBJECT, AMOUNT_ACCESS, UPDATE_DATE) VALUES ('Porque eu Nao sei', 4, 0, 2, 3,10,TO_DATE('2023-04-11', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (QUESTION, DIFFICULTY, CERTIFIED, ID_DISCIPLINE, ID_SUBJECT, AMOUNT_ACCESS, UPDATE_DATE) VALUES ('Porque o codigo funciona', 1, 0, 1, 1, 0, TO_DATE('2023-04-11', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (QUESTION, DIFFICULTY, CERTIFIED, ID_DISCIPLINE, ID_SUBJECT, AMOUNT_ACCESS, UPDATE_DATE) VALUES ('Porque o codigo nunca funciona', 2, 0, 3, 2,0,TO_DATE('2023-04-11', 'yyyy-mm-dd'));
INSERT INTO QUESTION_MODEL (QUESTION, DIFFICULTY, CERTIFIED, ID_DISCIPLINE, ID_SUBJECT, AMOUNT_ACCESS, UPDATE_DATE) VALUES ('Porque eu Nao sei', 4, 1, 2, 3,10,TO_DATE('2023-04-11', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual a capital do Brasil?', 1, 1, 1, 1, 100, TO_DATE('2022-01-01', 'yyyy-mm-dd'))

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual a capital do Brasil?', 1, 1, 1, 1, 100, TO_DATE('2022-01-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem escreveu o livro "1984"?', 3, 1, 2, 3, 50, TO_DATE('2022-02-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual a formula quimica da agua?', 2, 0, 3, 2, 200, TO_DATE('2022-03-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem descobriu a teoria da relatividade?', 4, 1, 1, 4, 150, TO_DATE('2022-04-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual o autor de "Dom Casmurro"?', 2, 1, 3, 5, 75, TO_DATE('2022-05-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('O que significa CPU?', 2, 0, 2, 6, 300, TO_DATE('2022-06-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem foi o primeiro presidente do Brasil?', 3, 0, 1, 7, 120, TO_DATE('2022-07-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh o maior planeta do Sistema Solar?', 2, 1, 3, 8, 90, TO_DATE('2022-08-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quantos estados tem o Brasil?', 1, 0, 2, 9, 250, TO_DATE('2022-09-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual a capital do Brasil?', 1, 1, 1, 100, TO_DATE('2022-01-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem escreveu o livro "1984"?', 3, 2, 3, 50, TO_DATE('2022-02-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual a formula quimica da agua?', 2, 0, 3, 2, 200, TO_DATE('2022-03-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem descobriu a teoria da relatividade?', 4, 1, 1, 4, 150, TO_DATE('2022-04-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual o autor de "Dom Casmurro"?', 2, 1, 3, 5, 75, TO_DATE('2022-05-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('O que significa CPU?', 2, 0, 2, 6, 300, TO_DATE('2022-06-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem foi o primeiro presidente do Brasil?', 3, 0, 1, 7, 120, TO_DATE('2022-07-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh o maior planeta do Sistema Solar?', 2, 1, 3, 8, 90, TO_DATE('2022-08-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quantos estados tem o Brasil?', 1, 1, 2, 9, 250, TO_DATE('2022-09-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem pintou a "Mona Lisa"?', 3, 1, 1, 1, 175, TO_DATE('2022-10-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh o significado da palavra "resiliencia"?', 2, 1, 2, 2, 95, TO_DATE('2022-11-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty,certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a velocidade da luz?', 4, 1, 1, 3, 80, TO_DATE('2022-12-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, id_discipline, id_subject, amount_access, update_date) VALUES ('O que eh um proton?', 3, 3, 4, 300, TO_DATE('2023-01-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a capital da Argentina?', 2, 2, 5, 120, TO_DATE('2023-02-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem foi o autor de "Hamlet"?', 3, 1, 1, 6, 150, TO_DATE('2023-03-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh o rio mais extenso do mundo?', 2, 1, 3, 7, 200, TO_DATE('2023-04-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a sigla para a Organizacao das Nacoes Unidas?', 1, 1, 2, 8, 80, TO_DATE('2023-05-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem foi o primeiro homem a pisar na Lua?', 4, 1, 1, 9, 50, TO_DATE('2023-06-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('O que eh uma molehcula?', 2, 0, 3, 1, 175, TO_DATE('2023-07-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a capital da Italia?', 2, 1, 2, 2, 90, TO_DATE('2023-08-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem foi o criador do Facebook?', 3, 1, 1, 3, 75, TO_DATE('2023-09-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a formula quimica do oxigenio?', 1, 1, 3, 4, 250, TO_DATE('2023-10-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a capital da Alemanha?', 2, 1, 2, 5 , 110, TO_DATE('2023-11-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem foi o primeiro presidente do Brasil?', 3, 1, 6, 65, TO_DATE('2023-12-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a unidade de medida de forca no sistema internacional?', 1, 3, 7, 300, TO_DATE('2024-01-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem escreveu "A Divina Comehdia"?', 4, 1, 1, 8, 100, TO_DATE('2024-02-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a capital da Australia?', 2, 1, 2, 9, 45, TO_DATE('2024-03-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('O que eh a teoria da relatividade?', 4, 1, 3, 1, 150, TO_DATE('2024-04-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem pintou a Mona Lisa?', 3, 1, 1, 2, 80, TO_DATE('2024-05-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a capital do Canada?', 2, 1, 2, 3, 110, TO_DATE('2024-06-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh o nome do maior deserto do mundo?', 2, 1, 3, 4, 130, TO_DATE('2024-07-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem escreveu "A Odissehia"?', 4, 1, 1, 5, 90, TO_DATE('2024-08-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('O que eh uma cehlula?', 2, 0, 3, 6, 250, TO_DATE('2024-09-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem foi o criador da Microsoft?', 3, 1, 1, 7, 70, TO_DATE('2024-10-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject,amount_access, update_date) VALUES ('Qual eh o maior planeta do sistema solar?', 2, 1, 3, 8, 120, TO_DATE('2024-11-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem foi o primeiro homem a pisar na Lua?', 3, 1, 2, 9, 60, TO_DATE('2024-12-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh o nome do maior oceano do mundo?', 2, 1, 3, 1, 90, TO_DATE('2025-01-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a capital do Chile?', 2, 1, 1, 2, 110, TO_DATE('2025-02-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem escreveu "O Pequeno Principe"?', 3, 1, 3, 80, TO_DATE('2025-03-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a capital do Mehxico?', 2, 1, 2, 4, 70, TO_DATE('2025-04-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('Quem foi o criador da Apple?', 3, 1, 1, 5, 75, TO_DATE('2025-05-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a capital da Nigehria?', 2, 2, 6, 50, TO_DATE('2025-06-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, id_discipline, id_subject, amount_access, update_date) VALUES ('Qual eh a capital da Suehcia?', 2, 1, 7, 100, TO_DATE('2025-07-01', 'yyyy-mm-dd'));

INSERT INTO QUESTION_MODEL (question, difficulty, certified, id_discipline, id_subject, amount_access, update_date) VALUES ('O que eh um atomo?', 2, 0, 3, 8, 300, TO_DATE('2025-08-01', 'yyyy-mm-dd'));





INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (1, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (1, 'Amora Nao eh doce');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (1, 'Abacaxi tem uma coroa mas Nao eh rei');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (2, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (2, 'CSASS eh uma coisa');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (3, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (4, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (5, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (6, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (6, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (6, 'Essa eh uma pergunta dificil de responder');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (3, 'Python eh uma linguagem de programacao muito popular');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (3, 'Eu gosto de usar o Visual Studio Code');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (2, 'O que eh um banco de dados relacional?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (4, 'Qual a diferenca entre uma chave primaria e uma chave estrangeira?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (4, 'Uma chave primaria eh uma coluna que identifica unicamente cada linha em uma tabela');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (5, 'O que eh uma consulta SQL?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (5, 'Qual a diferenca entre uma funcao e uma stored procedure?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (5, 'Uma stored procedure eh um programa armazenado no banco de dados que pode ser executado por um usuario');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (7, 'Uma funcao retorna um valor, enquanto uma stored procedure nao necessariamente retorna nada');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (7, 'O que eh uma chave composta?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (7, 'Uma chave composta eh uma chave primaria que consiste em mais de uma coluna');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (8, 'Qual a diferenca entre um indice clusterizado e um indice nao clusterizado?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (8, 'Um indice clusterizado reorganiza fisicamente os dados da tabela com base nas colunas do indice');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (9, 'O que eh uma subconsulta?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (9, 'Uma subconsulta eh uma consulta aninhada dentro de outra consulta');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (10, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (10, 'O erro pode estar relacionado a problemas de compatibilidade com as dependencias do projeto.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (10, 'Isso pode ocorrer devido a uma falha de conexao com o banco de dados.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (11, 'O design pattern mais adequado para esse caso eh o Singleton.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (11, 'Recomendo utilizar o Factory Method para a criacao de objetos.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (11, 'O uso do padrao Observer eh uma boa opcao nesse caso.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (11, 'O padrao Strategy pode ser uma boa alternativa para solucionar esse problema.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (12, 'Para resolver esse problema, eh necessario adicionar uma validacao antes de realizar a acao.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (13, 'Verifique se a variavel que armazena o valor esta sendo inicializada corretamente.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (14, 'Recomendo utilizar uma biblioteca externa para tratar essas excecoes.');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (15, 'Existem diferentes tipos de banco de dados, como relacionais, documentais e em grafo');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (15, 'Bancos de dados relacionais sao baseados em tabelas e utilizam SQL para consultas');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (15, 'Bancos de dados documentais sao baseados em documentos e utilizam linguagens como MongoDB Query Language para consultas');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (15, 'Bancos de dados em grafo sao baseados em grafos e utilizam linguagens como Cypher para consultas');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (27, 'As principais estruturas de dados em programacao sao arrays, listas, pilhas, filas e arvores');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (26, 'Arrays sao estruturas estaticas que armazenam elementos do mesmo tipo');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (16, 'Listas sao estruturas dinamicas que permitem a insercao e remocao de elementos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (16, 'Pilhas sao estruturas LIFO (Last In, First Out)');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (16, 'Filas sao estruturas FIFO (First In, First Out)');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (16, 'arvores sao estruturas hierarquicas que podem ser binarias ou nao');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (17, 'Um algoritmo eh um conjunto de instrucoes que resolve um problema especifico');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (17, 'Os algoritmos podem ser representados atravehs de fluxogramas, pseudocodigos ou linguagens de programacao');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (17, 'A eficiencia de um algoritmo pode ser medida pela sua complexidade temporal e espacial');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (17, 'Algoritmos de ordenacao sao utilizados para ordenar elementos em uma estrutura de dados');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (18, 'A programacao orientada a objetos eh um paradigma de programacao que utiliza classes e objetos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (18, 'Classes sao estruturas que encapsulam atributos e mehtodos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (18, 'Objetos sao instancias de uma classe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (18, 'Os quatro pilares da programacao orientada a objetos sao encapsulamento, heranca, polimorfismo e abstracao');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (19, 'Python eh uma linguagem de programacao de alto nivel, interpretada e orientada a objetos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (19, 'Python possui uma sintaxe simples e clara');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (19, 'Python eh utilizada em diversas areas, como analise de dados, inteligencia artificial e desenvolvimento web');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (19, 'O interpretador Python esta disponivel para varias plataformas, incluindo Windows, Linux e MacOS');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (20, 'A linguagem SQL eh utilizada para gerenciamento de bancos de dados relacionais');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (20, 'SQL eh uma linguagem declarativa, ou seja, o programador descreve o que deve ser feito e nao como fazer');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (14, 'As principais operacoes em SQL sao SELECT, INSERT, UPDATE e DELETE');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (20, 'SQL eh uma linguagem padronizada, com implementacoes em diversos sistemas de gerenciamento de bancos de dados');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (21, 'JavaScript eh uma linguagem de programacao de alto nivel, interpretada e orientada a objetos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (22, 'JavaScript eh utilizada principalmente em desenvolvimento web, para criar interatividade e dinamismo nas paginas');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (23, 'JavaScript possui uma sintaxe simples e clara');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (20, 'A resposta para essa pergunta eh 42.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (20, 'A resposta para essa pergunta pode ser encontrada na documentacao.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (21, 'Nao ha uma resposta simples para essa pergunta, depende do contexto.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (21, 'Existem varias abordagens possiveis para resolver esse problema.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (21, 'Para responder essa pergunta, eh necessario primeiro entender os requisitos do sistema.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (29, 'A melhor maneira de fazer isso eh utilizando a biblioteca X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (22, 'eh possivel resolver esse problema utilizando a tehcnica Y.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (22, 'Uma solucao possivel seria utilizar o algoritmo Z.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (22, 'Para resolver esse problema, eh necessario primeiro realizar uma analise mais detalhada dos dados.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (44, 'eh importante considerar as restricoes de desempenho ao escolher uma solucao para esse problema.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (23, 'Uma maneira simples de fazer isso eh utilizando o mehtodo X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (23, 'Para calcular isso, eh necessario considerar os fatores A, B e C.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (23, 'Para obter um resultado mais preciso, eh necessario utilizar uma tehcnica mais avancada, como o mehtodo Y.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (24, 'Uma possivel explicacao para isso eh que o algoritmo utilizado nao eh eficiente o suficiente.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (24, 'Esse comportamento pode ser causado por um erro na implementacao do algoritmo.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (25, 'Para evitar esse problema, eh recomendado utilizar a tehcnica X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (25, 'Uma forma de reduzir o impacto desse problema eh utilizando a abordagem Y.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (26, 'Nao eh possivel responder a essa pergunta sem mais informacoes sobre o contexto.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (27, 'Para encontrar a resposta para essa pergunta, eh necessario realizar uma pesquisa mais aprofundada.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (28, 'Esse problema pode ser resolvido utilizando a tehcnica X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (28, 'Para resolver esse problema, eh necessario primeiro identificar as causas raizes.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (29, 'A melhor maneira de abordar esse problema eh utilizando a abordagem X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (30, 'Para obter um vetor de forma desalinhada');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (30, 'Para obter um vetor de forma alinha');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (31, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (31, 'Amora Nao eh doce');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (31, 'Abacaxi tem uma coroa mas Nao eh rei');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (32, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (32, 'CSASS eh uma coisa');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (33, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (34, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (35, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (36, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (36, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (36, 'Essa eh uma pergunta dificil de responder');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (33, 'Python eh uma linguagem de programacao muito popular');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (33, 'Eu gosto de usar o Visual Studio Code');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (32, 'O que eh um banco de dados relacional?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (34, 'Qual a diferenca entre uma chave primaria e uma chave estrangeira?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (34, 'Uma chave primaria eh uma coluna que identifica unicamente cada linha em uma tabela');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (35, 'O que eh uma consulta SQL?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (35, 'Qual a diferenca entre uma funcao e uma stored procedure?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (35, 'Uma stored procedure eh um programa armazenado no banco de dados que pode ser executado por um usuario');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (37, 'Uma funcao retorna um valor, enquanto uma stored procedure nao necessariamente retorna nada');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (37, 'O que eh uma chave composta?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (37, 'Uma chave composta eh uma chave primaria que consiste em mais de uma coluna');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (38, 'Qual a diferenca entre um indice clusterizado e um indice nao clusterizado?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (38, 'Um indice clusterizado reorganiza fisicamente os dados da tabela com base nas colunas do indice');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (39, 'O que eh uma subconsulta?');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (39, 'Uma subconsulta eh uma consulta aninhada dentro de outra consulta');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (40, 'Nao sei o motivo exato, mas sei que o stackoverflow sabe.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (40, 'O erro pode estar relacionado a problemas de compatibilidade com as dependencias do projeto.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (40, 'Isso pode ocorrer devido a uma falha de conexao com o banco de dados.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (41, 'O design pattern mais adequado para esse caso eh o Singleton.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (41, 'Recomendo utilizar o Factory Method para a criacao de objetos.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (41, 'O uso do padrao Observer eh uma boa opcao nesse caso.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (41, 'O padrao Strategy pode ser uma boa alternativa para solucionar esse problema.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (42, 'Para resolver esse problema, eh necessario adicionar uma validacao antes de realizar a acao.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (43, 'Verifique se a variavel que armazena o valor esta sendo inicializada corretamente.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (44, 'Recomendo utilizar uma biblioteca externa para tratar essas excecoes.');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (45, 'Existem diferentes tipos de banco de dados, como relacionais, documentais e em grafo');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (45, 'Bancos de dados relacionais sao baseados em tabelas e utilizam SQL para consultas');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (45, 'Bancos de dados documentais sao baseados em documentos e utilizam linguagens como MongoDB Query Language para consultas');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (45, 'Bancos de dados em grafo sao baseados em grafos e utilizam linguagens como Cypher para consultas');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (46, 'As principais estruturas de dados em programacao sao arrays, listas, pilhas, filas e arvores');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (46, 'Arrays sao estruturas estaticas que armazenam elementos do mesmo tipo');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (56, 'Listas sao estruturas dinamicas que permitem a insercao e remocao de elementos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (42, 'Pilhas sao estruturas LIFO (Last In, First Out)');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (43, 'Filas sao estruturas FIFO (First In, First Out)');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (46, 'arvores sao estruturas hierarquicas que podem ser binarias ou nao');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (47, 'Um algoritmo eh um conjunto de instrucoes que resolve um problema especifico');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (47, 'Os algoritmos podem ser representados atravehs de fluxogramas, pseudocodigos ou linguagens de programacao');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (47, 'A eficiencia de um algoritmo pode ser medida pela sua complexidade temporal e espacial');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (47, 'Algoritmos de ordenacao sao utilizados para ordenar elementos em uma estrutura de dados');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (48, 'A programacao orientada a objetos eh um paradigma de programacao que utiliza classes e objetos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (48, 'Classes sao estruturas que encapsulam atributos e mehtodos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (48, 'Objetos sao instancias de uma classe');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (48, 'Os quatro pilares da programacao orientada a objetos sao encapsulamento, heranca, polimorfismo e abstracao');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (49, 'Python eh uma linguagem de programacao de alto nivel, interpretada e orientada a objetos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (49, 'Python possui uma sintaxe simples e clara');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (49, 'Python eh utilizada em diversas areas, como analise de dados, inteligencia artificial e desenvolvimento web');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (49, 'O interpretador Python esta disponivel para varias plataformas, incluindo Windows, Linux e MacOS');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (50, 'A linguagem SQL eh utilizada para gerenciamento de bancos de dados relacionais');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (50, 'SQL eh uma linguagem declarativa, ou seja, o programador descreve o que deve ser feito e nao como fazer');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (12, 'As principais operacoes em SQL sao SELECT, INSERT, UPDATE e DELETE');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (13, 'SQL eh uma linguagem padronizada, com implementacoes em diversos sistemas de gerenciamento de bancos de dados');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (51, 'JavaScript eh uma linguagem de programacao de alto nivel, interpretada e orientada a objetos');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (52, 'JavaScript eh utilizada principalmente em desenvolvimento web, para criar interatividade e dinamismo nas paginas');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (53, 'JavaScript possui uma sintaxe simples e clara');

INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (50, 'A resposta para essa pergunta eh 42.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (50, 'A resposta para essa pergunta pode ser encontrada na documentacao.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (51, 'Nao ha uma resposta simples para essa pergunta, depende do contexto.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (51, 'Existem varias abordagens possiveis para resolver esse problema.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (51, 'Para responder essa pergunta, eh necessario primeiro entender os requisitos do sistema.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (52, 'A melhor maneira de fazer isso eh utilizando a biblioteca X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (52, 'eh possivel resolver esse problema utilizando a tehcnica Y.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (52, 'Uma solucao possivel seria utilizar o algoritmo Z.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (52, 'Para resolver esse problema, eh necessario primeiro realizar uma analise mais detalhada dos dados.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (52, 'eh importante considerar as restricoes de desempenho ao escolher uma solucao para esse problema.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (53, 'Uma maneira simples de fazer isso eh utilizando o mehtodo X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (53, 'Para calcular isso, eh necessario considerar os fatores A, B e C.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (53, 'Para obter um resultado mais preciso, eh necessario utilizar uma tehcnica mais avancada, como o mehtodo Y.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (54, 'Uma possivel explicacao para isso eh que o algoritmo utilizado nao eh eficiente o suficiente.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (54, 'Esse comportamento pode ser causado por um erro na implementacao do algoritmo.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (55, 'Para evitar esse problema, eh recomendado utilizar a tehcnica X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (55, 'Uma forma de reduzir o impacto desse problema eh utilizando a abordagem Y.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (56, 'Nao eh possivel responder a essa pergunta sem mais informacoes sobre o contexto.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (57, 'Para obter um vetor de forma alinha');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (57, 'Para encontrar a resposta para essa pergunta, eh necessario realizar uma pesquisa mais aprofundada.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (58, 'Esse problema pode ser resolvido utilizando a tehcnica X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (58, 'Para resolver esse problema, eh necessario primeiro identificar as causas raizes.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (59, 'A melhor maneira de abordar esse problema eh utilizando a abordagem X.');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (59, 'Para obter um vetor de forma alinha');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (60, 'Para obter um vetor de forma desalinhada');
INSERT INTO ANSWERS_LIST (QUESTION_ID, VALUE) VALUES (60, 'Para obter um vetor de forma alinha');



INSERT INTO SUBJECT_MODEL (DESCRIPTION, AMOUNT_ACCESS, ID_DISCIPLINE) VALUES ('Algebra', 0, 2);
INSERT INTO SUBJECT_MODEL (DESCRIPTION, AMOUNT_ACCESS, ID_DISCIPLINE) VALUES ('Trigonometria',10, 1);
INSERT INTO SUBJECT_MODEL (DESCRIPTION, AMOUNT_ACCESS, ID_DISCIPLINE) VALUES ('Geometria', 5, 3);
INSERT INTO SUBJECT_MODEL (DESCRIPTION, AMOUNT_ACCESS, ID_DISCIPLINE) VALUES ('Cinematica', 15, 2);
INSERT INTO SUBJECT_MODEL (DESCRIPTION, AMOUNT_ACCESS, ID_DISCIPLINE) VALUES ('Dinamica', 30, 1);
INSERT INTO SUBJECT_MODEL (DESCRIPTION, AMOUNT_ACCESS, ID_DISCIPLINE) VALUES ('Termodinamica', 5, 3);
INSERT INTO SUBJECT_MODEL (DESCRIPTION, AMOUNT_ACCESS, ID_DISCIPLINE) VALUES ('Genetica', 40, 2);
INSERT INTO SUBJECT_MODEL (DESCRIPTION, AMOUNT_ACCESS, ID_DISCIPLINE) VALUES ('Ecologia', 47, 1);
INSERT INTO SUBJECT_MODEL (DESCRIPTION, AMOUNT_ACCESS, ID_DISCIPLINE) VALUES ('Fisiologia', 5, 3);

INSERT INTO ANSWERS_SHEET_LIST (QUESTION_ID, VALUE) VALUES (6, '1');
INSERT INTO ANSWERS_SHEET_LIST (QUESTION_ID, VALUE) VALUES (6, '2');
INSERT INTO ANSWERS_SHEET_LIST (QUESTION_ID, VALUE) VALUES (1, '1');
INSERT INTO ANSWERS_SHEET_LIST (QUESTION_ID, VALUE) VALUES (2, '5');
INSERT INTO ANSWERS_SHEET_LIST (QUESTION_ID, VALUE) VALUES (2, '3');
INSERT INTO ANSWERS_SHEET_LIST (QUESTION_ID, VALUE) VALUES (2, '2');
INSERT INTO ANSWERS_SHEET_LIST (QUESTION_ID, VALUE) VALUES (4, '3');


insert into test_has_question values (1,1);
insert into test_has_question values (1,2);
insert into test_has_question values (1,3);

insert into student_has_test values (1,1,8.5);
insert into student_has_test values (1,2,8.0);
insert into student_has_test values (2,2,5.0);
insert into student_has_test values (3,1,4.5);
insert into student_has_test values (1,3,4);

insert into material_has_student values (1,1);
insert into material_has_student values (1,2);
insert into material_has_student values (2,3);
insert into material_has_student values (3,1);

insert into teacher_has_question values (1,1);
insert into teacher_has_question values (1,2);
insert into teacher_has_question values (2,3);
insert into teacher_has_question values (3,1);