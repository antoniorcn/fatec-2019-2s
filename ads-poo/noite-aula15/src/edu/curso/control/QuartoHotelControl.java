package edu.curso.control;

import java.util.ArrayList;
import java.util.List;

import edu.curso.dao.QuartoHotelDAO;
import edu.curso.dao.QuartoHotelDAOImpl;
import edu.curso.entidades.QuartoHotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QuartoHotelControl {
	private ObservableList<QuartoHotel> lista = 
					FXCollections.observableArrayList();
	private QuartoHotelDAO qDao = new QuartoHotelDAOImpl();
	
	
	public void adicionar(QuartoHotel q) { 
		lista.add(q);
		qDao.adicionar(q);
	}
	
	public void pesquisarPorNumeroQuarto(String numeroQuarto) { 
		List<QuartoHotel> resultado = 
				qDao.pesquisarPorNumeroQuarto(numeroQuarto);
		lista.clear();
		lista.addAll(resultado);
	}
	
	public ObservableList<QuartoHotel> getLista() { 
		return lista;
	}
}
