package edu.curso.boundary;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class FuncionarioBoundary implements BoundaryContent{
	private Pane painel = new Pane();

	public FuncionarioBoundary() {
		Label lblId = new Label("Id");
		TextField txtId = new TextField();
		txtId.relocate(100, 50);
		Label lblNome = new Label("Nome Funcionario");
		lblNome.relocate(200, 100);
		TextField txtNome = new TextField();
		txtNome.relocate(300,  150);
		painel.getChildren().addAll(lblId, txtId, lblNome, txtNome);
	}
	
	public Pane generateForm() { 
		return painel;
	}
}
