CREATE DATABASE brinquedos;

USE brinquedos;

CREATE TABLE brinquedo (
	id int AUTO_INCREMENT,
	categoria varchar(30),
	nome varchar(100),
	idade_minima int,
	fabricante varchar(100),
	lote int,
	data_compra date,
	PRIMARY KEY(id) );