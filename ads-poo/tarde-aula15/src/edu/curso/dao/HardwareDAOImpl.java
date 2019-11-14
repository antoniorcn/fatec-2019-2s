package edu.curso.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.curso.entidades.Hardware;

public class HardwareDAOImpl implements HardwareDAO {
	private static final String URL = "jdbc:mariadb://localhost:3306/hardwares?allowMultiQueries=true";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	
	@Override
	public void adicionar(Hardware h) throws DAOException { 
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
			throw new DAOException(e);
		}
	}
	
	@Override
	public List<Hardware> pesquisarPorTipo(String tipo) throws DAOException { 
		List<Hardware> lista = new ArrayList<>();
		try {
			Connection con = 
				DriverManager.getConnection(URL, USUARIO, SENHA);	
			String sql = "SELECT * FROM hardware "
					+ "WHERE tipo LIKE ?";		
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + tipo + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) { 
				Hardware h = new Hardware();
				h.setId( rs.getLong("id") );
				h.setTipo( rs.getString("tipo"));
				// tipo, fabricante, descricao, preco, data_compra
				h.setFabricante(rs.getString("fabricante"));
				h.setDescricao(rs.getString("descricao"));
				h.setPreco(rs.getDouble("preco"));
				h.setDataCompra(rs.getDate("data_compra"));
				lista.add(h);
			}
		} catch(SQLException e) { 
			e.printStackTrace();
			throw new DAOException(e);
		}
		return lista;
	}
}
