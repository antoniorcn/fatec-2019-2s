package edu.tartaruga.dao;

import java.util.List;

import edu.tartaruga.entidade.Entrega;

public interface EntregaDAO {
	void adicionar(Entrega e) throws DAOException;
	List<Entrega> pesquisar(String origem) throws DAOException;
}
