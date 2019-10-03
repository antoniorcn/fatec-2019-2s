CREATE DATABASE entregas;

USE entregas;

CREATE TABLE entrega (
	id int AUTO_INCREMENT,
	origem varchar(100),
	destino varchar(100),
	dimensoes varchar(50),
	peso float,
	data date,
	frete float,
	status varchar(20),
	PRIMARY KEY (id) );