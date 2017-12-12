-- MySQL Database

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Database call_manager
-- -----------------------------------------------------

CREATE SCHEMA IF NOT EXISTS `db_call_manager` DEFAULT CHARACTER SET latin1 ;
USE `db_call_manager` ;

-- -----------------------------------------------------
-- Table usuario (Usada para: CRUD)
-- -----------------------------------------------------

DROP TABLE IF EXISTS `db_call_manager`.`tb_usuario` ;

CREATE TABLE IF NOT EXISTS `db_call_manager`.`tb_usuario` ( 
	`id_usuario` INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'CÓDIGO DO USUÁRIO',
	`login`   VARCHAR(30) NOT NULL COMMENT 'LOGIN DO USUÁRIO PARA ACESSO AO SISTEMA',
	`senha`   VARCHAR(30) NOT NULL COMMENT 'SENHA DO USUÁRIO PARA ACESSO AO SISTEMA'
	);

INSERT INTO `id3960864db_call_manager`.`tb_usuario`(`login`, `senha`) VALUES ('admin', '123456');
INSERT INTO `id3960864db_call_manager`.`tb_usuario`(`login`, `senha`) VALUES ('admin2', 'senha');
INSERT INTO `id3960864db_call_manager`.`tb_usuario`(`login`, `senha`) VALUES ('admin3', 'teste');
-- -----------------------------------------------------
-- Table empresa (Usada para: CRUD)
-- -----------------------------------------------------

DROP TABLE IF EXISTS `db_call_manager`.`tb_empresa` ;

CREATE TABLE IF NOT EXISTS `db_call_manager`.`tb_empresa` (
  `id_empresa`		VARCHAR(15) PRIMARY KEY NOT NULL COMMENT 'IDENTIFICAÇÃO DA EMPRESA',
  `nome_empresa`	VARCHAR(45) NOT NULL COMMENT 'NOME DA EMPRESA',
  `id_usuario` 		INT NOT NULL COMMENT  'FK - USUÁRIO LOGADO QUE REGISTROU O TICKET'
  );
ALTER TABLE `db_call_manager`.`tb_empresa` ADD FOREIGN KEY (id_usuario) REFERENCES `db_call_manager`.`tb_usuario`(id_usuario);


-- -----------------------------------------------------
-- Table localidade (Usada para: CRUD)
-- -----------------------------------------------------

DROP TABLE IF EXISTS `db_call_manager`.`tb_localidade` ;

CREATE TABLE IF NOT EXISTS `db_call_manager`.`tb_localidade` (
  `id_localidade`	INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'IDENTIFICAÇÃO AUTOMÁTICA DA LOCALIDADE',
  `id_empresa` 		VARCHAR(15) NOT NULL COMMENT 'FK - IDENTIFICAÇÃO DA EMPRESA',
  `end_localidade` 	VARCHAR(45) NOT NULL COMMENT 'ENDERECO DE CADA LOCALIDADE DE CADA EMPRESA',
  `criticidade` 	VARCHAR(5)  NOT NULL COMMENT 'VALOR QUE INDICA SE A LOCALIDADE É CRÍTICA'
  );

-- -----------------------------------------------------
-- Table contato (Usada para: CRUD)
-- -----------------------------------------------------

DROP TABLE IF EXISTS `db_call_manager`.`tb_contato` ;

CREATE TABLE IF NOT EXISTS `db_call_manager`.`tb_contato` (
  `cpf`					VARCHAR(14) PRIMARY KEY NOT NULL COMMENT 'PK - CPF DO FUNCIONARIO QUE ESTA LIGANDO',
  `nome_contato`		VARCHAR(45) NOT NULL COMMENT 'NOME DO FUNCIONARIO',
  `email` 				VARCHAR(45) NOT NULL COMMENT 'EMAIL DO FUNCIONARIO',
  `telefone` 			VARCHAR(45) NOT NULL COMMENT 'TELEFONE',
  `departamento` 		VARCHAR(45) NOT NULL COMMENT 'DEPARTAMENTO',
  `cargo` 				VARCHAR(45) NOT NULL COMMENT 'CARGO',
  `end_localidade` 		VARCHAR(45) NOT NULL COMMENT 'ENDERECO DE CADA LOCALIDADE DE CADA EMPRESA',
  `id_empresa` 			VARCHAR(15) NOT NULL COMMENT 'FK - IDENTIFICAÇÃO DA EMPRESA'
);

-- -----------------------------------------------------
-- Table ticket (Usada para Inserir, Alterar e Pesquisar)
-- -----------------------------------------------------

DROP TABLE IF EXISTS `db_call_manager`.`tb_ticket` ;

CREATE TABLE IF NOT EXISTS `db_call_manager`.`tb_ticket` (
  `id_ticket` 			INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'IDENTIFICACAO DO TICKET',
  `fonte_call`			VARCHAR(15) NOT NULL COMMENT 'INDICA POR QUAL MEIO DE CONTATO FOI RECEBIDA A LIGACAO',
  `data_abertura`		VARCHAR(15) NOT NULL COMMENT 'DATA DA ABERTURA DO TICKET',
  `id_empresa` 			VARCHAR(15) COMMENT 'FK - IDENTIFICAÇÃO DA EMPRESA',
  `cpf`					VARCHAR(14) NOT NULL COMMENT 'FK - IDENTIFICACAO DO FUNCIONARIO',
  `telefone`			VARCHAR(45) NOT NULL COMMENT 'TELEFONE DO FUNCIONÁRIO',
  `nome`				VARCHAR(50) COMMENT 'NOME DO FUNCIONÁRIO',
  `end_localidade` 		VARCHAR(45) COMMENT 'LOCALIDADE DA EMPRESA ONDE ELE TRABALHA',
  `titulo`	 			VARCHAR(200) NOT NULL COMMENT 'TITULO DO TICKET',
  `descricao` 			VARCHAR(2000) NOT NULL COMMENT 'DESCRICAO DO TICKET',
  `produto_impactado` 	VARCHAR(20) NOT NULL COMMENT 'BREVE DESCRICAO DO PRODUTO IMPACTADO',
  `impacto` 			VARCHAR(30) NOT NULL COMMENT 'IMPACTO DO INCIDENTE',
  `severidade` 			VARCHAR(30) NOT NULL COMMENT 'SEVERIDADE DO INCIDENTE',
  `id_usuario` 			INT NOT NULL COMMENT  'FK - USUÁRIO LOGADO QUE REGISTROU O TICKET',
  `tipo_solucao`		VARCHAR(50) NOT NULL COMMENT 'INDICA COMO FOI ENCERRADO O TICKET - USADO APENAS PARA RESOLUCAO',
  `solucao`				VARCHAR(2000) NOT NULL COMMENT 'SOLUCAO DETALHADA DOS PROCEDIMENTOS REALIZADOS PELO ANALISTA',
  `fila`				VARCHAR(20) NOT NULL COMMENT 'IDENTIFICAO DA FILA - USADO PARA DIRECIONAMENTO'
);

ALTER TABLE `db_call_manager`.`tb_ticket` ADD FOREIGN KEY (id_usuario) REFERENCES `db_call_manager`.`tb_usuario`(id_usuario);

-- -----------------------------------------------------
-- Table ticket (Usada para Inserir)
-- -----------------------------------------------------

DROP TABLE IF EXISTS `db_call_manager`.`tb_curtas` ;

CREATE TABLE IF NOT EXISTS `db_call_manager`.`tb_curtas` (
  `id_curta` 			INT AUTO_INCREMENT PRIMARY KEY NOT NULL COMMENT 'IDENTIFICACAO DO REGISTRO CURTO',
  `motivo` 				VARCHAR(30) NOT NULL,
  `ticket_number`		VARCHAR(15),
  `id_usuario` 			INT NOT NULL
);

ALTER TABLE `db_call_manager`.`tb_curtas` ADD FOREIGN KEY (id_usuario) REFERENCES `db_call_manager`.`tb_usuario`(id_usuario);