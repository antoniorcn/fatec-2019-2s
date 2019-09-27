package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class ContatoBoundary extends Application {
	
	@Override
	public void start(Stage stage) { 
		GridPane grid = new GridPane();
		grid.setStyle(
			"-fx-padding:10px; -fx-background-color:yellow"
		);
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(30);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(70);
		
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(25);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(25);
		RowConstraints row3 = new RowConstraints();
		row3.setPercentHeight(25);
		RowConstraints row4 = new RowConstraints();
		row4.setPercentHeight(25);
		
		grid.getRowConstraints().addAll(row1, row2, row3, row4);
		grid.getColumnConstraints().addAll(col1, col2);
		
		Scene scn = new Scene(grid, 640, 300);
		stage.setScene(scn);
		
		grid.setHgap(10);
		grid.setVgap(5);
		Label lblId = new Label("Id");
		lblId.setStyle("-fx-text-fill: red; -fx-font-size:200%;");
				
		grid.add(lblId, 0, 0);
		grid.add(new TextField(), 1, 0);
		grid.add(new Label("Nome"), 0, 1);
		grid.add(new TextField(), 1, 1);
		grid.add(new Label("Telefone"), 0, 2);
		grid.add(new TextField(), 1, 2);
		
		FlowPane botoes = new FlowPane();
		botoes.getChildren().addAll(
					new Button("Salvar"), 
					new Button("Pesquisar")
					);
		
		grid.add(botoes, 0, 3, 2, 1);
		stage.setTitle("Cadastro de Contatos");
		stage.show();	
	}
	
	public static void main(String[] args) {
		ContatoBoundary.launch(args);
	}

}
