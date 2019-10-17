package edu.curso.control;

import java.util.ArrayList;
import java.util.List;

import edu.curso.entidades.Hardware;

public class HardwareControl {
	private List<Hardware> lista = new ArrayList<>();
	
	public void adicionar(Hardware h) { 
		lista.add(h);
	}
	
	public Hardware pesquisarPorTipo(String tipo) { 
		for (Hardware h : lista) { 
			if (h.getTipo().contains(tipo)) { 
				return h;
			}
		}
		return null;
	}
}
