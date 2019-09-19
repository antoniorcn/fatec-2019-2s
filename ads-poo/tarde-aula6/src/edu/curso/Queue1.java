package edu.curso;

import java.util.PriorityQueue;
import java.util.Queue;

enum Doenca { 
	DOR_DEDO, GRIPE, SARAMPO, CAXUMBA, 
	DENGUE, ARRITMIA_CARDIACA, INFARTO, AVC, 
	PARADA_RESPIRATORIA, PARADA_CARDIACA;
}

class Paciente implements Comparable<Paciente>{ 
	String nome;
	Doenca doenca;
	
	public Paciente(String n, Doenca d) { 
		nome = n;
		doenca = d;
	}

	@Override
	public int compareTo(Paciente o) {
		return o.doenca.ordinal() - this.doenca.ordinal();
	}
	
	@Override
	public String toString() { 
		return nome + " (" + doenca.name() + ")";
	}
}

public class Queue1 {

	public static void main(String[] args) {
		Queue<Paciente> q = new PriorityQueue<>();
		Paciente p1 = new Paciente("Steven", Doenca.GRIPE);
		Paciente p2 = new Paciente("Ralf", Doenca.DOR_DEDO);
		Paciente p3 = new Paciente("Roberval", Doenca.ARRITMIA_CARDIACA);
		Paciente p4 = new Paciente("Hashignton", Doenca.AVC);
		Paciente p5 = new Paciente("Gleidneuser", Doenca.PARADA_CARDIACA);
		q.add(p1);
		q.add(p2);
		q.add(p3);
		q.add(p4);
		q.add(p5);
		System.out.println("\nPacientes que chegaram no P.S.");
		for(Paciente p : q) { 
			System.out.println(p);
		}
		
		System.out.println("\nChamando o 1º paciente:");
		System.out.println(q.poll());
		
		System.out.println("\nChamando o 2º paciente:");
		System.out.println(q.poll());
		
		System.out.println("\nChamando o 3º paciente:");
		System.out.println(q.poll());
		
		System.out.println("\nPacientes que estão no P.S.");
		for(Paciente p : q) { 
			System.out.println(p);
		}

	}

}
