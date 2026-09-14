# Automação de API - Fake Store API

Automação desenvolvida para validar operações de criação e consulta de produtos e carrinhos utilizando a Fake Store API.

## Tecnologias utilizadas

- Java 21
- Maven
- JUnit 5
- RestAssured
- Hamcrest

## Cenários automatizados

- Criação de dois produtos via POST `/products`
- Validação do status HTTP na criação dos produtos
- Extração dos IDs retornados pela API
- Criação de carrinho via POST `/carts`
- Validação dos produtos enviados na resposta do carrinho
- Consulta de carrinho via GET `/carts/{id}`
- Validação dos dados retornados na consulta
- Exclusão de carrinho via DELETE `/carts/{id}`

## Executando os testes

Na pasta `parte-2-api`, executar:

```bash
mvn test

## Observação

Durante os testes foi identificado que a Fake Store API simula as operações de criação, mas não persiste os novos recursos.

Na criação dos produtos, a API retornou o mesmo ID para requisições diferentes. O carrinho criado também retornou um ID, porém a consulta posterior desse recurso retornou `null`.

Por esse motivo, a validação do GET foi realizada utilizando um carrinho já existente na API. No caso o carrinho '1'.