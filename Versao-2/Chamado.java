public class Chamado {
    private int id;
    private String solicitante;
    private String email;
    private String setor;
    private String titulo;
    private String descricao;
    private String prioridade;
    private String status;

    public Chamado(int id, String solicitante, String email, String setor,
                   String titulo, String descricao, String prioridade, String status) {
        this.id = id;
        this.solicitante = solicitante;
        this.email = email;
        this.setor = setor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    // usado na alteracao: troca todos os dados menos o numero do chamado
    public void atualizar(String solicitante, String email, String setor,
                          String titulo, String descricao, String prioridade, String status) {
        this.solicitante = solicitante;
        this.email = email;
        this.setor = setor;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Numero: " + id
                + "\nSolicitante: " + solicitante
                + "\nE-mail: " + email
                + "\nSetor: " + setor
                + "\nTitulo: " + titulo
                + "\nDescricao: " + descricao
                + "\nPrioridade: " + prioridade
                + "\nStatus: " + status;
    }
}
