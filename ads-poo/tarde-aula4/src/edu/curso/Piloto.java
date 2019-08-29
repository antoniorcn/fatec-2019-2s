package edu.curso;

public class Piloto extends Pessoa {
	int breve;
	String categoria;
	int horasVoo;
	
	public Piloto() { 
		super("Roger");
	}
	
	public void voar() { 
		horasVoo += 8;
		System.out.println("Piloto voando..");
	}

}
