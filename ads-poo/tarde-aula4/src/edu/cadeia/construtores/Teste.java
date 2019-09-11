package edu.cadeia.construtores;

public class Teste {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa();
		p1.dormir();
		
		Aluno a1 = new Aluno();
		a1.dormir();
		
		Pessoa p2 = new Aluno();
		p2.dormir();
		
		AlunoFatec a2 = new AlunoFatec();
		a2.dormir();

	}

}
