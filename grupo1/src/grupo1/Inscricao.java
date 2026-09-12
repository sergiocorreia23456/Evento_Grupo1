package grupo1;

public class Inscricao {

    public enum Estado {
        PENDENTE, CONFIRMADA, CANCELADA
    }

    private Participante participante;
    private Evento evento;
    private Estado estado;

    public Inscricao(Participante participante, Evento evento) {
        this.participante = participante;
        this.evento = evento;
        this.estado = Estado.PENDENTE;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Evento getEvento() {
        return evento;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String toString() {
        return participante.getNome() + " -> " + evento.getTitulo() + " | " + estado + " |";
    }
}