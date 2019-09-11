package edu.cadeia.construtores;

public class Pessoa extends Animal {
	private String nome;
	public Pessoa() { 
		this("João");
	}
	public Pessoa(String n) {
		super();
		this.nome = n;
	}
	
	public void dormir() { 
		System.out.println("Pessoa dorme 9 horas por dia ....");
	}
}
