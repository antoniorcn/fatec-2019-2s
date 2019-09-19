package edu.curso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

class Carro implements Comparable<Carro>{ 
	String nome;
	float potencia;
	
	Carro(String n, float p) { 
		nome = n;
		potencia = p;
	}

	@Override
	public int compareTo(Carro o) {
		return - this.nome.compareTo(o.nome);
	}
}

// Single Responsibility Unit SRU

public class Lista1 {
	public Lista1() { 
	}
	
	public void adicionarElementos(Collection<Carro> lista) { 
		lista.add(new Carro("Fusca", 1.3f));
		lista.add(new Carro("Monza", 2.0f));
		lista.add(new Carro("Velox", 2.4f));
		lista.add(new Carro("C5", 2.6f));
		lista.add(new Carro("Porche", 4.5f));
		lista.add(new Carro("Brasilia", 1.5f));
		lista.add(new Carro("Sentra", 1.4f));
		lista.add(new Carro("Polo", 2.1f));
	}
	
	public void ordenar(List<Carro> lista) { 
		Collections.sort(lista);
	}
	
	public void imprimir(List<Carro> lista) { 
		for (Carro carro : lista) { 
			System.out.println(carro.nome);
		}
	}
	
	// Interface Implementation
	public static void main(String[] args) {	
		Lista1 l1 = new Lista1();
		List<Carro> lista = new Vector<>();
		
		l1.adicionarElementos(lista);
		l1.ordenar(lista);
		l1.imprimir(lista);
	}
}
