#  Sistema de Gestão de Chamados — Help Desk API

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=flat-square&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=flat-square&logo=mysql)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=flat-square&logo=apachemaven)
![Swagger](https://img.shields.io/badge/Swagger-Docs-85EA2D?style=flat-square&logo=swagger)

Este projeto consiste em uma API REST desenvolvida em **Java** utilizando o ecossistema **Spring Boot**, com o objetivo de gerenciar e organizar chamados de suporte técnico dentro de uma empresa.

A aplicação foi criada com foco em resolver um problema real, substituindo processos informais por um sistema estruturado, permitindo melhor controle, organização e acompanhamento das demandas de TI.

---

##  Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- [Java 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [MySQL 8+](https://dev.mysql.com/downloads/)

---

##  Tecnologias e Ferramentas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **Hibernate**
- **Banco de Dados:** MySQL
- **Swagger / OpenAPI (SpringDoc)**
- **Maven**

---

##  Arquitetura e Padrões

O projeto segue uma arquitetura em camadas, promovendo separação de responsabilidades e organização do código:

- **Controller:** Responsável pela exposição dos endpoints REST e tratamento das requisições HTTP
- **Service:** Contém as regras de negócio e validações da aplicação
- **Repository:** Camada de acesso aos dados utilizando Spring Data JPA
- **DTOs (Data Transfer Objects):** Utilizados para transferência segura de dados entre as camadas
- **Exception Handler:** Tratamento global de exceções com respostas padronizadas (HTTP 400, 404, etc.)

---

##  Funcionalidades

- Cadastro de chamados
- Listagem de chamados
- Busca por ID
- Atualização de status e informações
- Exclusão de chamados
- Padronização de respostas de erro

---

##  Endpoints Principais

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `POST` | `/chamados` | Criar um novo chamado |
| `GET` | `/chamados` | Listar todos os chamados |
| `GET` | `/chamados/{id}` | Buscar chamado por ID |
| `PUT` | `/chamados/{id}` | Atualizar um chamado |
| `DELETE` | `/chamados/{id}` | Remover um chamado |

### Exemplo de payload — `POST /chamados`

```json
{
  "titulo": "Computador não liga",
  "descricao": "O computador do setor financeiro não está ligando desde hoje cedo.",
  "solicitante": "João Silva",
  "status": "ABERTO"
}
```

### Status possíveis

| Status | Descrição |
|--------|-----------|
| `ABERTO` | Chamado recém-criado, aguardando atendimento |
| `EM_ANDAMENTO` | Chamado sendo tratado pela equipe de TI |
| `FECHADO` | Chamado encerrado e resolvido |

---

##  Banco de Dados

A aplicação utiliza o **MySQL** como banco de dados relacional, com integração realizada através do **Spring Data JPA (Hibernate)**.

As entidades são mapeadas utilizando anotações JPA, permitindo a persistência e recuperação dos dados de forma eficiente.

---

##  Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/GabrielAraujoFS/ProgramaDeAbrirChamados.git
cd ProgramaDeAbrirChamados
```

### 2. Configurar o banco de dados

Crie um banco de dados no MySQL:

```sql
CREATE DATABASE helpdesk;
```

Em seguida, edite o arquivo `src/main/resources/application.properties` com suas credenciais:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/helpdesk
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Executar a aplicação

```bash
./mvnw spring-boot:run
```

### 4. Acessar a documentação

Após iniciar a aplicação, acesse a interface do Swagger em:

```
http://localhost:8080/swagger-ui.html
```

---

## Autor

Desenvolvido por **Gabriel Araújo**

[![GitHub](https://img.shields.io/badge/GitHub-GabrielAraujoFS-181717?style=flat-square&logo=github)](https://github.com/GabrielAraujoFS)
