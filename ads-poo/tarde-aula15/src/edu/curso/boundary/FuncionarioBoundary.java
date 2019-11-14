package edu.curso.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class FuncionarioBoundary 
	implements BoundaryContent, InvocarCommander, EventHandler<ActionEvent> {
	private Pane painel = new Pane();
	private Commander commander;
	private Button btnCliente = new Button("Acessar Cliente");

	public FuncionarioBoundary(Commander c) {
		this.commander = c;
		Label lblId = new Label("Id");
		TextField txtId = new TextField();
		txtId.relocate(100, 50);
		Label lblNome = new Label("Nome Funcionario");
		lblNome.relocate(200, 100);
		TextField txtNome = new TextField();
		txtNome.relocate(300,  150);
		btnCliente.relocate(100, 200);
		painel.getChildren().addAll(lblId, txtId, lblNome, txtNome, btnCliente);
		btnCliente.addEventHandler(ActionEvent.ANY, this);
	}
	
	public Pane generateForm() { 
		return painel;
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
		commander.executar("cliente");
	}
}
