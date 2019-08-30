package edu.curso;

public class Aluno {
	String nome;
	String ra;
	public Aluno(String ra, String nome) {
		this.ra = ra;
		this.nome = nome;
		System.out.println("Aluno criado com sucesso");
	}
	
	public Aluno(String nome) {  
		this("00000", nome);
	}
	
	public Aluno() { 
		this("00000", "NOME NÃO DEFINIDO");
	}
}
