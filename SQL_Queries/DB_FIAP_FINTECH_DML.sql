-- POPULAR A TABELA DEPTO COM 5 DEPARTAMENTOS
INSERT INTO t_fin_autentificacao (  fk_usuario, email,senha, st_autenticacao, dt_cadastro )
     VALUES ( 1, 'guilherme@gbbdesign.com.br', '12345678', 'y', TO_DATE('15/09/2012','DD/MM/YYYY'));

INSERT INTO t_fin_despesa ( fk_usuario, fk_inst_financeira, vl_despesa, nr_parcela, dt_despesas,  tipo_despesa, ds_despesa )
     VALUES ( 1, 1 , 120.99,1, TO_DATE('29/10/2024','DD/MM/YYYY'), '1',  'Café da manha' );
     
INSERT INTO t_fin_endereco (  fk_usuario ,nm_lougradouro, nm_rua, nm_bairro, nm_uf, nr_lougradouro, ds_complemento )
    VALUES (1,'Escritorio','Rua Odilon Martins de Andrades','Recreio dos Bandeirantes','RJ',270, 'A');

INSERT INTO t_fin_inst_financeira ( nr_inst, nr_ag, nr_cc )
     VALUES (270,0032,12345678);

INSERT INTO t_fin_investimento (  fk_usuario, fk_inst_financeira, vl_invest, tx_retabilidade_ano )
     VALUES ( 1, 1, 12000.99, 1.5);
     
INSERT INTO t_fin_notificacao (  fk_usuario, dt_notificacao, ds_mensagem, status )
     VALUES ( 1, TO_DATE('29/10/2024','DD/MM/YYYY'), 'Bem vindo ao sistema Fintech, esperamos ajudar na sua saude financeira', 'n');
     
INSERT INTO t_fin_recebimento (  fk_usuario, fk_inst_financeira, vl_receb, tipo_receb, dt_receb, ds_receb )
     VALUES ( 1, 1 , 120000.99, '1', TO_DATE('29/10/2024','DD/MM/YYYY'), 'Salario' );   
     
INSERT INTO t_fin_servicos (  fk_usuario, nm_servico, ds_servico, tx_servico  )
     VALUES (1, 'Boost de Gestao', 'Tenha mais acesso a dicas de investimento e uma IA personalizada', 10.99);
     
INSERT INTO t_fin_usuario ( nm_completo, nr_rg, nr_cpf, dt_nascimento, tp_sexo, tp_escolaridade, tp_estado_civil   )
     VALUES ( 'GUILHERME brenner BELLO', '2102232142', '13432154345', TO_DATE('16/04/1986','DD/MM/YYYY'), 'M', 'ensino medio', 'solteiro');

DELETE FROM t_fin_usuario WHERE id_usu = 1;  
-- ALTERAR TABELAS

UPDATE t_fin_autentificacao
SET
    email = 'guilherme@gmail.com',
    senha = '43143134'
WHERE
    id_aut = 1;
    

UPDATE t_fin_despesa
SET
    fk_inst_financeira = 1,
    vl_despesa = 90.20,
    nr_parcela = 2,
    dt_despesas = TO_DATE('18/05/1985', 'DD/MM/YYYY'),
    tipo_despesa = '2',
    ds_despesa = 'Almoco lanche'
WHERE
    id_despesa = 1;

UPDATE t_fin_endereco
SET
    nm_lougradouro = 'Casa',
    nm_rua = 'Odilon Martins de Andrades',
    nm_bairro = 'Recreio dos Bandeirantes',
    nm_uf = 'RJ',
    nr_lougradouro = 170,
    ds_complemento = '240'
WHERE
    id_end = 1;

UPDATE t_fin_inst_financeira
SET
    nr_inst = 0002,
    nr_ag = 0001,
    nr_cc = 11111111
WHERE
    id_ins = 1;

UPDATE t_fin_investimento
SET
    fk_inst_financeira = 1,
    vl_invest = 10000,
    tx_retabilidade_ano = 0.1
WHERE
    id_inv = 1;


UPDATE t_fin_notificacao
SET
    dt_notificacao = TO_DATE('23/10/2024','DD/MM/YYYY'),
    ds_mensagem = 'Sucesso você alterou os dados',
    status = 's'
WHERE
    id_not = 1;

UPDATE t_fin_recebimento
SET
    fk_inst_financeira = 1,
    vl_receb = 120000.00,
    tipo_receb = '1',
    dt_receb = TO_DATE('23/10/2024','DD/MM/YYYY'),
    ds_receb = 'Lucro'
WHERE
    id_rec = 1;

UPDATE t_fin_servicos
SET
    nm_servico = 'Gestao Premium',
    ds_servico = 'Tenha mais acesso a dicas de investimento e uma IA personalizada',
    tx_servico = 9.99
WHERE
    id_servicos = 1;


UPDATE t_fin_usuario
SET
    nm_completo = 'GUILHERME B. BELLO',
    nr_rg = 2102232142,
    nr_cpf = 13432154345,
    dt_nascimento = TO_DATE('16/04/1985','DD/MM/YYYY'),
    tp_sexo = 'F',
    tp_escolaridade = 'Superior cursando',
    tp_estado_civil = 'Uniao Sstável'
WHERE
    id_usu = 1;
    
    
--VALUES (1, 'GUILHERME brenner BELLO', '2102232142', '13432154345', TO_DATE('16/04/1986','DD/MM/YYYY'), 'M', 'ensino medio', 'solteiro');

--VALUES (1,1, 'Boost de Gestao', , );
     
-- CONSULTAR TABELAS
SELECT *
FROM
    t_fin_autentificacao
WHERE
    id_aut = 1;


SELECT *
FROM
    t_fin_despesa
WHERE
    id_despesa = 1;


SELECT *
FROM
    t_fin_endereco
WHERE
    id_end = 1;

SELECT *
FROM
    t_fin_investimento
WHERE
    id_inv = 1;


SELECT *
FROM
    t_fin_inst_financeira
WHERE
    id_ins = 1;
    
    
SELECT *
FROM
    t_fin_notificacao
WHERE
    id_not = 1;
    
SELECT *
FROM
    t_fin_recebimento
WHERE
    id_rec = 1;
    
    
SELECT *
FROM
    t_fin_servicos
WHERE
    id_servicos = 1;
    
    
SELECT *
FROM
    t_fin_usuario
WHERE
    id_usu = 1;
    
COMMIT