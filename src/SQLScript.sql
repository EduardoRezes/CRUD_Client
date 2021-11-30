create database dbCrudCliente;
use dbCrudCliente;

create table tb_clientes(codigo int(4) not null auto_increment, nome varchar(30) not null, email varchar(40) not null, dataNascimento date not null, telefone int not null, primary key(codigo));

show tables;
select * from tb_clientes;