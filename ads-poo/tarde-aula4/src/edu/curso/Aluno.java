package edu.curso;

public class Aluno {
	private String ra;
	private String nome;
	private String curso;
	private int idade;
	
	public Aluno() { 
	}
	
	public Aluno(String nome, String ra) {
		this.nome = nome;
		this.ra = ra;
	}

	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		if (idade > 1) { 
			this.idade = idade;
		}
	}
	
	public boolean equals(Aluno a) { 
		if (a != null && getRa().equals(a.getRa())) { 
			return true;
		} else { 
			return false;
		}
	}
	
	public String toString() { 
		return getRa() + " - " + getNome();
	}
}
