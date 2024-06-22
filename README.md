# <h1 align="center"> 💻 Desafio: Fórum Hub </h1>

## 🏹 Objetivo
- Fazer um projeto que disponibiliza fórum de perguntas e respostas na área de TI.

## Status:
- Em andamento

# 🔨 Ferramentas:
- Java 17.0
- Spring Boot
- JPA Hibernate
- MySQL
- Autenticação JWT

## Como usar:
- Execute o arquivo ForumApplication
- na url digite:  ```localhost:7080/``` e a rota.</br>
  Exemplo: ```localhost:7080/user/register```
- rotas
  - usuário
    | Route  | Method Http | Description | Exemplo de Requisição pelo arquivo json  |
    |---------------| ------------- | ------------ | -------- |
    | /user/register     |  POST  | Criar usuário | ```{ "fullname": "Nome Sobrenome", "email": "name@email.com", "password": "123%5D1a", "userName": "nome1"} ``` |

  - curso
     | Route  | Method Http |  Description | Exemplo de Requisição pelo arquivo json  |
    |---------------| ------------- | -------- | ---------- |
    | /course/register     |  POST | Criar curso | ```{ "name": "JavaScript", "category": "BACKEND" } ``` |
    
  - tópico
    | Route  | Method Http |  Description | Exemplo de Requisição pelo arquivo json  |
    |---------------| ------------- | -------- | ------------- |
    | /topic/register     |  POST  | Criar tópicos |  ```{ "id": 1, "title": "Not Function", "message": "Estou tentado separar os números pela funcção split, mas não estou conseguindo. Estou utilizando numero.split()", "status": "PUBLICADO", "idAuthor": 1, "idCourse": 1}``` |
    | /topic/getData/:id  |    GET  | Listar tópico específico | Nenhum |
    | /topic/getAllData  |    GET  | Listar tópico com status published ordenado por data criada | Nenhum |

  - autenticação
      | Route  | Method Http |  Description | Exemplo de Requisição pelo arquivo json  |
    |---------------| ------------- | -------- | ------------- |
    | /login     |  POST  | Criar tópicos |  ```{ "email": "name@email.com", "password": "123%5D1a"}``` |
