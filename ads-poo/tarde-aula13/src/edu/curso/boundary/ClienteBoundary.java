package edu.curso.boundary;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ClienteBoundary implements BoundaryContent{
	public Pane generateForm() { 
		GridPane panGrid = new GridPane();
		panGrid.add(new Label("Id"), 0, 0);
		panGrid.add(new TextField(), 1, 0);
		panGrid.add(new Label("Nome do Cliente"), 0, 1);
		panGrid.add(new TextField(), 1, 1);
		panGrid.add(new Label("CPF"), 0, 2);
		panGrid.add(new TextField(), 1, 2);
		panGrid.add(new Button("Adicionar"), 0, 3);
		panGrid.add(new Button("Pesquisar"), 1, 3);
		return panGrid;
	}
}
