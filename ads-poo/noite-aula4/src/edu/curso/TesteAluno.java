package edu.curso;

public class TesteAluno {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("1234", "João Silva");
		Aluno a2 = new Aluno("3444", "Maria Silva");
		Aluno a3 = new Aluno();
		
		System.out.println("Aluno 1: " + a1.nome.toUpperCase());
		System.out.println("Aluno 2: " + a2.nome.toUpperCase());
		System.out.println("Aluno 3: " + a3.nome.toUpperCase());
	}

}
