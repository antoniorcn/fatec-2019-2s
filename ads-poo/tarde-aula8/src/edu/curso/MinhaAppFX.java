package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MinhaAppFX extends Application {

	public static void main(String[] args) {
		MinhaAppFX.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		FlowPane pan = new FlowPane();
		pan.setHgap(10);
		pan.setVgap(10);
		Scene scn = new Scene(pan);
		stage.setScene(scn);
		Button btn = new Button("Ok");
		Label lblNome = new Label("Nome");
		TextField txtNome = new TextField();
		pan.getChildren().addAll(lblNome, txtNome, btn);
		stage.setTitle("Minha Janela");
		stage.show();
	}
}
