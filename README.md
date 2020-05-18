# Desafio-API-B2W

## Descrição 
- Criar um jogo com algumas informações da franquia. Para possibilitar a equipe de front criar essa aplicação, queremos desenvolver uma API que contenha os dados dos planetas.
   
## Tecnologias 
- Foi utilizado java 8, Spring Boot 2.2.7, Spring Data MongoDB, Postman.
   
## Funcionalidades Implementadas

- Adicionar um planeta (com nome, clima e terreno). (O numero de aparições em filmes é obtida atráves da api disponibilizada da SWAPI. É permitido inserir um filme não existente na SWAPI, entretanto terá aparições de 0)
- Listar planetas
- Buscar por nome
- Buscar por ID
- Remover planeta

## API endpoints

### GET /planets/
- Retorna todos os planetas cadastrados em formato de lista de json. Caso nenhum esteja cadastrado, retorna uma lista vazia.
- 200 - Successo.    
- Ex: `{"id": "5ec1fb3a2249e22b2842509e", "name": "Naboo", "climate": "temperate", "terrain": "rocks", "numberAppearences": 4}`

### GET /planets/{id}
- Busca um planeta usando o seu id
- 200 - Successo. 404 - Planeta não encontrado.
- Ex: `{"id": "5ec1fb3a2249e22b2842509e", "name": "Naboo", "climate": "temperate", "terrain": "rocks", "numberAppearences": 4}`

### GET /planets/searchPlanet?name=Name
- Busca um planeta usando o seu nome. "name" é um parametro obrigatorio.
- 200 - Successo. 404 - Planeta não encontrado.
- Ex: `{"id": "5ec1fb3a2249e22b2842509e", "name": "Naboo", "climate": "temperate", "terrain": "rocks", "numberAppearences": 4}`


### POST /planets/
- Insere um novo planeta.  
- Enviar um JSON com os campos "name", "climate" e "terrain". Nenhum campo pode ser nulo e o nome do planeta não pode já ter sido salvo. 
- 201 (Created) - Criado com sucesso. 409 (Conflict) - Já existe um planeta cadastrado com este nome.
- Ex: 
```
{
  "name": "Naboo",
  "climate": "temperate",
  "terrain": "rocks"
}
```  
- Ex: `{"id":"5aebc67ce1011035d8c31c0b","name":"Naboo","climate":"temperate","terrain":"rocks","numberAppearancesFilms":4}`

### DELETE /planets/{id}
- Deleta o planeta identificado pelo id.  
- 204 (No Content) - Planeta deletado com Successo. 404 - Planeta não encontrado.  

## Executar
#### Pré-Requisitos

- Java 8 instalado na máquina
- Variável de ambiente JAVA_HOME configurada e apontando para o JDK do Java 8
- MongoDB instalado, configurado.
- As configurações de comunicação da api com o MongoDB estão no applications.properties.
- **_spring.data.mongo.host=localhost_**
- **_spring.data.mongo.port=27017_**
- **_spring.data.mongo.database=mongodb_**

Faça download do projeto ou clone o repositorio e dentro da pasta execute através do cmd o comando `mvn spring-boot: run`
