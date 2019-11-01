package edu.curso.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDB {
	private static final String URL = "jdbc:mariadb://localhost:3306/hoteldb";
	private static final String USER = "root";
	private static final String PASS = "";
	public static void main(String[] args) {
		try {
			Connection con = 
					DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Conectado....");
			Statement stm = con.createStatement();
			
			String sql = "INSERT INTO quartohotel "
					+ "(numero_quarto, numero_camas, valor_reserva, descricao)"
					+ " VALUES ('666', 3, 96.0, 'Suite de Matar')";
			
			stm.executeUpdate(sql);
			System.out.println("Registro inserido....");
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
