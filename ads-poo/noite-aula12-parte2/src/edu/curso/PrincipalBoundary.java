package edu.curso;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application {
	private MenuItem mnuAgenda = new MenuItem("Agenda");
	private MenuItem mnuHardware = new MenuItem("Hardware");
	private MenuItem mnuPet = new MenuItem("Pet");
	private BorderPane panPrincipal = new BorderPane();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(panPrincipal, 800, 600);
		
		MenuBar mnuPrincipal = new MenuBar();
		Menu mnuCadastro = new Menu("Cadastro");
		mnuPrincipal.getMenus().add(mnuCadastro);
		mnuCadastro.getItems().addAll(mnuAgenda, mnuHardware, mnuPet);
		
		mnuAgenda.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) { 
				panPrincipal.setCenter(
						new AgendaBoundary().boundaryContent());
			}
		});
		
		mnuPet.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) { 
				panPrincipal.setCenter(
						new PetBoundary().boundaryContent());
			}
		});
		
		mnuHardware.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) { 
				panPrincipal.setCenter(
						new HardwareBoundary().boundaryContent());
			}
		});
		panPrincipal.setTop(mnuPrincipal);
		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Sistema com varias telas");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
