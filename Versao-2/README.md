# Projeto A3 — Sistema de Gerenciamento de Chamados

Sistema desenvolvido em **Java**, executado pelo terminal, para registrar e gerenciar solicitações de suporte técnico.

## Objetivo

Organizar chamados de suporte em um único programa, permitindo acompanhar informações dos solicitantes, prioridades e situações de atendimento.

## Funcionalidades

- **Cadastrar** um chamado com número gerado automaticamente
- **Listar** os chamados cadastrados
- **Consultar** um chamado pelo número
- **Alterar** informações, prioridade e status
- **Excluir** um chamado com confirmação
- Validar entradas do menu e dados obrigatórios

O sistema utiliza operações de **CRUD** (Create, Read, Update e Delete).

## Informações de cada chamado

- Número de identificação
- Nome do solicitante
- E-mail
- Setor
- Título e descrição
- Prioridade: Baixa, Média ou Alta
- Status: Aberto, Em atendimento ou Resolvido

## Tecnologias

- Java (compatível com Java 8 ou superior)
- Programação orientada a objetos
- `ArrayList` para armazenamento durante a execução
- `Scanner` para entrada de dados pelo terminal

## Estrutura do projeto

```text
Projeto-A3/
├── src/
│   ├── Main.java
│   └── Chamado.java
├── executar.bat
├── .gitignore
└── README.md
```

## Como executar

**Windows:** com o JDK instalado e `javac` disponível no PATH, execute `executar.bat`.

**Terminal (Windows, macOS ou Linux):** na pasta do projeto, execute:

```bash
javac -encoding UTF-8 -d bin src/Chamado.java src/Main.java
java -cp bin Main
```

O código-fonte permanece na pasta `src`. A pasta `bin` é criada na compilação e não precisa ser enviada ao GitHub.

## Exemplo de utilização

```text
1 - Cadastrar
2 - Listar
3 - Consultar
4 - Alterar
5 - Apagar
0 - Sair
Opção:
```

## Limitação atual

Os chamados são guardados **em memória**. Ao encerrar o programa, os dados cadastrados são descartados. O armazenamento permanente pode ser desenvolvido em uma próxima versão.

## Próximas melhorias possíveis

- Persistência de dados em arquivo ou banco de dados
- Filtros de chamados por prioridade ou status
- Interface gráfica, caso seja exigida em uma etapa posterior

## Projeto acadêmico

Projeto A3 desenvolvido para demonstrar conceitos de Java, orientação a objetos, validação de dados e operações CRUD.
