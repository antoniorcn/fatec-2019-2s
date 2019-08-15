package edu.curso;

public class EstouraHeap {
	static class Pessoa { 
		String nome;
		Pessoa next;
		int [] n = new int[10000];
	}
	public static void main(String[] args) {
		Pessoa primeira = new Pessoa();
		Pessoa temp = primeira;
		int count = 0;
		while (true) { 
			Pessoa p = new Pessoa();
			temp.next = p;
			temp = p;
			System.out.println(count++);
		}
	}

}
