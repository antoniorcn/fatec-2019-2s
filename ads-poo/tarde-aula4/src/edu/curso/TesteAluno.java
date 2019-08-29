package edu.curso;

public class TesteAluno {
	
	public static void main(String[] args) {
		Aluno a1 = new Aluno("João Alberto", "1234");
		Aluno a2 = new Aluno("João Silva", "1234");
		System.out.println("Aluno 1: " + a1);
		System.out.println("Aluno 2: " + a2);
		if (a1.equals(a2)) { 
			System.out.println("Sao iguais");
		} else { 
			System.out.println("Sao diferentes");
		}
	}
}
