package edu.curso.boundary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application 
						implements Executor, EventHandler<ActionEvent>{

	private BorderPane panPrincipal;
	private MenuItem mnuPet = new MenuItem("Pet");
	private MenuItem mnuAgenda = new MenuItem("Agenda");
	//private MenuItem mnuHardware = new MenuItem("Hardware");
	private Map<String, BoundaryContent> telas = new HashMap<>();

	@Override
	public void start(Stage stage) throws Exception {
		panPrincipal = new BorderPane();
		gerarMenu();
		Scene scn = new Scene(panPrincipal, 800, 600);
		stage.setScene(scn);
		stage.setTitle("Gestão de Pet Shop");
		stage.show();
	}
	
	private void gerarMenu() {
		MenuBar mnuBar = new MenuBar();
		Menu mnuArquivo = new Menu("Arquivo");
		Menu mnuGerenciar = new Menu("Gerenciar");
		Menu mnuAjuda = new Menu("Ajuda");
		
		telas.put(mnuPet.getText(), new PetBoundary(this));
		telas.put(mnuAgenda.getText(), new AgendaBoundary(this));
		
		mnuPet.addEventHandler(ActionEvent.ANY, this);
		mnuAgenda.addEventHandler(ActionEvent.ANY, this);
		mnuGerenciar.getItems().addAll(mnuPet, mnuAgenda);
		// telas.put(mnuHardware, new HardwareBoundary());
		//Set<MenuItem> menus = telas.keySet();
		//for (MenuItem m : menus) {
		//	m.addEventHandler(ActionEvent.ANY, this);
		//	mnuGerenciar.getItems().add(m);
		//}
		//mnuGerenciar.getItems().addAll(menus);
		
		mnuBar.getMenus().addAll(mnuArquivo, mnuGerenciar, mnuAjuda);
		panPrincipal.setTop(mnuBar);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() instanceof MenuItem) {
			MenuItem n = (MenuItem)event.getTarget();
			String comando = n.getText();
			executar(comando);
		}
	}

	@Override
	public void executar(String cmd) {
		System.out.println("Executando comando " + cmd);
		BoundaryContent tela = telas.get(cmd);
		if (tela != null) { 
			panPrincipal.setCenter(tela.gerarTela());
		}
	}

}
