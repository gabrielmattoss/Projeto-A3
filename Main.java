import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in, "UTF-8");
    static ArrayList<Chamado> chamados = new ArrayList<>();
    static int proximoId = 1;

    public static void main(String[] args) {
        try {
            int opcao;
            do {
                System.out.println("\n1 - Cadastrar");
                System.out.println("2 - Listar");
                System.out.println("3 - Consultar");
                System.out.println("4 - Alterar");
                System.out.println("5 - Apagar");
                System.out.println("0 - Sair");
                opcao = lerNumero("Opção: ", 0, 5);

                if (opcao == 1) {
                    if (proximoId == Integer.MAX_VALUE) {
                        System.out.println("Limite de numeração atingido.");
                    } else {
                        preencher(null);
                    }
                }

                if (opcao ==  2) {
                    if (chamados.isEmpty()) {
                        System.out.println("Nenhum chamado cadastrado.");
                    } else {
                        for (Chamado chamado : chamados) {
                            System.out.println("\n" + chamado);
                        }
                        System.out.println("Total: " + chamados.size());
                    }
                }

                if (opcao >= 3 && opcao  <= 5) {
                    Chamado chamado = buscar();

                    if (chamado != null) {   
                        System.out.println("\n" + chamado);

                        if (opcao   == 4) {
                            preencher(chamado);
                        }

                        if (opcao == 5) {
                            if (lerNumero("Apagar? 1 - Sim | 2 - Não: ", 1, 2) == 1) {
                                chamados.remove(chamado);
                                System.out.println("Chamado apagado.");
                            } else {
                                System.out.println("Exclusão cancelada.");
                            }
                        }
                    }
                }
            } while (opcao != 0);

            System.out.println("Programa encerrado. Os dados em memória foram descartados.");
        } catch (java.util.NoSuchElementException e) {
            System.out.println("\nEntrada encerrada. Programa finalizado.");
        } finally {
            scanner.close();
        }
    }

    static int lerNumero(String mensagem, int minimo, int maximo) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                int numero = Integer.parseInt(entrada);
                if (numero >= minimo && numero <= maximo) {
                    return numero;
                }
            } catch (NumberFormatException e) {
            }

            System.out.println("Digite um inteiro entre " + minimo + " e " + maximo + ".");
        }
    }

    static String lerTexto(String mensagem, int minimo, int maximo, String formato) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();

            if (texto.length() >= minimo && texto.length() <= maximo
                    && texto.matches(".*[\\p{L}\\p{N}].*")
                    && !texto.matches(".*\\p{Cntrl}.*")
                    && texto.matches(formato)) {
                return texto;
            }

          System.out.println("Entrada inválida. Use de " + minimo + " a " + maximo
                    + " caracteres e respeite o formato solicitado.");
        }
    }

    static void preencher(Chamado chamado) {
        String nome   =  lerTexto("Nome do solicitante: ", 3, 100,
                "[\\p{L}\\p{M}]+(?:[ '\u2019-][\\p{L}\\p{M}]+)*");

        String email = lerTexto("E-mail (nome@empresa.com): ", 1, 254,
                "(?=.{1,64}@)[A-Za-z0-9_%+-]+(?:\\.[A-Za-z0-9_%+-]+)*@(?:[A-Za-z0-9](?:[A-Za-z0-9-]{0,61}[A-Za-z0-9])?\\.)+[A-Za-z]{2,63}");

        String setor = lerTexto("Setor: ", 2, 80, ".*");
        String titulo = lerTexto("Título: ", 5, 100, ".*");
        String descricao = lerTexto("Descrição: ", 10, 1000, ".*");

        String[] prioridades = {"Baixa", "Média", "Alta"};
        String prioridade = prioridades[lerNumero("Prioridade: 1 - Baixa | 2 - Média | 3 - Alta: ", 1, 3)-1];

        if (chamado == null) {
            chamados.add(new Chamado(proximoId, nome, email, setor, titulo, descricao, prioridade, "Aberto"));
            System.out.println("Chamado cadastrado. Número: " + proximoId);
            proximoId++;
        } else {
            String[] situacoes = {"Aberto", "Em atendimento", "Resolvido"};
            String status = situacoes[lerNumero("Status: 1 - Aberto | 2 - Em atendimento | 3 - Resolvido: ", 1, 3) - 1];
            chamado.atualizar(nome, email, setor, titulo, descricao, prioridade, status);
            System.out.println("Chamado alterado.");
        }
    }

    static Chamado buscar() {
        if (chamados.isEmpty()) {
            System.out.println("Nenhum chamado cadastrado.");
            return null;
        }

        while (true) {
            int id = lerNumero("Número do chamado (0 para voltar): ", 0, Integer.MAX_VALUE);

            if (id == 0) {
                return null;
            }

            for (Chamado chamado : chamados) {
                if (chamado.getId() == id) {
                    return chamado;
                }
            }

            System.out.println("Chamado não encontrado. Informe um número existente.");
        }
    }
}
