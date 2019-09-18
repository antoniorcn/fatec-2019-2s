package edu.tartaruga.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.tartaruga.entidade.Entrega;

public class DAOExceptionImpl implements EntregaDAO {
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
}
