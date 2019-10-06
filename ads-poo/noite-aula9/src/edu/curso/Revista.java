package edu.curso;

import java.util.ArrayList;
import java.util.List;
public class Revista implements Publicador {
	private String nome;
	public Revista(String n) { 
		nome = n;
	}
	List<Assinante> lista = new ArrayList<>();
	@Override
	public void adicionar(Assinante a) {
		lista.add(a);
	}
	@Override
	public void remover(Assinante a) {
		lista.remove(a);
	}
	@Override
	public void notificar(String materia) {
		for (Assinante a : lista) { 
			a.receberMateria(
				String.format("Revista %s divulga %s", nome, materia));
		}
	}
}
