INSERT INTO PRODUTO(DESCRICAO, VALOR) values('ARROZ', 20.00), ('TOMATE', 4.0), ('LEITE', 5.0);

INSERT INTO pessoa (tipo, nome, cpf) VALUES('F','Stella Mariane Melissa Drumond', '039.106.515-77');
INSERT INTO pessoa (tipo, nome, cpf) VALUES('F','Tomás Oliver Noah Mendes', '367.676.412-94');
INSERT INTO pessoa (tipo, nome, cpf) VALUES('F','Vicente Thiago Carvalho', '785.061.220-58');
INSERT INTO pessoa (tipo, nome, cpf) VALUES('F','Fernanda Joana Melo', '779.069.684-09');
INSERT INTO pessoa (tipo, nome, cpf) VALUES('F','Manuel Vicente Jorge da Costa', '239.033.585-33');

INSERT INTO pessoa (tipo, nome, cnpj) VALUES('J','IFTO', '345');

INSERT INTO VENDA(DATA, PESSOA_ID) values (CURRENT_TIMESTAMP, 1);
INSERT INTO VENDA(DATA, PESSOA_ID) values (CURRENT_TIMESTAMP, 2);
INSERT INTO VENDA(DATA, PESSOA_ID) values (CURRENT_TIMESTAMP, 1);

INSERT INTO ITEM_VENDA(QUANTIDADE, PRODUTO_ID, VENDA_ID) values (2.0, 2, 1);
INSERT INTO ITEM_VENDA(QUANTIDADE, PRODUTO_ID, VENDA_ID) values (4.0, 1, 2);
INSERT INTO ITEM_VENDA(QUANTIDADE, PRODUTO_ID, VENDA_ID) values (1.0, 3, 3);

