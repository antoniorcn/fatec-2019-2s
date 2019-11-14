package edu.curso.dao;

import java.util.List;

import edu.curso.entidades.Hardware;

public interface HardwareDAO {
	void adicionar(Hardware h) throws DAOException;
	List<Hardware> pesquisarPorTipo(String tipo) throws DAOException;
}
