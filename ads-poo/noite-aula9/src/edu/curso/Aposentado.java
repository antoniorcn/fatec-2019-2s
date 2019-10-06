package edu.curso;

public class Aposentado implements Assinante {
	private String nome;
	public Aposentado(String n) { 
		nome = n; 
	}
	
	@Override
	public void receberMateria(String materia) {
		System.out.println(
			String.format(
			"Aposentado %s está sentado na poltrona lendo a materia %s",
			nome, materia));
	}
}
