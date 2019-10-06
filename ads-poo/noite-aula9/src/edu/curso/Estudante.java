package edu.curso;

public class Estudante implements Assinante {
	private String nome;
	public Estudante(String n) { 
		nome = n; 
	}
	
	@Override
	public void receberMateria(String materia) {
		System.out.println(
			String.format("Estudante %s está lendo a materia %s",
					nome, materia));
	}
}
