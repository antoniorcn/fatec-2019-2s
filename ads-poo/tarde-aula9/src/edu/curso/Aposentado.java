package edu.curso;

public class Aposentado implements Assinante {
	private String nome;
	public Aposentado(String n) { 
		nome = n;
	}
	
	@Override
	public void receberMateria(String materia) {
		System.out.println(	String.format(
				"%s lendo a materia: (%s) no parque com tranquilidade", 
			nome, materia));
	}


}
