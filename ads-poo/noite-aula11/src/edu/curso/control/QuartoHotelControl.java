package edu.curso.control;

import java.util.ArrayList;
import java.util.List;

import edu.curso.entidades.QuartoHotel;

public class QuartoHotelControl {
	private List<QuartoHotel> lista = new ArrayList<>();
	
	
	public void adicionar(QuartoHotel q) { 
		lista.add(q);
	}
	
	public QuartoHotel pesquisarPorNumeroQuarto(String numeroQuarto) { 
		for (QuartoHotel q : lista) { 
			if (q.getNumeroQuarto().contains(numeroQuarto)) { 
				return q;
			}
		}
		return null;
	}
}
