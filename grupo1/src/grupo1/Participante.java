package grupo1;

import java.util.ArrayList;

public class Participante {

	private int numero;
	private String nome;
	private String email;
	private ArrayList<Inscricao> inscricoes;
	
	public Participante(int numero, String nome, String email) {
		
		this.numero=numero;
		this.nome=nome;
		this.email=email;
		this.inscricoes=new ArrayList<Inscricao>();
		
	}
	
	public int getNumero() {
		return numero;
		
	}
	
	public String getNome() {
		return nome;

	}
	
	public String getEmail() {
		return email;
		
	}
	
	public ArrayList<Inscricao> getInscricoes() {
		return inscricoes;
	
	}
	
	public void setNumero(int numero) {
		this.numero=numero;
		
	}
	
	public void setNome(String nome) {
		this.nome=nome;
		
	}
	
	public void setEmail(String email) {
		this.email=email;
		
	}
	
	public void adicionarInscricao(Inscricao inscricao) {
		inscricoes.add(inscricao);
		
	}
	
	public void removerInscricao(Inscricao inscricao) {
		inscricoes.remove(inscricao);
		
	}
	
	public String mostrarParticipante() {
		return "Participante[" + numero + "-" + nome + "-" + email + "]";
		
	}
	
}