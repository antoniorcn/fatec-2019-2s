 mysql -u root -p
 
 show databases;
 
 create database hoteldb;
 
 use hoteldb;
 
 show tables;
 
 create table quartohotel (
	id int PRIMARY KEY AUTO_INCREMENT,
	numero_quarto char(30),
	numero_camas int,
	descricao varchar(255),
	valor_reserva decimal(7,2)
 );
 
 select * from quartohotel;
 
 INSERT INTO quartohotel (numero_quarto, numero_camas, valor_reserva, descricao) VALUES 
 ('101', 2, 89.90, 'Suite Master com banheira');
 