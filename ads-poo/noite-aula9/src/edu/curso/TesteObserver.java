package edu.curso;

public class TesteObserver {
	public static void main(String[] args) {
		
		Revista quatroRodas = new Revista("4Rodas");
		Revista pc = new Revista("PC e Cia");
		
		Estudante a1 = new Estudante("Alex");
		Estudante a2 = new Estudante("Pamela");
		
		Aposentado ap1 = new Aposentado("Estevam");
		Aposentado ap2 = new Aposentado("Ana");
		
		quatroRodas.adicionar(ap1);
		quatroRodas.adicionar(a1);
		
		pc.adicionar(a1);
		pc.adicionar(ap2);
		pc.adicionar(a2);
		
		quatroRodas.notificar("Um novo carro com 4 rodas");
		pc.notificar("Processador quantico, portátil");
		
	}

}
