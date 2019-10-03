package edu.curso;

import java.util.ArrayList;
import java.util.List;
public class Revista implements Publicadora {
	private String nome;
	public Revista(String nome) {
		this.nome = nome;
	}
	List<Assinante> lista = new ArrayList<>();
	@Override
	public void add(Assinante a) {
		lista.add(a);
	}
	@Override
	public void remove(Assinante a) {
		lista.remove(a);
	}
	@Override
	public void notify(String materia) {
		for (Assinante a : lista) { 
			a.receberMateria(
				String.format(
						"A revista %s informa %s", nome, materia));
		}
	}
}
