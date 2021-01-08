--Deleta a tabela
drop table escolaridade;

--Para criar a tabela
create table escolaridade(
	id serial primary key,
	nome varchar,
	data_inicial date,
	data_final date,
	instituicao varchar
)

--Insere os primeiros dados na tabela
insert into escolaridade (nome, data_inicial, data_final, instituicao) values ('pedro', '2020-01-01', '2020-10-10', 'UFSM'), ('patrick', '2010-10-10', '2015-10-10', 'URFJ');

--Seleciona tudo da tabela
select * from escolaridade;
