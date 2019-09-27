package edu.curso;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Janela extends Application {
	@Override
	public void start(Stage stage) {
		Pane painel = new Pane();
		Scene scn = new Scene(painel);
		stage.setScene(scn);
		Label nome = new Label("Nome do usuario");
		//painel.getChildren().add(nome);		
		
		TextField txt = new TextField();
		txt.relocate(100, 0);
		//painel.getChildren().add(txt);
		
		Button btn = new Button("Ok");
		btn.relocate(300, 0);
		//painel.getChildren().add(btn);
		painel.getChildren().addAll(nome, txt, btn);
		stage.setTitle("Minha Primeira Janela");
		stage.show();
	}
	
	public static void main(String[] args) {
		Janela.launch(args);
	}

}
