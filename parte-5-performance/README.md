# Teste de Performance - BlazeDemo

Teste de performance desenvolvido utilizando Apache JMeter para simular o fluxo de pesquisa e reserva de voos na aplicação BlazeDemo.

## Tecnologias utilizadas

- Apache JMeter 5.6.3
- Java 21
- CSV para parametrização dos dados

## Cenário de teste

O teste foi configurado com 20 usuários, ramp-up de 20 segundos e 1 iteração por usuário.

Todos os usuários acessam a aplicação e realizam uma pesquisa de voos. Após a pesquisa, 20% dos usuários continuam o fluxo até a conclusão da reserva, enquanto os outros 80% encerram o fluxo após a pesquisa.

Fluxo executado:

1. Acessar a página inicial
2. Pesquisar voos utilizando origem e destino
3. Selecionar um voo (20% dos usuários)
4. Finalizar a reserva (20% dos usuários)

## Parametrização

Os dados de origem e destino são obtidos através do arquivo `dados.csv`, utilizando o CSV Data Set Config do JMeter.

Exemplos utilizados:

- Boston → London
- Paris → Berlin
- Philadelphia → Rome
- San Diego → Cairo
- Mexico City → Dublin

## Correlação

Os dados retornados pela pesquisa de voos são extraídos dinamicamente da resposta utilizando CSS Selector Extractor.

Foram extraídos:

- ID do voo (`flightId`)
- Preço (`flightPrice`)
- Companhia aérea (`airline`)

Esses valores são reutilizados na requisição seguinte responsável pela seleção do voo.

## Distribuição 80/20

Foi utilizado um Throughput Controller configurado com 20% para controlar o fluxo de reserva completa.

Na execução final foram realizadas:

- 20 pesquisas de voos
- 4 seleções de voo
- 4 finalizações de reserva

Dessa forma, 80% das jornadas foram encerradas após a pesquisa e 20% seguiram até a reserva completa.

## Execução em modo não-GUI

O teste pode ser executado através do comando:

```powershell
jmeter -n -t teste-performance.jmx -l resultado.jtl -e -o relatorio