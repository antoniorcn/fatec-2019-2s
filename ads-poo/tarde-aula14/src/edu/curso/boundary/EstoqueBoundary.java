package edu.curso.boundary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class EstoqueBoundary implements BoundaryContent, InvocarCommander {
	private GridPane panGrid = new GridPane();
	private Commander commander;

	public EstoqueBoundary(Commander c) {
		this.commander = c;
		ObservableList<String> categorias = 
				FXCollections.observableArrayList("Categoria 1", "Categoria 2", "Categoria 3");
		ComboBox<String> cmbCategorias = new ComboBox<>();
		cmbCategorias.setEditable(true);
		cmbCategorias.setItems(categorias);
		panGrid.add(new Label("Id"), 0, 0);
		panGrid.add(new TextField(), 1, 0);
		panGrid.add(new Label("Estoque"), 0, 1);
		panGrid.add(new TextField(), 1, 1);
		panGrid.add(new Label("Categoria"), 0, 2);
		panGrid.add(cmbCategorias, 1, 2);
		Button btnCriar = new Button("Criar");
		btnCriar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				categorias.add(cmbCategorias.getValue());
			} 		
		});
		panGrid.add(btnCriar, 2, 2);
		panGrid.add(new Label("Endereço do Estoque"), 0, 3);
		panGrid.add(new TextField(), 1, 3);
		panGrid.add(new Button("Adicionar"), 0, 4);
		panGrid.add(new Button("Pesquisar"), 1, 4);
	}
	
	public Pane generateForm() { 
		return panGrid;
	}

	@Override
	public void setCommander(Commander c) {
		this.commander = c;		
	}

	@Override
	public Commander getCommander() {
		return this.commander;
	}
}
