package edu.curso.boundary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PetBoundary implements BoundaryContent {
	private TextField txtId = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtDono = new TextField();
	private ComboBox<String> cmbRaca = new ComboBox<>();
	private Executor executor;
	
	public PetBoundary(Executor e) { 
		this.setExecutor(e);
	}
	
	@Override
	public Pane gerarTela() {
		
		ObservableList<String> racas = 
				FXCollections.observableArrayList("Pasto Alemão", "Pincher",
						"Lhasa Apso", "Coker Spaniel");
		cmbRaca.setItems(racas);
		cmbRaca.setEditable(true);
		
		Button btnAdd = new Button("Add");
		btnAdd.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				racas.add(cmbRaca.getValue());
				executor.executar("Adicionar Raca");
			}
		});
		CheckBox chkRaiva = new CheckBox("Raiva");
		CheckBox chkParvo = new CheckBox("Parvovirose");
		CheckBox chkSarna = new CheckBox("Sarna");		
		RadioButton radCastradoSim = new RadioButton("Sim");
		RadioButton radCastradoNao = new RadioButton("Não");
		ToggleGroup grp = new ToggleGroup();
		radCastradoNao.setToggleGroup(grp);
		radCastradoSim.setToggleGroup(grp);
		
		Button btnAgenda = new Button("Abrir Agenda");
		btnAgenda.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				executor.executar("Agenda");
			}
		});
		
		GridPane pane = new GridPane();
		pane.add(new Label("Id"), 0, 0);
		pane.add(txtId, 1, 0);
		pane.add(new Label("Nome do Pet"), 0, 1);
		pane.add(txtNome, 1, 1);
		pane.add(new Label("Raça do Pet"), 0, 2);
		pane.add(cmbRaca, 1, 2);
		pane.add(btnAdd, 2, 2);
		pane.add(new Label("Nome do Dono"), 0, 3);
		pane.add(txtDono, 1, 3);
		pane.add(new Label("Castrado"), 0, 4);
		pane.add(radCastradoSim, 1, 4);
		pane.add(radCastradoNao, 2, 4);
		pane.add(new Label("Vacinas"), 0, 5);
		pane.add(chkRaiva, 1, 5);
		pane.add(chkParvo, 2, 5);
		pane.add(chkSarna, 3, 5);
		pane.add(btnAgenda, 1, 6);
		return pane;
	}
	
	@Override
	public void setExecutor(Executor e) {
		this.executor = e;
	}
	@Override
	public Executor getExecutor() {
		return this.executor;
	}
}
