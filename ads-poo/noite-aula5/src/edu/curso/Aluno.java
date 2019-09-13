package edu.curso;

public class Aluno extends Pessoa {
	
	private String ra;
	
	public Aluno() {
		this("Gabriel", "00000");
	}
	
	public Aluno(String nome, String ra) { 
		this.nome = nome;
		this.ra = ra;
		System.out.println("Criando aluno");
	}
	
	@Override
	public void caminhar() { 
		System.out.println("Aluno caminhando e estudando");
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}
}
