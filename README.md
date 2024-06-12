# <h1 align="center"> 💻 Desafio: Fórum Hub </h1>

## 🏹 Objetivo
- Fazer um projeto que disponibiliza fórum de perguntas e respostas na área de TI.

## Status:
- Em andamento

## 🧩 Funcionalidades

| Feature  | Details | Status     | 
|---------------| ------------- | ------------ |
| Criar modelos e dtos | <ul><li>Tabela Usuário</li> <li>Tabela Tópicos </li> <li>Tabela Cursos </li> <li>Tabela Respostas dos Tópicos </li> </ul> | Finalizado |
| Mais funcionalidades a serem adicionadas....| | Pendente |

# 🔨 Ferramentas:
- Java 17.0
- Spring Boot
- JPA Hibernate
- MySQL
- Autenticação

## Como usar:
- Execute o arquivo ForumApplication
- na url digite:  ```localhost:7080/``` e a rota.</br>
  Exemplo: ```localhost:7080/user/register```
- rotas
  - usuário
    | Route  | Method Http | Exemplo de Requisição pelo arquivo json  |
    |---------------| ------------- | -------- |
    | /user/register     |  POST         | ```{ "name": "Nome Sobrenome", "email": "name@email.com", "password": "123%5D1a", "userName": "nome1"} ``` |
