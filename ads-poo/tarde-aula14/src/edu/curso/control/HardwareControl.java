package edu.curso.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			String sql = "INSERT INTO hardware "
					+ "(tipo, fabricante, descricao, preco, data_compra) "
					+ "VALUES (?, ?, ?, ?, ?)";		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, h.getTipo());
			ps.setString(2, h.getFabricante());
			ps.setString(3, h.getDescricao());
			ps.setDouble(4, h.getPreco());
			long t = h.getDataCompra().getTime();
			java.sql.Date d = new java.sql.Date(t);
			ps.setDate(5, d);
			ps.executeUpdate();
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
