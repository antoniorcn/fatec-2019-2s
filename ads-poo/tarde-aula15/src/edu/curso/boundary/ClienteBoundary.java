package edu.curso.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ClienteBoundary implements 
		EventHandler<ActionEvent>, BoundaryContent, InvocarCommander{
	private GridPane panGrid;
	private Commander commander;
	private Button btnEstoque = new Button("Acessar Estoque");
	public ClienteBoundary(Commander c) {
		this.commander = c;
		panGrid = new GridPane();
		panGrid.add(new Label("Id"), 0, 0);
		panGrid.add(new TextField(), 1, 0);
		panGrid.add(new Label("Nome do Cliente"), 0, 1);
		panGrid.add(new TextField(), 1, 1);
		panGrid.add(new Label("CPF"), 0, 2);
		panGrid.add(new TextField(), 1, 2);
		panGrid.add(new Button("Adicionar"), 0, 3);
		panGrid.add(new Button("Pesquisar"), 1, 3);
		panGrid.add(btnEstoque, 0, 4);
		btnEstoque.addEventHandler(ActionEvent.ANY, this);
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
	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnEstoque) { 
			commander.executar("estoque");
		}
	}
}
