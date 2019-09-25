package edu.tartaruga.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.tartaruga.entidade.Entrega;

public class EntregaDAOImpl implements EntregaDAO {
	@Override
	public void adicionar(Entrega e) throws DAOException {
		Connection con = DBUtil.getInstance().getConnection();
		try {
			String sql = 
					"INSERT INTO entrega (id, origem, destino, dimensoes, "
					+ "peso, data, frete, status) "
					+ "VALUES (0, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, e.getOrigem());
			stmt.setString(2, e.getDestino());
			stmt.setString(3, e.getDimensoes());
			stmt.setFloat(4, e.getPeso());
			stmt.setDate(5, new java.sql.Date(e.getData().getTime()));
			stmt.setFloat(6, e.getFrete());
			stmt.setString(7, e.getStatus());
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e1) {
			throw new DAOException(e1);
		}	
	}

	@Override
	public List<Entrega> pesquisar(String origem) throws DAOException {
		Connection con = DBUtil.getInstance().getConnection();
		List<Entrega> entregas = new ArrayList<>();
		try {
			String sql = 
					"SELECT * FROM entrega WHERE origem LIKE ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + origem + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) { 
				Entrega e = new Entrega();
				e.setId(rs.getLong("id"));
				e.setOrigem(rs.getString("origem"));
				e.setDestino(rs.getString("destino"));
				e.setData(rs.getDate("data"));
				e.setDimensoes(rs.getString("dimensoes"));
				e.setFrete(rs.getFloat("frete"));
				e.setPeso(rs.getFloat("peso"));
				e.setStatus(rs.getString("status"));
				entregas.add(e);
			}
			con.close();
		} catch (SQLException e1) {
			throw new DAOException(e1);
		}	
		return entregas;
	}
}
