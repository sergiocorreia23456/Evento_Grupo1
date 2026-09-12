package grupo1;

public class GereEvento {

}
package Gestao_de_eventos;

import java.util.ArrayList;
import java.util.List;

public class GereEventos {
    private List<Evento> eventos;
    private List<Participante> participantes;
    private List<Inscricao> inscricoes;

    public GereEventos() {
        this.eventos = new ArrayList<>();
        this.participantes = new ArrayList<>();
        this.inscricoes = new ArrayList<>();
    }

    public void registarEvento(Evento e) {
        eventos.add(e);
        System.out.println("Evento " + e.getTitulo() + " registado com sucesso!");
    }

    public void registarParticipante(Participante p) {
        participantes.add(p);
        System.out.println("Participante " + p.getNome() + " registado com sucesso!");
    }

    public boolean registarInscricao(Participante p, Evento e) {
        // Verificar se já existe inscrição ativa deste participante neste evento
        for (Inscricao i : inscricoes) {
            if (i.getParticipante().getEmail().equals(p.getEmail()) &&
                i.getEvento().getTitulo().equals(e.getTitulo()) &&
                i.getEstado() != Inscricao.EstadoInscricao.CANCELADA) {
                System.out.println("Erro: O participante já está inscrito neste evento!");
                return false;
            }
        }
        if (obterVagasDisponiveis(e) <= 0) {
            System.out.println("Erro: o evento já atingiu a lotação máxima!");
            return false;
        }

        Inscricao novaInscricao = new Inscricao(p, e);
        novaInscricao.setEstado(Inscricao.EstadoInscricao.PENDENTE);
        inscricoes.add(novaInscricao);
        System.out.println("Inscrição efetuada com sucesso! Estado: PENDENTE.");
        return true;
    }

    public boolean confirmarInscricao(Participante p, Evento e) {
        for (Inscricao i : inscricoes) {
            if (i.getParticipante().getEmail().equalsIgnoreCase(p.getEmail()) &&
                i.getEvento().getTitulo().equalsIgnoreCase(e.getTitulo()) &&
                i.getEstado() != Inscricao.EstadoInscricao.CANCELADA) {
                if (i.getEstado() == Inscricao.EstadoInscricao.CONFIRMADA) {
                    System.out.println("Esta inscrição já estava confirmada.");
                    return true;
                }
                if (obterVagasDisponiveis(e) <= 0) {
                    System.out.println("Erro: não há vagas disponíveis para confirmar esta inscrição!");
                    return false;
                }
                i.setEstado(Inscricao.EstadoInscricao.CONFIRMADA);
                System.out.println("Inscrição confirmada com sucesso!");
                return true;
            }
        }
        System.out.println("A inscrição não foi encontrada!");
        return false;
    }

    public boolean cancelarInscricao(Participante p, Evento e) {
        for (Inscricao i : inscricoes) {
            if (i.getParticipante().getEmail().equalsIgnoreCase(p.getEmail()) &&
                i.getEvento().getTitulo().equalsIgnoreCase(e.getTitulo()) &&
                i.getEstado() != Inscricao.EstadoInscricao.CANCELADA) {

                i.setEstado(Inscricao.EstadoInscricao.CANCELADA);
                System.out.println("Inscrição cancelada com sucesso!");
                return true;
            }
        }
        System.out.println("Inscrição não foi encontrada!");
        return false;
    }

    public void listarParticipantesConfirmados(Evento e) {
        System.out.println("\n--- Participantes Confirmados no Evento: " + e.getTitulo() + " ---");
        boolean encontrou = false;
        for (Inscricao i : inscricoes) {
            if (i.getEvento().getTitulo().equals(e.getTitulo()) && i.getEstado() == Inscricao.EstadoInscricao.CONFIRMADA) {
                System.out.println("- " + i.getParticipante().getNome() + " (" + i.getParticipante().getEmail() + ")");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum participante foi confirmado até ao momento!");
        }
    }

    public int obterVagasDisponiveis(Evento e) {
        int confirmados = 0;
        for (Inscricao i : inscricoes) {
            if (i.getEvento().getTitulo().equals(e.getTitulo()) && i.getEstado() == Inscricao.EstadoInscricao.CONFIRMADA) {
                confirmados++;
            }
        }
        return e.getLotacaoMaxima() - confirmados;
    }

    public Evento obterEventoComMaisInscricoesConfirmadas() {
        if (eventos.isEmpty())
            return null;
        Evento maior = null;
        int maxInscricoes = -1;
        for (Evento e : eventos) {
            int count = 0;
            for (Inscricao i : inscricoes) {
                if (i.getEvento().getTitulo().equals(e.getTitulo()) && i.getEstado() == Inscricao.EstadoInscricao.CONFIRMADA) {
                    count++;
                }
            }
            if (count > maxInscricoes) {
                maxInscricoes = count;
                maior = e;
            }
        }
        return maior;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public List<Inscricao> getInscricoes() {
        return inscricoes;
    }
}
esta e com tudo certo