package edu.curso.control;

import edu.curso.entidades.QuartoHotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QuartoHotelControl {
	private ObservableList<QuartoHotel> lista = 
					FXCollections.observableArrayList();
	
	
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
	
	public ObservableList<QuartoHotel> getLista() { 
		return lista;
	}
}
