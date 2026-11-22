# Projeto A3 - Sistema de Chamados de Suporte Técnico

Sistema de gerenciamento de chamados desenvolvido em Java, organizado em duas versões para demonstrar a evolução do projeto.

## Versões

- [Versão 1](Versao-1): implementação inicial do cadastro, listagem, consulta, alteração e exclusão de chamados.
- [Versão 2](Versao-2): versão atualizada, com validações de entradas e tratamento de erros.

## Como executar

Requer o JDK 8 ou superior.

### Versão 1

Abra um terminal na pasta `Versao-1` e execute:

```bash
javac Main.java Chamado.java
java Main
```

### Versão 2

No Windows, abra `Versao-2/executar.bat` com o JDK instalado e configurado no PATH.

Alternativamente, abra um terminal na pasta `Versao-2` e execute:

```bash
javac Main.java Chamado.java
java Main
```

## Funcionalidades

- Cadastrar chamados com identificação automática
- Listar chamados existentes
- Consultar chamados por número
- Alterar informações e status
- Excluir chamados
- Validar dados de entrada

## Limitações

Os chamados são armazenados em memória e não permanecem salvos após o encerramento do programa.

## Tecnologias

Java, programação orientada a objetos, `ArrayList` e `Scanner`.
