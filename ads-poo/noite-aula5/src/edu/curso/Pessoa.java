package edu.curso;

public class Pessoa extends Animal {
	
	public String nome;
	public int idade;
	
	public Pessoa() { 
		this("José", 30);
	}
	
	public Pessoa(String nome, int idade) { 
		super("Homosapiens");
		this.nome = nome;
		this.idade = idade;
		System.out.println("Criando um pessoa");
	}
	
	public void caminhar() { 
		System.out.println("Pessoa Caminhando");
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
}
