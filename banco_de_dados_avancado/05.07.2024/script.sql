drop database if exists MePoupe;
create database MePoupe;
use MePoupe;

create table cliente(
cod_cliente int auto_increment,
nome varchar(50),
CPF char(11),
sexo char(1),
dt_nasc date,
telefone char(15),
email varchar(100),
primary key(cod_cliente));

insert into cliente values(1,'Bill Clinton','12999786543','M','1940-04-12', '11999786543',
 'william@gmail.com'),
 (2,'Trump', '13999786544', 'M','1942-05-10', '11999186543', 'trump@gmail.com');
 
 
create table conta_corrente(
cod_conta int auto_increment,
dt_hora_abertura datetime,
saldo numeric(9,2),
status_conta varchar(15),
cod_cliente int,
primary key(cod_conta),
foreign key(cod_cliente)references cliente(cod_cliente));

insert into conta_corrente values (1,'2020-03-15 13:50:00', 50,'Ativa',1);
insert into conta_corrente values (2,'2020-03-18 15:30:00',500,'Ativa',2);


create table Registro_Saque(
cod_saque int auto_increment,
cod_conta int,
dt_saque datetime,
valor_saque numeric(9,2),
primary key(cod_saque),
foreign key(cod_conta)references conta_corrente(cod_conta));

 create table Registro_Deposito(
cod_deposito int auto_increment,
cod_conta int,
dt_deposito datetime,
valor_deposito numeric(9,2),
primary key(cod_deposito),
foreign key(cod_conta)references conta_corrente(cod_conta));

insert into registro_saque values(1,2,'2020-03-20 14:00:00', 20);
insert into registro_saque values(2,2,'2020-04-20 17:30:00', 80);

insert into registro_deposito values(1,2,'2020-03-19 16:10:00', 40);
insert into registro_deposito values(2,2,'2020-04-22 19:15:00', 800);

select * from registro_deposito;

-- 2) Crie o procedimento sp_insere_cli que irá receber como dados de entrada o nome,
-- CPF, sexo, data de nascimento, telefone e email de um cliente e fará a inserção na
-- tabela cliente. Validar o preenchimento de campos obrigatórios.
-- Cliente(cod_cliente, nome, CPF,sexo, dt_nasc, Telefone, email)

DELIMITER $
CREATE PROCEDURE sp_insere_cli (var_nome varchar(100), var_cpf varchar(14), var_sexo char, var_dt_nasc date, var_telefone varchar(15), var_email varchar(100))
begin
	if (var_cpf is null or var_nome is null) then 
		select "O cpf e o nome são de preenchimento obrigatório" as msg_erro;
	else
		Insert into cliente(nome, CPF, sexo, dt_nasc, telefone, email) values (var_nome, var_cpf, var_sexo, var_dt_nasc, var_telefone, var_email); 
	end if;
END $
DELIMITER ;

-- 1) Insira na base de dados:
-- a. 2 Clientes, 2 contas, 8 registros de depósitos e 6 registros de saques
-- distribuídos pelas diversas contas.

call sp_insere_cli('Dilma Rouseff','12999786543','F','1940-04-12', '11999786543', 'dilma@gmail.com');
call sp_insere_cli('Cabo Daciolo', '13999786544', 'M','1942-05-10', '11999186543', 'cabo@gmail.com');
 
insert into conta_corrente values (3,'2024-01-14 12:50:00', 20,'Ativa',3);
insert into conta_corrente values (4,'2024-02-12 12:30:00', 200, 'Ativa',4);

insert into registro_deposito values (3,3,'2024-03-05 16:10:00', 40);
insert into registro_deposito values (4,4,'2024-01-22 19:15:00', 800);
insert into registro_deposito values (5,3,'2024-03-05 16:10:00', 50);
insert into registro_deposito values (6,3,'2024-03-06 17:10:00', 60);
insert into registro_deposito values (7,4,'2024-01-23 14:15:00', 200);
insert into registro_deposito values (8,3,'2024-03-06 11:10:00', 20);
insert into registro_deposito values (9,3,'2024-03-07 11:10:00', 140);
insert into registro_deposito values (10,4,'2024-01-24 19:15:00', 150);

insert into registro_saque values (3,3,'2024-03-15 14:00:00', 20);
insert into registro_saque values (4,4,'2024-02-20 17:30:00', 80);
insert into registro_saque values (5,3,'2024-03-16 15:00:00', 30);
insert into registro_saque values (6,4,'2024-02-21 18:30:00', 100);
insert into registro_saque values (7,3,'2024-03-17 13:00:00', 200);
insert into registro_saque values (8,4,'2024-02-22 11:30:00', 830);

-- 3) Faça um procedimento para registrar uma transferência de uma conta para outra:
-- Observações:
-- • Criar a tabela registro de transferência antes de fazer a criação do procedimento.

-- • Campos: codigo da transferência, codigo da conta de origem, codigo da conta de
-- destino, valor da transferência, data e hora.

-- • Parâmetros de entrada: codigo da conta de origem, codigo da conta de
-- destino,valor da transferência.
-- • Validar se a conta de origem tem saldo suficiente antes de efetuar a transferência.
-- • Atualizar o saldo da conta de origem e da conta de destino.

create table registro_transferencia(
	cod_transferencia int auto_increment,
	cod_conta_origem int,
	cod_conta_destino int,
	valor_transferencia float,
	dt_transferencia date_time,
	foreign key(cod_conta_origem) references conta_corrente(cod_conta),
	foreign key(cod_conta_destino) references conta_corrente(cod_conta)
);


DELIMITER $
CREATE PROCEDURE sp_insere_registro_transf (var_cod_conta_origem int, var_cod_conta_destino int, var_valor_transferencia float))
begin
	declare saldo float;
	set saldo = select * from conta_corrente cc where cc.saldo = var_cod_conta_origem;
	if (saldo < var_valor_transferencia) then 
		select "Não há saldo suficiente para transferência" as msg_erro;
	else
		Insert into cliente(nome, CPF, sexo, dt_nasc, telefone, email) values (var_nome, var_cpf, var_sexo, var_dt_nasc, var_telefone, var_email); 
	end if;
END $
DELIMITER ;



-- 4) Crie um procedimento que terá como entrada uma data de inicial e uma data final e irá
-- gerar um relatório contendo o nome do cliente, número da conta e o valor total de depósitos
-- realizados para a conta no período informado. Ordenar pelo valor total dos depósitos.
-- 5)Crie um procedimento para fazer o relatório anual das contas, informando como entrada o
-- ano e código do relatório desejado (1: total de Saques ou 2: total de depósitos). O relatório
-- deverá conter o número da conta, mês , total de saques (se código do relatório for 1) ou total
-- de depósitos (se código do relatório for 2).
