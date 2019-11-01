package edu.curso.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import edu.curso.entidades.QuartoHotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class QuartoHotelControl {
	private static final String URL = "jdbc:mariadb://localhost:3306/hoteldb?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "";
	
	private ObservableList<QuartoHotel> lista = 
					FXCollections.observableArrayList();
	
	
	public void adicionar(QuartoHotel q) { 
		lista.add(q);
		try {
			Connection con = 
					DriverManager.getConnection(URL, USER, PASS);
			Statement stm = con.createStatement();
			String sql = "INSERT INTO quartohotel "
					+ "(numero_quarto, numero_camas, valor_reserva, descricao)"
					+ " VALUES ('" + q.getNumeroQuarto() 
					+ "', " + q.getNumeroCamas() 
					+ ", "+ q.getValorDiaria() 
					+", '" + q.getObservacao() + "')";
			stm.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
