package edu.toyrus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	public List<Brinquedo> pesquisar(String nome) throws DAOException {
		Connection con = DBUtil.getInstance().getConnection();
		List<Brinquedo> lista = new ArrayList<>();
		try {
			String sql = "SELECT * FROM brinquedo WHERE nome LIKE ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, "%" + nome + "%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) { 
				Brinquedo b = new Brinquedo();
				b.setId(rs.getLong("id"));
				b.setNome(rs.getString("nome"));
				b.setCategoria(rs.getString("categoria"));
				b.setFabricante(rs.getString("fabricante"));
				b.setIdadeMinima(rs.getInt("idade_minima"));
				b.setLote(rs.getInt("lote"));
				b.setDataCompra(rs.getDate("data_compra"));
				lista.add(b);
			}
			con.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return lista;
	}

	@Override
	public void removerPorId(long id) throws DAOException {
		Connection con = DBUtil.getInstance().getConnection();
		try {
			String sql = "DELETE FROM brinquedo WHERE id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			con.close();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		
	}

}
