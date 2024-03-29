package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JanelaContatos extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		GridPane painel = new GridPane();
		painel.setStyle("-fx-background-color:yellow; -fx-padding:20px");
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(30);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		painel.getColumnConstraints().addAll(col1, col2);
		painel.setHgap(5);
		painel.setVgap(10);
		Scene scn = new Scene(painel);
		painel.add(new Label("Id"), 0, 0);
		painel.add(new TextField(), 1, 0, 3, 1);
		painel.add(new Label("Nome"), 0, 1);
		painel.add(new TextField(), 1, 1, 3, 1);
		painel.add(new Label("Telefone"), 0, 2);
		painel.add(new TextField(), 1, 2, 3, 1);
		FlowPane f = new FlowPane();
		f.setHgap(5);
		f.getChildren().add(new Button("Salvar"));
		f.getChildren().add(new Button("Pesquisar"));
		painel.add(f, 0, 3, 2, 1);
		stage.setTitle("Gest�o de Contatos");
		stage.setScene(scn);
		stage.show();		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	

}
