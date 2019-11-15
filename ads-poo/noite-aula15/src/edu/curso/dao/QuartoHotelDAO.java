package edu.curso.dao;

import java.util.List;
import edu.curso.entidades.QuartoHotel;

public interface QuartoHotelDAO {
	void adicionar(QuartoHotel q);
	List<QuartoHotel> pesquisarPorNumeroQuarto(String tipo);
}
