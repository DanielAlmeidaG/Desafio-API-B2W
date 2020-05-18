# Desafio-API-B2W

## Descrição 
- Criar um jogo com algumas informações da franquia. Para possibilitar a equipe de front criar essa aplicação, queremos desenvolver uma API que contenha os dados dos planetas.
   
## Como usar a Api
- É necessário possuir o Java e o MongoDB instalados e configurados.
- As configurações de comunicação da api com o MongoDB estão no applications.properties.
      _spring.data.mongo.host=localhost
      spring.data.mongo.port=27017
      spring.data.mongo.database=mongodb_
   
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
