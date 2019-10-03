package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculadora extends Application {

	private char[] botoes = {
					'1', '2', '3', '+', 
					'4', '5', '6', '-',
					'7', '8', '9', '*',
					',', '0', '=', '/'}; 
	
	
	@Override
	public void start(Stage stage) throws Exception {
		BorderPane border = new BorderPane();
		FlowPane flow = new FlowPane();

		GridPane grid = new GridPane();
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setFillWidth(true);
		col1.setPercentWidth(25);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setFillWidth(true);
		col2.setPercentWidth(25);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setFillWidth(true);
		col3.setPercentWidth(25);
		ColumnConstraints col4 = new ColumnConstraints();
		col4.setFillWidth(true);
		col4.setPercentWidth(25);
		grid.getColumnConstraints().addAll(col1, col2, col3, col4);
		flow.setHgap(10);
		Scene scn = new Scene(border, 400, 300);
		border.setTop(flow);
		border.setCenter(grid);
		TextField text = new TextField();
		text.setMaxWidth(Double.MAX_VALUE);
		flow.getChildren().addAll(text, new Button("CE"));
		int linha = 0;
		int coluna = 0;
		for(char c : botoes) {
			Button button = new Button(String.valueOf(c));
			button.setMaxWidth(Double.MAX_VALUE);
			button.setMaxHeight(Double.MAX_VALUE);
			grid.add(button, linha, coluna++);
			if (coluna >= 4) { 
				coluna = 0;
				linha++;
			}
		}
		
		stage.setScene(scn);
		stage.setTitle("Calculadora");
		stage.show();
	}
	
	public static void main(String[] args) {
		Calculadora.launch(args);
	}
}
