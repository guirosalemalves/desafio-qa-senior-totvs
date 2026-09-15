# Validação de E-mails

Script desenvolvido em Java para validar uma lista de e-mails e gerar um arquivo CSV com o resultado das validações.

## Tecnologias utilizadas

- Java 21
- Regex para validação da sintaxe
- Consulta DNS para verificação de registros MX

## Funcionamento

O script realiza as seguintes validações:

- Validação da sintaxe do e-mail
- Consulta do domínio através de registros MX
- Identificação do motivo em caso de e-mail inválido
- Geração do arquivo `validacao_emails.csv`

Os e-mails utilizados como entrada estão no arquivo `emails.txt`.

## Executando

Na pasta `parte-4-script`, executar:

```bash
javac src/ValidadorEmails.java
java -cp src ValidadorEmails