# Biblioteca Virtual - Projeto NP2

Backend de uma biblioteca virtual para uma escola de ensino medio, desenvolvido como API REST.

## Tecnologias

- Java 21
- Spring Boot 4
- Spring Data JPA / Hibernate
- MySQL 8
- Maven
- Swagger / OpenAPI
- Lombok
- Bean Validation

## Funcionalidades

- CRUD completo de livros
- CRUD completo de autores
- CRUD completo de categorias
- CRUD completo de emprestimos
- CRUD completo de materiais digitais
- Pesquisa de livros por titulo
- Relacionamento entre livros e emprestimos
- Validacao de dados e tratamento de erros

## Endpoints

| Recurso | Rota |
|---|---|
| Livros | /livros |
| Autores | /autors |
| Categorias | /categorias |
| Emprestimos | /emprestimos |
| Materiais digitais | /materialdigitals |
| Pesquisa de livros | /livros/pesquisar?titulo=java |

Cada CRUD disponibiliza POST, GET, GET por ID, PUT e DELETE.

## Configuracao do banco

Execute no MySQL:

CREATE DATABASE IF NOT EXISTS biblioteca_virtual;

O projeto utiliza Hibernate com ddl-auto=update para criar e atualizar as tabelas. Migrations nao foram implementadas por serem opcionais.

## Como executar no Windows

Requisitos:
- JDK 21
- MySQL Server 8
- Porta 8080 disponivel

No PowerShell, dentro da pasta do projeto:

1. Configure a senha do MySQL:

$env:DB_PASSWORD = Read-Host "Senha do MySQL"

2. Execute a aplicacao:

.\mvnw.cmd spring-boot:run

API: http://localhost:8080

Swagger: http://localhost:8080/swagger-ui/index.html

## Arquitetura

- model: entidades JPA
- dto: transferencia e validacao de dados
- repository: persistencia
- service: regras de negocio
- controller: endpoints REST
- exception: tratamento de erros

## Uso de inteligencia artificial

Ferramenta: ChatGPT (OpenAI).

Utilizacao: apoio na estruturacao do backend, geracao de codigo, depuracao, documentacao e testes.

Verificacao: compilacao Maven, execucao do Spring Boot, testes HTTP dos CRUDs e consulta das rotas pelo Swagger. O tratamento de erros teve sua compilacao verificada, sem teste final de resposta.

## Contribuicoes

- Emanuel - GitHub: @EmanuelChiarizzi

As contribuicoes individuais devem ser descritas conforme o trabalho efetivamente realizado por cada integrante.

## Observacoes

Projeto exclusivamente backend, sem interface grafica.
O desenvolvimento foi realizado com apoio de IA.
