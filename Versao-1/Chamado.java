public class Chamado {
    private final int id;
    private String solicitante;
    private String email;
    private String setor;
    private String titulo;
    private String descricao;
    private String prioridade;
    private String status;

    public Chamado(int id, String solicitante, String email, String setor, String titulo, String descricao, String prioridade, String status) {
        this.id = id;
        atualizar(solicitante, email, setor, titulo, descricao, prioridade, status);
    }

    public int getId() {
        return id;
    }

    public void atualizar(String solicitante, String email, String setor, String titulo, String descricao, String prioridade, String status) {
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
        return "Numero: " + id + "\nSolicitante: " + solicitante + "\nE-mail: " + email + "\nSetor: " + setor + "\nTitulo: " + titulo + "\nDescricao: " + descricao + "\nPrioridade: " + prioridade + "\nStatus: " + status;
    }
}
