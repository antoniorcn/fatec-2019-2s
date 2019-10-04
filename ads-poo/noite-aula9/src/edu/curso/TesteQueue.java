package edu.curso;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TesteQueue {
	
	static class Pessoa implements Comparable<Pessoa> { 
		int idade;
		String nome;
		boolean genero;
		boolean gestante;
		boolean crianca;
		boolean pcd;
		int beleza;
		
		public Pessoa(String n, boolean g, int b) { 
			nome = n;
			genero = g;
			beleza = b;
		}

		@Override
		public int compareTo(Pessoa p) {
			if (beleza > p.beleza) { 
				return -1;
			} else { 
				return 1;
			}
		}		
	}
	
	public static void main(String[] args) {
		Queue<Pessoa> filaLoterica = new PriorityQueue<>();
		Pessoa p1 = new Pessoa("John", true, 3);
		Pessoa p2 = new Pessoa("Maria", false, 4);
		Pessoa p3 = new Pessoa("Filipe", true, 2);
		Pessoa p4 = new Pessoa("Geralda", false, 5);
		
		filaLoterica.add(p1);
		filaLoterica.add(p2);
		filaLoterica.add(p3);
		filaLoterica.add(p4);
		
		System.out.println(
			String.format("A fila tem %d pessoas", filaLoterica.size()));
		Pessoa p = filaLoterica.poll();
		System.out.println(p.nome);
		p = filaLoterica.poll();
		System.out.println(p.nome);
		System.out.println(
				String.format("A fila tem %d pessoas", filaLoterica.size()));
	}

}
