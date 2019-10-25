package edu.curso.boundary;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application 
			implements EventHandler<ActionEvent>{
	private MenuItem mnuAgenda = new MenuItem("Agenda");
	private MenuItem mnuPet = new MenuItem("Pet");
	private MenuItem mnuHardware = new MenuItem("Hardware");
	private Map<MenuItem, BoundaryContent> menuContent = new 
			HashMap<>();
	private BoundaryContent currentContent;
	private BorderPane panPrincipal;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		generateMenuOptions();
		panPrincipal = new BorderPane();
		Scene scn = new Scene(panPrincipal, 800, 600);

		Menu mnuCadastro = new Menu("Cadastros");
		MenuBar mnuBar = new MenuBar(mnuCadastro);
		mnuCadastro.getItems().addAll(mnuAgenda, mnuPet, mnuHardware);
		//mnuAgenda.addEventHandler(ActionEvent.ANY, this);
		panPrincipal.setTop(mnuBar);
		
		updateContent();
		
		primaryStage.setScene(scn);
		primaryStage.setTitle("Sistema com menus");
		primaryStage.show();
	}

	private void updateContent() {
		Pane conteudo = null;
		if (currentContent != null) { 
			conteudo = currentContent.boundaryContent();
		}
		panPrincipal.setCenter( conteudo );
	}
	
	@Override
	public void handle(ActionEvent event) {
		currentContent = menuContent.get(event.getTarget());
		updateContent();
	}
	
	public void generateMenuOptions() {
		mnuAgenda.setOnAction(this);
		mnuPet.setOnAction(this);
		mnuHardware.setOnAction(this);
		menuContent.put(mnuAgenda, new AgendaBoundary());
		menuContent.put(mnuPet, new PetBoundary());
		menuContent.put(mnuHardware, new HardwareBoundary());
	}
		
	public static void main(String[] args) {
		launch(args);
	}
}
