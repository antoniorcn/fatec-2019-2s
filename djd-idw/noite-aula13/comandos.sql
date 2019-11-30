-- Comandos do Windows
cd \xampp\mysql\bin
mysql -u root

-- Comandos do Banco de dados Mysql
create database quartel;
show databases;
use quartel;

create table armas (
	id int PRIMARY KEY AUTO_INCREMENT,
	tipo char(100) NOT NULL,
	calibre decimal(7, 2),
	ano int
);
show tables;
desc armas;

INSERT INTO armas (tipo, calibre, ano) VALUES ('Carabina', 0.38, 2000);

SELECT * FROM armas;
