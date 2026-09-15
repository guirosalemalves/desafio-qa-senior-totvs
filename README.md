# Desafio Técnico - Analista de Qualidade de Software Sênior

Este repositório contém a resolução do desafio técnico para a posição de Analista de Qualidade de Software Sênior.

O desafio foi dividido em cinco partes, envolvendo conhecimentos teóricos de Qualidade de Software e atividades práticas de automação de API, Web, scripting e testes de performance.

## Estrutura do projeto

### Parte 1 - Conhecimentos de QA
Resolução das questões teóricas envolvendo estratégia de testes, automação, APIs, CI/CD, segurança, performance e práticas de qualidade.

📁 `parte-1-teoria`

### Parte 2 - Automação de API
Automação de testes utilizando a Fake Store API, contemplando criação de produtos, criação de carrinho, consulta e exclusão.

**Tecnologias:**
- Java 21
- RestAssured
- JUnit 5
- Hamcrest
- Maven

📁 `parte-2-api`

### Parte 3 - Automação Web
Automação do fluxo de compra no SauceDemo, contemplando login, adição de produtos ao carrinho e checkout completo.

A estrutura dos testes utiliza Page Object Model para separar os cenários de teste das interações com as páginas.

**Tecnologias:**
- Cypress
- JavaScript
- Page Object Model

📁 `parte-3-web`

### Parte 4 - Validação de E-mails
Script desenvolvido para validar uma lista de e-mails, verificando sintaxe e existência de registros MX no domínio.

O resultado das validações é exportado para um arquivo CSV.

**Tecnologias:**
- Java 21
- Regex
- Consulta DNS/MX

📁 `parte-4-script`

### Parte 5 - Teste de Performance
Teste de performance desenvolvido no Apache JMeter utilizando a aplicação BlazeDemo.

O cenário simula usuários realizando pesquisa de voos, sendo que 20% continuam o fluxo até a conclusão da reserva.

Foram utilizados parametrização por CSV, correlação dinâmica de dados e execução em modo não-GUI com geração de relatório HTML.

**Tecnologias:**
- Apache JMeter 5.6.3
- CSV Data Set Config
- CSS Selector Extractor
- Throughput Controller

📁 `parte-5-performance`

## Organização

Cada parte possui sua própria documentação com informações sobre implementação, execução e decisões tomadas durante o desenvolvimento.

```text
desafio-qa-senior-totvs/
├── parte-1-teoria/
├── parte-2-api/
├── parte-3-web/
├── parte-4-script/
├── parte-5-performance/
├── .gitignore
└── README.md