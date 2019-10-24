package edu.curso.control;

import edu.curso.entidades.Hardware;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HardwareControl {
	private ObservableList<Hardware> lista = 
			FXCollections.observableArrayList();
	
	public void adicionar(Hardware h) { 
		getLista().add(h);
	}
	
	public Hardware pesquisarPorTipo(String tipo) { 
		for (Hardware h : getLista()) { 
			if (h.getTipo().contains(tipo)) { 
				return h;
			}
		}
		return null;
	}

	public ObservableList<Hardware> getLista() {
		return lista;
	}
}
