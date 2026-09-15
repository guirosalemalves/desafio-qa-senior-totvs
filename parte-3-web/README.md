# Automação Web - SauceDemo

Automação de testes desenvolvida com Cypress para validar o fluxo principal de compra na aplicação SauceDemo.

## Tecnologias utilizadas

- Cypress
- JavaScript
- Page Object Model

## Cenários automatizados

- Login com sucesso utilizando `standard_user`
- Validação do redirecionamento para a página de produtos
- Adição de dois produtos ao carrinho
- Validação do contador do carrinho
- Preenchimento dos dados de checkout
- Finalização da compra
- Validação da mensagem `Thank you for your order!`

## Estrutura

O projeto utiliza Page Object Model para separar os cenários de teste das ações realizadas nas páginas.

Os Page Objects estão localizados em:

`cypress/pages`

E os cenários automatizados em:

`cypress/e2e`

## Executando os testes

Na pasta `parte-3-web`, instalar as dependências:

```bash
npm install
```

Executar os testes em modo headless:

```bash
npx cypress run
```

Para abrir a interface do Cypress:

```bash
npx cypress open
```

## Evidências

Durante a execução dos testes são geradas evidências dos principais cenários automatizados:

- Login realizado com sucesso
- Adição de dois produtos ao carrinho
- Checkout finalizado com sucesso

As imagens são armazenadas na pasta `evidencias`.