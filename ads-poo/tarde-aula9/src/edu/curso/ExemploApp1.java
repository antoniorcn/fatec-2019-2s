package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ExemploApp1 extends Application {
	class ManipuladorMouse implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			Button b = (Button)e.getTarget();
			System.out.println("Texto do botao pressionado: " + b.getText());
			System.out.println("Action : " + e.getEventType());
			System.out.println("Source : " + e.getSource().getClass().getName());
			System.out.println("Target : " + e.getTarget().getClass().getName());
		}
	}
	public void start(Stage stage) throws Exception {
		Pane panel = new Pane();
		Button btn = new Button("Ok");
		EventHandler<ActionEvent> manipulador = new ManipuladorMouse();
		btn.addEventFilter(ActionEvent.ANY, manipulador);
		panel.getChildren().add(btn);
		Scene scn = new Scene(panel);
		stage.setScene(scn);
		stage.setTitle("Teste de Eventos");
		stage.show();
	}
	
	public static void main(String[] args) {
		ExemploApp1.launch(args);
	}
}