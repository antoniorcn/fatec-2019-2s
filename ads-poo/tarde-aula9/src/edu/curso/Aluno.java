package edu.curso;

public class Aluno implements Assinante {
	private String nome;
	public Aluno(String n) { 
		nome = n;
	}

	@Override
	public void receberMateria(String materia) {
		System.out.println(	String.format(
				"%s lendo a materia: %s rapidamente", 
			nome, materia));
	}

}
