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

**Pré-requisitos:**
- Java JDK 21
- MySQL Server 8
- Banco de dados `biblioteca_virtual` criado
- Porta 8080 disponível

Abra o PowerShell na pasta raiz do projeto.

**1. Configure a senha do MySQL:**

```powershell
$env:DB_PASSWORD = Read-Host "Senha do MySQL"
```

Informe a senha do usuário `root` do MySQL quando solicitada.

**2. Execute a aplicação:**

```powershell
.\mvnw.cmd spring-boot:run
```

**3. Acesse os serviços:**

- API REST: http://localhost:8080
- Documentação Swagger: http://localhost:8080/swagger-ui/index.html

**Observação:** a senha é armazenada apenas na sessão atual do PowerShell e precisa ser informada novamente ao abrir um novo terminal. O arquivo `application.properties` utiliza a variável de ambiente `DB_PASSWORD`, evitando armazenar credenciais diretamente no código-fonte.

## Arquitetura

- model: entidades JPA
- dto: transferencia e validacao de dados
- repository: persistencia
- service: regras de negocio
- controller: endpoints REST
- exception: tratamento de erros

## Uso de Inteligência Artificial

Durante o desenvolvimento do projeto, utilizei o **ChatGPT (OpenAI)** como ferramenta de apoio técnico, principalmente para auxiliar na identificação, análise e resolução de erros, além de fornecer estruturas iniciais de código que serviram como base para a implementação da aplicação.

A inteligência artificial também foi utilizada como suporte nas seguintes atividades:

- **Estruturação do código:** sugestões para a organização da arquitetura em camadas, utilizando Controllers, Services, Repositories, Models e DTOs.
- **Depuração e resolução de problemas:** auxílio na interpretação de mensagens de erro, identificação de possíveis causas e aplicação de correções.
- **Desenvolvimento da API REST:** apoio na elaboração e implementação de endpoints HTTP e operações CRUD com Java e Spring Boot.
- **Persistência de dados:** orientações para a integração com MySQL, utilização do Spring Data JPA e mapeamento de entidades.
- **Validação e tratamento de exceções:** suporte na implementação de validações de entrada e respostas HTTP apropriadas.
- **Documentação técnica:** auxílio na organização do README, documentação de endpoints e utilização do Swagger/OpenAPI.

A utilização da IA ocorreu como recurso de suporte ao processo de desenvolvimento. Fiquei responsável pela configuração do ambiente, execução dos procedimentos, integração dos componentes, acompanhamento dos resultados e realização dos testes funcionais.

## Contribuições Individuais

**Integrante:** Emanuel Cavalcante Chiarizzi  
**GitHub:** [@EmanuelChiarizzi](https://github.com/EmanuelChiarizzi)  
**Composição da equipe:** Projeto individual — equipe formada por apenas um integrante.

Fui o único integrante responsável pelo desenvolvimento e entrega do projeto Biblioteca Virtual, participando de todas as etapas de construção da aplicação, desde a preparação do ambiente até a publicação do código-fonte.

### Atividades técnicas realizadas

1. **Planejamento e arquitetura:** definição da estrutura da API REST e organização do projeto em camadas, seguindo princípios de separação de responsabilidades.
2. **Configuração do ambiente:** preparação do JDK 21, Maven, Spring Boot e ambiente de desenvolvimento no Visual Studio Code.
3. **Modelagem e persistência:** criação e configuração do banco de dados MySQL, desenvolvimento das entidades JPA e implementação dos repositórios com Spring Data JPA.
4. **Implementação dos CRUDs:** desenvolvimento e integração das operações de cadastro, consulta, atualização e exclusão para livros, autores, categorias, empréstimos e materiais digitais.
5. **Regras de negócio:** implementação da camada de serviços, da pesquisa de livros por título e do relacionamento entre livros e empréstimos.
6. **Validação e tratamento de erros:** integração de DTOs, validações de entrada e mecanismos de tratamento de exceções HTTP.
7. **Testes e depuração:** execução de requisições HTTP via PowerShell, verificação das operações CRUD, testes de integração com o banco e correção de problemas identificados durante o desenvolvimento.
8. **Documentação da API:** configuração do Swagger/OpenAPI para visualização dos endpoints e elaboração da documentação técnica no README.
9. **Versionamento e publicação:** inicialização do repositório Git, organização dos arquivos, criação de commit e publicação do projeto no GitHub.
10. **Preparação da entrega:** organização dos arquivos do projeto, identificação do commit utilizado e geração do pacote ZIP para submissão acadêmica.

## Observações

O projeto consiste em uma aplicação **backend desenvolvida em Java com Spring Boot**, disponibilizando uma API REST para gerenciamento de uma biblioteca virtual escolar.

A aplicação utiliza MySQL para persistência dos dados e Swagger/OpenAPI para documentação e exploração dos endpoints.

O desenvolvimento foi realizado individualmente, com utilização de inteligência artificial como ferramenta de apoio técnico.
