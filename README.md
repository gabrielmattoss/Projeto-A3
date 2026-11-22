# Projeto A3 - Sistema de Chamados de Suporte Tecnico

Primeira versao de um sistema em Java para cadastrar e gerenciar chamados de suporte tecnico pelo terminal.

## Funcionalidades

- Cadastrar chamado com numero automatico
- Listar todos os chamados
- Consultar um chamado pelo numero
- Alterar informacoes e status
- Excluir chamado com confirmacao
- Validar campos obrigatorios, e-mail e opcoes do menu

## Como executar

Requer Java 8 ou superior.

```bash
javac Main.java Chamado.java
java Main
```

Os chamados sao armazenados em memoria enquanto o programa esta aberto. Esta primeira versao ainda nao salva os dados em arquivo ou banco de dados.
