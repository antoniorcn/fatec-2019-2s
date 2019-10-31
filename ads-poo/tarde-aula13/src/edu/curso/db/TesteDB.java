package edu.curso.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class TesteDB {
	private static final String URL = "jdbc:mariadb://localhost:3306/hardwares";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	public static void main(String[] args) {
		try {
			Connection con = 
				DriverManager.getConnection(URL, USUARIO, SENHA);
				System.out.println("Conectado");
				
			Statement stmt = con.createStatement();
			String sql = "INSERT INTO hardware "
					+ "(tipo, fabricante, descricao, preco) VALUES "
					+ "('Notebook Dell', 'Dell', 'Notebook core i5', 800.0)";
			stmt.executeUpdate(sql);
			System.out.println("Comando executado");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
}
