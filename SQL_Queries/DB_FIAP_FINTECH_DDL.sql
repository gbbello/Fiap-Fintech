-- Generated by Oracle SQL Developer Data Modeler 23.1.0.087.0806
--   at:        2024-09-29 21:16:11 BRT
--   site:      Oracle Database 11g
--   type:      Oracle Database 11g

DROP TABLE t_fin_autentificacao CASCADE CONSTRAINTS;

DROP TABLE t_fin_despesa CASCADE CONSTRAINTS;

DROP TABLE t_fin_endereco CASCADE CONSTRAINTS;

DROP TABLE t_fin_inst_financeira CASCADE CONSTRAINTS;

DROP TABLE t_fin_investimento CASCADE CONSTRAINTS;

DROP TABLE t_fin_notificacao CASCADE CONSTRAINTS;

DROP TABLE t_fin_recebimento CASCADE CONSTRAINTS;

DROP TABLE t_fin_servicos CASCADE CONSTRAINTS;

DROP TABLE t_fin_usuario CASCADE CONSTRAINTS;

-- DROP SEQUENCES
DROP SEQUENCE sq_t_fin_autentificacao;
DROP SEQUENCE sq_t_fin_despesa;
DROP SEQUENCE sq_t_fin_endereco;
DROP SEQUENCE sq_t_fin_inst_financeira;
DROP SEQUENCE sq_t_fin_investimento;
DROP SEQUENCE sq_t_fin_notificacao;
DROP SEQUENCE sq_t_fin_recebimento;
DROP SEQUENCE sq_t_fin_servico;
DROP SEQUENCE sq_t_fin_usuario;

-- CREATE SEQUENCES
CREATE SEQUENCE sq_t_fin_autentificacao
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
CREATE SEQUENCE sq_t_fin_despesa
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;

CREATE SEQUENCE sq_t_fin_endereco
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE sq_t_fin_inst_financeira
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE sq_t_fin_investimento
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE sq_t_fin_notificacao
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE sq_t_fin_recebimento
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE sq_t_fin_servico
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
    
CREATE SEQUENCE sq_t_fin_usuario
    START WITH 1
    INCREMENT BY 1 
    MAXVALUE 99999
    NOCACHE
    NOCYCLE;
-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_fin_autentificacao (
    id_aut          NUMBER(5) DEFAULT sq_t_fin_autentificacao.NEXTVAL NOT NULL,
    fk_usuario      NUMBER(5) NOT NULL,
    email           VARCHAR2(200) NOT NULL,
    senha           VARCHAR2(8) NOT NULL,
    st_autenticacao CHAR(1),
    dt_cadastro     TIMESTAMP WITH TIME ZONE
);

COMMENT ON COLUMN t_fin_autentificacao.st_autenticacao IS
    'a-ativo
i-inativo';

CREATE UNIQUE INDEX t_fin_autentificacao__idx ON
    t_fin_autentificacao (
        fk_usuario
    ASC );

ALTER TABLE t_fin_autentificacao ADD CONSTRAINT t_fin_autentificacao_pk PRIMARY KEY ( id_aut );

CREATE TABLE t_fin_despesa (
    id_despesa         NUMBER(5) DEFAULT sq_t_fin_despesa.NEXTVAL NOT NULL,
    fk_usuario         NUMBER(5) NOT NULL,
    fk_inst_financeira NUMBER(5) NOT NULL,
    vl_despesa         NUMBER(10, 2) NOT NULL,
    nr_parcela         NUMBER(5),
    dt_despesas        DATE NOT NULL,
    tipo_despesa       CHAR(1) NOT NULL,
    ds_despesa         VARCHAR2(15)
);

COMMENT ON COLUMN t_fin_despesa.tipo_despesa IS
    '1-DINHEIRO
    2-DEBITO
    3-CREDITO';

ALTER TABLE t_fin_despesa ADD CONSTRAINT t_fin_despesa_pk PRIMARY KEY ( id_despesa );


     


CREATE TABLE t_fin_endereco (
    id_end         NUMBER(5) DEFAULT sq_t_fin_endereco.NEXTVAL NOT NULL,
    fk_usuario     NUMBER(5) NOT NULL,
    nm_lougradouro VARCHAR2(200) NOT NULL,
    nm_rua         VARCHAR2(200) NOT NULL,
    nm_bairro      VARCHAR2(200) NOT NULL,
    nm_uf          VARCHAR2(200) NOT NULL,
    nr_lougradouro NUMBER(10) NOT NULL,
    ds_complemento VARCHAR2(200)
);

ALTER TABLE t_fin_endereco ADD CONSTRAINT t_fin_endereco_pk PRIMARY KEY ( id_end );

CREATE TABLE t_fin_inst_financeira (
    id_ins  NUMBER(5) DEFAULT sq_t_fin_inst_financeira.NEXTVAL NOT NULL,
    nr_inst NUMBER(5) NOT NULL,
    nr_ag   NUMBER(4) NOT NULL,
    nr_cc   NUMBER(8) NOT NULL
);

ALTER TABLE t_fin_inst_financeira ADD CONSTRAINT t_fin_inst_financeira_pk PRIMARY KEY ( id_ins );

CREATE TABLE t_fin_investimento (
    id_inv              NUMBER(5) DEFAULT sq_t_fin_investimento.NEXTVAL NOT NULL,
    fk_usuario          NUMBER(5) NOT NULL,
    fk_inst_financeira  NUMBER(5) NOT NULL,
    vl_invest           NUMBER(10, 2) NOT NULL,
    tx_retabilidade_ano NUMBER(3, 2) NOT NULL
);

ALTER TABLE t_fin_investimento ADD CONSTRAINT t_fin_investimento_pk PRIMARY KEY ( id_inv );

CREATE TABLE t_fin_notificacao (
    id_not         NUMBER(5) DEFAULT sq_t_fin_notificacao.NEXTVAL NOT NULL,
    fk_usuario     NUMBER(5) NOT NULL,
    dt_notificacao TIMESTAMP NOT NULL,
    ds_mensagem    VARCHAR2(300) NOT NULL,
    status         CHAR(1) NOT NULL
);

COMMENT ON COLUMN t_fin_notificacao.status IS
    '1- NAO LIDO
2- LIDO';

ALTER TABLE t_fin_notificacao ADD CONSTRAINT t_fin_notificacao_pk PRIMARY KEY ( id_not );

CREATE TABLE t_fin_recebimento (
    id_rec             NUMBER(5) DEFAULT sq_t_fin_recebimento.NEXTVAL NOT NULL,
    fk_usuario         NUMBER(5) NOT NULL,
    fk_inst_financeira NUMBER(5) NOT NULL,
    vl_receb           NUMBER(10, 2) NOT NULL,
    tipo_receb         CHAR(1) NOT NULL,
    dt_receb           DATE NOT NULL,
    ds_receb           VARCHAR2(15)
);

COMMENT ON COLUMN t_fin_recebimento.tipo_receb IS
    '1-DINHEIRO
2-DEBITO';

ALTER TABLE t_fin_recebimento ADD CONSTRAINT t_fin_recebimento_pk PRIMARY KEY ( id_rec );

CREATE TABLE t_fin_servicos (
    id_servicos NUMBER(5) DEFAULT sq_t_fin_servico.NEXTVAL NOT NULL,
    fk_usuario  NUMBER(5) NOT NULL,
    nm_servico  VARCHAR2(50) NOT NULL,
    ds_servico  VARCHAR2(200) NOT NULL,
    tx_servico  NUMBER
);

ALTER TABLE t_fin_servicos ADD CONSTRAINT t_fin_servicos_pk PRIMARY KEY ( id_servicos );

CREATE TABLE t_fin_usuario (
    id_usu          NUMBER(5) DEFAULT sq_t_fin_usuario.NEXTVAL NOT NULL,
    nm_completo     VARCHAR2(70) NOT NULL,
    nr_rg           VARCHAR2(14) NOT NULL,
    nr_cpf          VARCHAR2(14) NOT NULL,
    dt_nascimento   DATE,
    tp_sexo         CHAR(1),
    tp_escolaridade VARCHAR2(20),
    tp_estado_civil VARCHAR2(20)
);

COMMENT ON COLUMN t_fin_usuario.tp_sexo IS
    'F=FEMINO
M=MASCUTLINO';

ALTER TABLE t_fin_usuario ADD CONSTRAINT t_fin_usuario_pk PRIMARY KEY ( id_usu );

ALTER TABLE t_fin_investimento
    ADD CONSTRAINT t_fin_inst_financeira_fk FOREIGN KEY ( fk_inst_financeira )
        REFERENCES t_fin_inst_financeira ( id_ins );

ALTER TABLE t_fin_recebimento
    ADD CONSTRAINT t_fin_inst_financeira_fkv2 FOREIGN KEY ( fk_inst_financeira )
        REFERENCES t_fin_inst_financeira ( id_ins );

ALTER TABLE t_fin_despesa
    ADD CONSTRAINT t_fin_inst_financeira_fkv3 FOREIGN KEY ( fk_inst_financeira )
        REFERENCES t_fin_inst_financeira ( id_ins );

ALTER TABLE t_fin_endereco
    ADD CONSTRAINT t_fin_usuario_fk FOREIGN KEY ( fk_usuario )
        REFERENCES t_fin_usuario ( id_usu );

ALTER TABLE t_fin_investimento
    ADD CONSTRAINT t_fin_usuario_fkv1 FOREIGN KEY ( fk_usuario )
        REFERENCES t_fin_usuario ( id_usu );

ALTER TABLE t_fin_autentificacao
    ADD CONSTRAINT t_fin_usuario_fkv2 FOREIGN KEY ( fk_usuario )
        REFERENCES t_fin_usuario ( id_usu );

ALTER TABLE t_fin_notificacao
    ADD CONSTRAINT t_fin_usuario_fkv3 FOREIGN KEY ( fk_usuario )
        REFERENCES t_fin_usuario ( id_usu );

ALTER TABLE t_fin_servicos
    ADD CONSTRAINT t_fin_usuario_fkv4 FOREIGN KEY ( fk_usuario )
        REFERENCES t_fin_usuario ( id_usu );

ALTER TABLE t_fin_recebimento
    ADD CONSTRAINT t_fin_usuario_fkv6 FOREIGN KEY ( fk_usuario )
        REFERENCES t_fin_usuario ( id_usu );

ALTER TABLE t_fin_despesa
    ADD CONSTRAINT t_fin_usuario_fkv7 FOREIGN KEY ( fk_usuario )
        REFERENCES t_fin_usuario ( id_usu );

-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             1
-- ALTER TABLE                             19
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
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
-- CREATE SEQUENCE                          0
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
-- ERRORS                                   0
-- WARNINGS                                 0