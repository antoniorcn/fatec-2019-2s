package edu.curso.boundary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.MaskFormatter;

import edu.curso.control.HardwareControl;
import edu.curso.entidades.Hardware;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class HardwareBoundary extends Application implements EventHandler<ActionEvent> {
	private HardwareControl control = new HardwareControl();
	private TextField txtId = new TextField();
	private TextField txtTipo = new TextField();
	private TextField txtFabricante = new TextField();
	private TextField txtPreco = new TextField();
	private TextField txtDataCompra = new TextField();
	private TextField txtDescricao = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane painelPrincipal = new BorderPane();
		painelPrincipal.setStyle("-fx-padding: 10px");
		FlowPane painelBotoes = new FlowPane();
		GridPane painelCampos = new GridPane();
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(30);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(70);
		painelCampos.getColumnConstraints().addAll(col0, col1);
		
		painelPrincipal.setCenter(painelCampos);
		painelPrincipal.setBottom(painelBotoes);
		
		painelCampos.add(new Label("Id"), 0, 0);
		painelCampos.add(txtId, 1, 0);
		painelCampos.add(new Label("Tipo"), 0, 1);
		painelCampos.add(txtTipo, 1, 1);
		painelCampos.add(new Label("Fabricante"), 0, 2);
		painelCampos.add(txtFabricante, 1, 2);
		painelCampos.add(new Label("Preço"), 0, 3);
		painelCampos.add(txtPreco, 1, 3);
		painelCampos.add(new Label("Data Compra"), 0, 4);
		painelCampos.add(txtDataCompra, 1, 4);
		painelCampos.add(new Label("Descricao"), 0, 5);
		painelCampos.add(txtDescricao, 1, 5);
		
		painelBotoes.getChildren().addAll(btnAdicionar, btnPesquisar);
		
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnPesquisar.addEventHandler(ActionEvent.ANY, this);
		painelBotoes.setHgap(15);
		Scene scn = new Scene(painelPrincipal, 400, 200);
		
		primaryStage.setScene(scn);
		primaryStage.setTitle("Gestão de Hardware");
		primaryStage.show();
	}
	
	public Hardware boundaryParaEntidade() { 
		Hardware h = new Hardware();
		try {
			h.setTipo(txtTipo.getText());
			h.setFabricante(txtFabricante.getText());
			h.setDescricao(txtDescricao.getText());
			h.setId(Long.parseLong(txtId.getText()));
			h.setPreco(Double.parseDouble(txtPreco.getText()));
			Date d = sdf.parse(txtDataCompra.getText());
			h.setDataCompra(d);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return h;
	}
	
	public void entidadeParaBoundary(Hardware h) { 
		if (h != null) { 
			txtTipo.setText(h.getTipo());
			txtFabricante.setText(h.getFabricante());
			txtDescricao.setText(h.getDescricao());
			txtId.setText(String.valueOf(h.getId()));
			txtPreco.setText(String.valueOf(h.getPreco()));
			String strData = sdf.format(h.getDataCompra());
			txtDataCompra.setText(strData);
		}
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnAdicionar) { 
			control.adicionar(boundaryParaEntidade());
		} else if (event.getTarget() == btnPesquisar) {
			String tipo = txtTipo.getText();
			Hardware h = control.pesquisarPorTipo(tipo);			
			entidadeParaBoundary(h);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}
