import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Chamado> chamados = new ArrayList<Chamado>();
    static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n=== SISTEMA DE CHAMADOS ===");
            System.out.println("1 - Cadastrar chamado");
            System.out.println("2 - Listar chamados");
            System.out.println("3 - Consultar chamado");
            System.out.println("4 - Alterar chamado");
            System.out.println("5 - Excluir chamado");
            System.out.println("0 - Sair");
            opcao = lerNumero("Escolha uma opcao: ", 0, 5);

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    consultar();
                    break;
                case 4:
                    alterar();
                    break;
                case 5:
                    excluir();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
            }
        } while (opcao != 0);
    }

    // le um numero inteiro e so devolve quando estiver dentro da faixa permitida
    static int lerNumero(String mensagem, int minimo, int maximo) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();

            try {
                int numero = Integer.parseInt(entrada);
                if (numero >= minimo && numero <= maximo) {
                    return numero;
                }
                System.out.println("Digite um numero entre " + minimo + " e " + maximo + ".");
            } catch (NumberFormatException e) {
                System.out.println("Isso nao e um numero valido.");
            }
        }
    }

    // le um texto e verifica se o tamanho esta dentro do minimo e do maximo
    static String lerTexto(String mensagem, int minimo, int maximo) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();

            if (texto.length() < minimo) {
                System.out.println("Precisa ter pelo menos " + minimo + " caracteres.");
            } else if (texto.length() > maximo) {
                System.out.println("Precisa ter no maximo " + maximo + " caracteres.");
            } else {
                return texto;
            }
        }
    }

    static String lerEmail() {
        while (true) {
            String email = lerTexto("E-mail: ", 5, 100);

            int arroba = email.indexOf("@");
            int ponto = email.lastIndexOf(".");

            // o arroba precisa existir, e o ponto tem que vir depois dele
            if (arroba > 0 && ponto > arroba + 1 && ponto < email.length() - 1) {
                return email;
            }

            System.out.println("E-mail invalido. Use o formato nome@empresa.com");
        }
    }

    static String lerPrioridade() {
        int opcao = lerNumero("Prioridade: 1 - Baixa | 2 - Media | 3 - Alta: ", 1, 3);

        if (opcao == 1) {
            return "Baixa";
        } else if (opcao == 2) {
            return "Media";
        } else {
            return "Alta";
        }
    }

    static String lerStatus() {
        int opcao = lerNumero("Status: 1 - Aberto | 2 - Em atendimento | 3 - Resolvido: ", 1, 3);

        if (opcao == 1) {
            return "Aberto";
        } else if (opcao == 2) {
            return "Em atendimento";
        } else {
            return "Resolvido";
        }
    }

    // percorre a lista procurando o chamado com aquele numero
    static Chamado buscar(int id) {
        for (int i = 0; i < chamados.size(); i++) {
            if (chamados.get(i).getId() == id) {
                return chamados.get(i);
            }
        }
        return null;
    }

    // pede o numero do chamado ao usuario e devolve o objeto encontrado
    static Chamado pedirChamado() {
        if (chamados.isEmpty()) {
            System.out.println("Nenhum chamado cadastrado.");
            return null;
        }

        int id = lerNumero("Numero do chamado: ", 1, 9999);
        Chamado chamado = buscar(id);

        if (chamado == null) {
            System.out.println("Chamado nao encontrado.");
        }

        return chamado;
    }

    static void cadastrar() {
        System.out.println("\n--- CADASTRAR CHAMADO ---");

        String solicitante = lerTexto("Nome do solicitante: ", 3, 60);
        String email = lerEmail();
        String setor = lerTexto("Setor: ", 2, 40);
        String titulo = lerTexto("Titulo: ", 5, 60);
        String descricao = lerTexto("Descricao: ", 10, 300);
        String prioridade = lerPrioridade();

        // chamado novo sempre comeca com status Aberto
        Chamado chamado = new Chamado(proximoId, solicitante, email, setor,
                titulo, descricao, prioridade, "Aberto");
        chamados.add(chamado);

        System.out.println("Chamado cadastrado com o numero " + proximoId + ".");
        proximoId++;
    }

    static void listar() {
        System.out.println("\n--- CHAMADOS CADASTRADOS ---");

        if (chamados.isEmpty()) {
            System.out.println("Nenhum chamado cadastrado.");
            return;
        }

        for (Chamado chamado : chamados) {
            System.out.println("\n" + chamado);
        }

        System.out.println("\nTotal de chamados: " + chamados.size());
    }

    static void consultar() {
        System.out.println("\n--- CONSULTAR CHAMADO ---");

        Chamado chamado = pedirChamado();
        if (chamado != null) {
            System.out.println("\n" + chamado);
        }
    }

    static void alterar() {
        System.out.println("\n--- ALTERAR CHAMADO ---");

        Chamado chamado = pedirChamado();
        if (chamado == null) {
            return;
        }

        System.out.println("\nDados atuais:");
        System.out.println(chamado);
        System.out.println("\nDigite os novos dados:");

        String solicitante = lerTexto("Nome do solicitante: ", 3, 60);
        String email = lerEmail();
        String setor = lerTexto("Setor: ", 2, 40);
        String titulo = lerTexto("Titulo: ", 5, 60);
        String descricao = lerTexto("Descricao: ", 10, 300);
        String prioridade = lerPrioridade();
        String status = lerStatus();

        chamado.atualizar(solicitante, email, setor, titulo, descricao, prioridade, status);
        System.out.println("Chamado alterado com sucesso.");
    }

    static void excluir() {
        System.out.println("\n--- EXCLUIR CHAMADO ---");

        Chamado chamado = pedirChamado();
        if (chamado == null) {
            return;
        }

        System.out.println("\n" + chamado);

        int confirma = lerNumero("\nConfirma a exclusao? 1 - Sim | 2 - Nao: ", 1, 2);

        if (confirma == 1) {
            chamados.remove(chamado);
            System.out.println("Chamado excluido.");
        } else {
            System.out.println("Exclusao cancelada.");
        }
    }
}
