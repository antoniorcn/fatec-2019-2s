package edu.curso.boundary;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class PrincipalBoundary extends Application 
	implements EventHandler<ActionEvent>, Commander {
	private MenuBar barraMenu = new MenuBar();
	private Menu mnuArquivo = new Menu("Arquivo");
	private Menu mnuGerenciar = new Menu("Gerenciar");
	private Menu mnuAjuda = new Menu("Ajuda");
	private MenuItem mnuClientes = new MenuItem("Clientes");
	private MenuItem mnuEstoque = new MenuItem("Estoque");
	private MenuItem mnuFuncionarios = new MenuItem("Funcionarios");
	private BorderPane panPrincipal = new BorderPane();
	
	private Map<String, BoundaryContent> telas = new HashMap<>();
	
	@Override
	public void start(Stage stage) throws Exception {
		mnuClientes.setUserData("cliente");
		mnuEstoque.setUserData("estoque");
		mnuFuncionarios.setUserData("funcionario");
		panPrincipal.setTop(barraMenu);
		generateMenus();
		Scene scn = new Scene(panPrincipal, 800, 600);
		
		stage.setScene(scn);
		stage.setTitle("Gestão de Empresas");
		stage.show();
	}
	
	public void generateMenus() { 
		barraMenu.getMenus().addAll(mnuArquivo, mnuGerenciar, mnuAjuda);
		mnuGerenciar.getItems().addAll(mnuClientes, mnuEstoque, mnuFuncionarios);
		
		telas.put("cliente", new ClienteBoundary(this));
		telas.put("estoque", new EstoqueBoundary(this));
		telas.put("funcionario", new FuncionarioBoundary(this));
		
		mnuClientes.addEventHandler(ActionEvent.ANY, this);
		mnuEstoque.addEventHandler(ActionEvent.ANY, this);
		mnuFuncionarios.addEventHandler(ActionEvent.ANY, this);
		
		
	}

	public static void main(String[] args) {
		launch(PrincipalBoundary.class, args);
	}

	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() instanceof MenuItem) { 
			MenuItem mnu = (MenuItem)event.getTarget();
			executar(mnu.getUserData().toString());
		}
	}

	@Override
	public void executar(String comando) {
		BoundaryContent tela = telas.get(comando);
		if (tela != null) { 
			panPrincipal.setCenter(tela.generateForm());
		}
	}

}
