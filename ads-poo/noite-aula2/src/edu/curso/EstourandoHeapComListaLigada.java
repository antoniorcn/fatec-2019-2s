package edu.curso;

public class EstourandoHeapComListaLigada {

	static class No { 
		int[] i = new int[20000];
		No proximo;
	}
	
	public static void main(String[] args) {
		No primeiro = new No();
		No ultimo = primeiro;
		int count = 0;
		while(true) {
			No outro = new No();
			System.out.println("No: " + count++);
			ultimo.proximo = outro;
			ultimo = outro;
		}
	}

}
