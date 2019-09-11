package edu.cadeia.construtores;

public class Aluno extends Pessoa {
	public Aluno() {
		super();
		System.out.println("Construindo Aluno");
	}
	
	public void dormir() { 
		System.out.println("Aluno dorme 4 horas por dia ... "
				+ "Ihhh tenho que ir para a Facu");
	}
}
