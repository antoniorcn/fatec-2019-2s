package edu.toyrus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.toyrus.entidade.Brinquedo;

public class BrinquedoDAOImpl implements BrinquedoDAO {

	@Override
	public void adicionar(Brinquedo b) throws DAOException {
		Connection con = DBUtil.getInstance().getConnection();
		
		try {
			String sql = "INSERT INTO brinquedo (id, nome, categoria, fabricante, idade_minima, lote, data_compra) " +
			"VALUES (0, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, b.getNome());
			stmt.setString(2, b.getCategoria());
			stmt.setString(3, b.getFabricante());
			stmt.setInt(4, b.getIdadeMinima());
			stmt.setInt(5, b.getLote());
			stmt.setDate(6, new java.sql.Date(b.getDataCompra().getTime()));
			
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

}
