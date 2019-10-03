package edu.curso;

public class TesteObserver {
	
	public static void main(String[] args) {
		Revista veja = new Revista("Veja");
		Revista exame = new Revista("Exame");
		
		Aluno a1 = new Aluno("Robson");
		Aluno a2 = new Aluno("Crusoé");
		Aluno a3 = new Aluno("Amélia");
		
		Aposentado ap1 = new Aposentado("José");
		Aposentado ap2 = new Aposentado("Cida");
		
		veja.add(a3);
		veja.add(ap2);
		
		exame.add(a2);
		exame.add(a1);
		exame.add(ap1);
		
		veja.notify("Entenda o caso Neymar e Nadjla");
		exame.notify("Corrida pelos sem banco");
	}

}
