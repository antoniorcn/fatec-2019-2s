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
			String sql = "INSERT INTO brinquedo (id, nome, categoria) " +
			"VALUES (0, ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, b.getNome());
			stmt.setString(2, b.getCategoria());
			con.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

}
