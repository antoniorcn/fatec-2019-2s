cd \xampp\mysql\bin

mysql -u root -p

show databases;

create database hardwares;

use hardwares;

create table hardware (
	id int PRIMARY KEY AUTO_INCREMENT,
	tipo char(100),
	fabricante char(100),
	descricao varchar(255),
	preco decimal(7,2)
);

desc hardware;

INSERT INTO hardware (tipo, fabricante, descricao, preco) VALUES ('Impresssora HP 600', 'HP', 'Impressora jato de tinta', 1000.00);