
# Cadastro Escolaridade - Serviço Rest

Cadastro de Escolaridade é um serviço rest que cadastra dados relacionados a escolaridade de uma pessoa. É construido 
em cima das tecnologias Spring Boot, Spring Data Jpa, PostgreSQL e documentado com Swagger.

## Documentação

Documentação feita com swagger e pode ser acessada [aqui.](https://app.swaggerhub.com/apis-docs/cararax/CadastroEscolaridade/1.0) 

## Para rodar a aplicação

###Banco de dados
No PostgreSQL crie uma banco de dados chamado "escolaridade" e rode os comandos abaixo para criar a tabela.
```bash
#Para criar a tabela
create table escolaridade(
	id serial primary key,
	nome varchar,
	data_inicial date,
	data_final date,
	instituicao varchar
)

#Insere os primeiros dados na tabela
insert into escolaridade (nome, data_inicial, data_final, instituicao) values ('pedro', '2020-01-01', '2020-10-10', 'UFSM'), ('patrick', '2010-10-10', '2015-10-10', 'URFJ')
```
Também disponíveis no arquivo [data.sql](data.sql).

### Iniciar aplicação
Para iniciar a aplicação rode o comando abaixo no diretório raiz.
```python
mvn clean && mvn spring-boot:run
```

## Licença
[WTFPL](http://www.wtfpl.net/)

## Autor
[Pedro Carara](https://github.com/cararax)
