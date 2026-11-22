import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in, "UTF-8");
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
            opcao = lerNumero("Escolha uma opcao: ");

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
                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);
    }

    static int lerNumero(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String entrada = scanner.nextLine().trim();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Digite um numero valido.");
            }
        }
    }

    static String lerTexto(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = scanner.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Esse campo nao pode ficar vazio.");
        }
    }

    static String lerEmail() {
        while (true) {
            String email = lerTexto("E-mail: ");
            if (email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) {
                return email;
            }
            System.out.println("E-mail invalido.");
        }
    }

    static String lerPrioridade() {
        while (true) {
            System.out.println("Prioridade: 1 - Baixa | 2 - Media | 3 - Alta");
            int valor = lerNumero("Escolha: ");
            if (valor == 1) return "Baixa";
            if (valor == 2) return "Media";
            if (valor == 3) return "Alta";
            System.out.println("Prioridade invalida.");
        }
    }

    static String lerStatus() {
        while (true) {
            System.out.println("Status: 1 - Aberto | 2 - Em andamento | 3 - Resolvido");
            int valor = lerNumero("Escolha: ");
            if (valor == 1) return "Aberto";
            if (valor == 2) return "Em andamento";
            if (valor == 3) return "Resolvido";
            System.out.println("Status invalido.");
        }
    }

    static Chamado buscar(int id) {
        for (Chamado chamado : chamados) {
            if (chamado.getId() == id) {
                return chamado;
            }
        }
        return null;
    }

    static void cadastrar() {
        System.out.println("\n=== CADASTRAR CHAMADO ===");
        String solicitante = lerTexto("Solicitante: ");
        String email = lerEmail();
        String setor = lerTexto("Setor: ");
        String titulo = lerTexto("Titulo: ");
        String descricao = lerTexto("Descricao: ");
        String prioridade = lerPrioridade();
        Chamado chamado = new Chamado(proximoId++, solicitante, email, setor, titulo, descricao, prioridade, "Aberto");
        chamados.add(chamado);
        System.out.println("Chamado cadastrado com numero " + chamado.getId() + ".");
    }

    static void listar() {
        if (chamados.isEmpty()) {
            System.out.println("Nenhum chamado cadastrado.");
            return;
        }
        for (Chamado chamado : chamados) {
            System.out.println("\n--------------------");
            System.out.println(chamado);
        }
    }

    static void consultar() {
        int id = lerNumero("Numero do chamado: ");
        Chamado chamado = buscar(id);
        if (chamado == null) {
            System.out.println("Chamado nao encontrado.");
        } else {
            System.out.println("\n" + chamado);
        }
    }

    static void alterar() {
        int id = lerNumero("Numero do chamado que deseja alterar: ");
        Chamado chamado = buscar(id);
        if (chamado == null) {
            System.out.println("Chamado nao encontrado.");
            return;
        }
        System.out.println("\nDigite os novos dados:");
        String solicitante = lerTexto("Solicitante: ");
        String email = lerEmail();
        String setor = lerTexto("Setor: ");
        String titulo = lerTexto("Titulo: ");
        String descricao = lerTexto("Descricao: ");
        String prioridade = lerPrioridade();
        String status = lerStatus();
        chamado.atualizar(solicitante, email, setor, titulo, descricao, prioridade, status);
        System.out.println("Chamado alterado com sucesso.");
    }

    static void excluir() {
        int id = lerNumero("Numero do chamado que deseja excluir: ");
        Chamado chamado = buscar(id);
        if (chamado == null) {
            System.out.println("Chamado nao encontrado.");
            return;
        }
        System.out.print("Confirma a exclusao? (S/N): ");
        String resposta = scanner.nextLine().trim();
        if (resposta.equalsIgnoreCase("S")) {
            chamados.remove(chamado);
            System.out.println("Chamado excluido com sucesso.");
        } else {
            System.out.println("Exclusao cancelada.");
        }
    }
}
