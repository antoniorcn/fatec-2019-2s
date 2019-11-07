package edu.curso.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import edu.curso.entidades.Hardware;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HardwareControl {
	private ObservableList<Hardware> lista = 
			FXCollections.observableArrayList();
	private static final String URL = "jdbc:mariadb://localhost:3306/hardwares?allowMultiQueries=true";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	public void adicionar(Hardware h) { 
		getLista().add(h);
		try {
			Connection con = 
				DriverManager.getConnection(URL, USUARIO, SENHA);				
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO hardware "
					+ "(tipo, fabricante, descricao, preco) VALUES "
					+ "('" + h.getTipo() + 
					"', '" + h.getFabricante() + 
					"', '" + h.getDescricao() + 
					"', " + h.getPreco() + ")";
			stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Hardware pesquisarPorTipo(String tipo) { 
		for (Hardware h : getLista()) { 
			if (h.getTipo().contains(tipo)) { 
				return h;
			}
		}
		return null;
	}

	public ObservableList<Hardware> getLista() {
		return lista;
	}
}
