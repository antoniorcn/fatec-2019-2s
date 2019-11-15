package edu.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.curso.entidades.QuartoHotel;

public class QuartoHotelDAOImpl implements QuartoHotelDAO {
	private static final String URL = "jdbc:mariadb://localhost:3306/hoteldb?allowMultiQueries=true";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public void adicionar(QuartoHotel q) { 
		try {
			Connection con = 
					DriverManager.getConnection(URL, USER, PASS);
			String sql = "INSERT INTO quartohotel "
					+ "(numero_quarto, numero_camas, valor_reserva, "
					+ "descricao, data_reserva)"
					+ " VALUES (?, ?, ?, ?, ?)";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, q.getNumeroQuarto());
			stm.setInt(2, q.getNumeroCamas());
			stm.setDouble(3, q.getValorDiaria());
			stm.setString(4, q.getObservacao());
			long epochTime = q.getDataReserva().getTime();
			java.sql.Date d = new java.sql.Date(epochTime);
			stm.setDate(5,  d);
			stm.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<QuartoHotel> pesquisarPorNumeroQuarto(String numeroQuarto) { 
		List<QuartoHotel> lista = new ArrayList<>();
		try {
			Connection con = 
					DriverManager.getConnection(URL, USER, PASS);
			String sql = "SELECT * FROM quartohotel "
					+ " WHERE numero_quarto LIKE ?";
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, "%" + numeroQuarto + "%");
			ResultSet rs = stm.executeQuery();			
			while (rs.next()) { 
				QuartoHotel q = new QuartoHotel();
				q.setNumeroQuarto( rs.getString("numero_quarto") );
				q.setNumeroCamas(rs.getInt("numero_camas"));
				q.setId(rs.getLong("id"));
				q.setObservacao(rs.getString("descricao"));
				q.setValorDiaria(rs.getDouble("valor_reserva"));
				q.setDataReserva(
						new java.util.Date(
								rs.getDate("data_reserva").getTime())
						);
				lista.add(q);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return lista;
	}
}
