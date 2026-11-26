# Versao 2 - Sistema de Chamados

Versao final do trabalho. Mantem o mesmo cadastro da Versao 1, mas com validacao
mais rigorosa dos dados e algumas melhorias no menu.

## O que mudou em relacao a Versao 1

- O menu so aceita os numeros que existem nas opcoes (0 a 5)
- Os campos de texto tem tamanho minimo e maximo
- Na exclusao o chamado e exibido antes da confirmacao
- A listagem mostra o total de chamados
- Na alteracao os dados atuais sao exibidos antes de pedir os novos

## Dados do chamado

| Campo | Validacao |
|---|---|
| Numero | gerado automaticamente |
| Solicitante | de 3 a 60 caracteres |
| E-mail | precisa ter @ e ponto depois do @ |
| Setor | de 2 a 40 caracteres |
| Titulo | de 5 a 60 caracteres |
| Descricao | de 10 a 300 caracteres |
| Prioridade | Baixa, Media ou Alta |
| Status | Aberto, Em atendimento ou Resolvido |

## Como executar

No Windows basta dar dois cliques em `executar.bat`.

Pelo terminal:

```bash
javac -d bin Chamado.java Main.java
java -cp bin Main
```

A pasta `bin` e criada na compilacao e esta no `.gitignore`.

## Observacao

Os chamados ficam guardados em um ArrayList, ou seja, so existem enquanto o
programa esta rodando. Ao fechar, os dados sao perdidos.
