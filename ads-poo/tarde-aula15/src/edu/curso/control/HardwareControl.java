package edu.curso.control;
import java.util.List;
import edu.curso.dao.DAOException;
import edu.curso.dao.HardwareDAO;
import edu.curso.dao.HardwareDAOImpl;
import edu.curso.entidades.Hardware;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HardwareControl {
	private ObservableList<Hardware> lista = 
			FXCollections.observableArrayList();
	
	private HardwareDAO hDAO = new HardwareDAOImpl();

	public void adicionar(Hardware h) { 
		getLista().add(h);
		try {
			hDAO.adicionar(h);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public void pesquisarPorTipo(String tipo) {
		try {
			List<Hardware> listaHardwares = hDAO.pesquisarPorTipo(tipo);
			for(Hardware h : listaHardwares) { 
				lista.add(h);
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}

	public ObservableList<Hardware> getLista() {
		return lista;
	}
}
