package edu.curso;

public class Passageiro extends Pessoa {
	int bilhete;
	String preferenciaClasse;
	String preferenciaAssento;
	public Passageiro(String n, int b) { 
		this.nome = n;
		this.bilhete = b;
		System.out.println("Passageiro " +
		nome + " e " + bilhete + " criado com sucesso");
	}
	public void embarcar() { 
		System.out.println("Passageiro " + nome + " embarcado "
				+ "com o bilhete " + bilhete);
	}
}
