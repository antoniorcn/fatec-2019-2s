package edu.curso;

public class Pessoa {
	String nome;
	String cpf;
	String nascimento;
	
	public Pessoa() { 
		
	}
	
	public Pessoa(String nome) { 
		this.nome = nome;
		System.out.println("Pessoa " + nome + " criada com sucesso");
	}
	
	public void identificarSe() { 
		System.out.println("Me chamo " + nome);
	}
}
