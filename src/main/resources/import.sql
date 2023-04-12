INSERT INTO PRODUTO(DESCRICAO, VALOR) values('ARROZ', 20.00), ('TOMATE', 4.0), ('LEITE', 5.0);

INSERT INTO pessoa (tipo, nome, cpf, email, telefone) VALUES('F','Rafaela Beatriz Vitória da Conceição', '701.989.618-98', 'rafaela_beatriz_daconceicao@uninorte.com.br', '(85) 98265-0989');
INSERT INTO pessoa (tipo, nome, cpf, email, telefone) VALUES('F','Pietro Iago Baptista', '446.697.200-15', 'pietro_baptista@marquesalcantra.comabdv.com.br', '(79) 98532-5962');
INSERT INTO pessoa (tipo, nome, cpf, email, telefone) VALUES('F','João Daniel Vinicius da Silva', '127.922.150-03', 'joao.daniel.dasilva@fibran.com.br', '(91) 98422-1409');
INSERT INTO pessoa (tipo, nome, cpf, email, telefone) VALUES('F','Eduardo Rodrigo Ian da Rocha', '779.069.684-09', 'eduardorodrigodarocha@netsite.com.br', '(94) 99511-2749');
INSERT INTO pessoa (tipo, nome, cpf, email, telefone) VALUES('F','Isis Isabel Nina Brito', '239.033.585-33', 'isis_brito@jcoronel.com.br', '(91) 99155-2895');

INSERT INTO pessoa (tipo, RAZAO_SOCIAL, cnpj, email, telefone) VALUES('J','Laura e Marcelo Mudanças ME', '12.914.052/0001-52', 'auditoria@lauraemarcelomudancasme.com.br', '(11) 99228-8145');
INSERT INTO pessoa (tipo, RAZAO_SOCIAL, cnpj, email, telefone) VALUES('J','Mariah e Sophia Buffet ME', '78.744.645/0001-26', 'seguranca@mariahesophiabuffetme.com.br', '(61) 99179-2154');
INSERT INTO pessoa (tipo, RAZAO_SOCIAL, cnpj, email, telefone) VALUES('J','Paulo e Cristiane Mudanças ME', '55.239.959/0001-76', 'orcamento@pauloecristianemudancasme.com.br', '(96) 98200-8019');
INSERT INTO pessoa (tipo, RAZAO_SOCIAL, cnpj, email, telefone) VALUES('J','Gabriela e Matheus Contábil Ltda', '44.341.832/0001-47', 'orcamento@gabrielaematheuscontabilltda.com.br', '(98) 98320-8532');
INSERT INTO pessoa (tipo, RAZAO_SOCIAL, cnpj, email, telefone) VALUES('J','Elisa e Danilo Esportes Ltda', '05.608.387/0001-87', 'marketing@elisaedaniloesportesltda.com.br', '(63) 99222-6465');

INSERT INTO VENDA(DATA, PESSOA_ID) values (CURRENT_TIMESTAMP, 1);
INSERT INTO VENDA(DATA, PESSOA_ID) values (CURRENT_TIMESTAMP, 2);
INSERT INTO VENDA(DATA, PESSOA_ID) values (CURRENT_TIMESTAMP, 1);

INSERT INTO ITEM_VENDA(QUANTIDADE, PRODUTO_ID, VENDA_ID) values (2.0, 2, 1);
INSERT INTO ITEM_VENDA(QUANTIDADE, PRODUTO_ID, VENDA_ID) values (4.0, 1, 2);
INSERT INTO ITEM_VENDA(QUANTIDADE, PRODUTO_ID, VENDA_ID) values (1.0, 3, 3);
INSERT INTO ITEM_VENDA(QUANTIDADE, PRODUTO_ID, VENDA_ID) values (1.0, 3, 1);

