package edu.curso.boundary;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application implements EventHandler<ActionEvent>{
	private MenuBar barraMenu = new MenuBar();
	private Menu mnuArquivo = new Menu("Arquivo");
	private Menu mnuGerenciar = new Menu("Gerenciar");
	private Menu mnuAjuda = new Menu("Ajuda");
	private MenuItem mnuClientes = new MenuItem("Clientes");
	private MenuItem mnuEstoque = new MenuItem("Estoque");
	private MenuItem mnuFuncionarios = new MenuItem("Funcionarios");
	private BorderPane panPrincipal = new BorderPane();
	@Override
	public void start(Stage stage) throws Exception {
		panPrincipal.setTop(barraMenu);
		barraMenu.getMenus().addAll(mnuArquivo, mnuGerenciar, mnuAjuda);
		mnuGerenciar.getItems().addAll(mnuClientes, mnuEstoque, mnuFuncionarios);
		mnuClientes.addEventHandler(ActionEvent.ANY, this);
		mnuEstoque.addEventHandler(ActionEvent.ANY, this);
		mnuFuncionarios.addEventHandler(ActionEvent.ANY, this);
		Scene scn = new Scene(panPrincipal, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Gestão de Empresas");
		stage.show();
	}

	public static void main(String[] args) {
		launch(PrincipalBoundary.class, args);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == mnuClientes) { 
			ClienteBoundary clienteBoundary = new ClienteBoundary();
			panPrincipal.setCenter(clienteBoundary.generateForm());
		} else if (event.getTarget() == mnuEstoque) {
			EstoqueBoundary estoqueBoundary = new EstoqueBoundary();
			panPrincipal.setCenter(estoqueBoundary.generateForm());
		}
		
	}

}
