package edu.curso.boundary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.curso.control.QuartoHotelControl;
import edu.curso.entidades.QuartoHotel;
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

public class QuartoHotelBoundary extends Application implements EventHandler<ActionEvent> {
	private QuartoHotelControl control = new QuartoHotelControl();
	private TextField txtId = new TextField();
	private TextField txtNumeroQuarto = new TextField();
	private TextField txtDataReserva = new TextField();
	private TextField txtValorDiaria = new TextField();
	private TextField txtNumeroCamas = new TextField();
	private TextField txtObservacao = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public QuartoHotel boundaryParaEntidade() { 
		QuartoHotel q = new QuartoHotel();
		try {
			q.setNumeroQuarto(txtNumeroQuarto.getText());
			q.setObservacao(txtObservacao.getText());
			q.setId(Long.parseLong(txtId.getText()));
			q.setNumeroCamas(Integer.parseInt(txtNumeroCamas.getText()));
			q.setValorDiaria(Double.parseDouble(txtValorDiaria.getText()));
			Date d = sdf.parse(txtDataReserva.getText());
			q.setDataReserva(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return q;
	}
	
	public void entidadeParaBoundary(QuartoHotel q) { 
		if (q != null) { 
			txtNumeroQuarto.setText(q.getNumeroQuarto());
			txtObservacao.setText(q.getObservacao());
			txtId.setText(String.valueOf(q.getId()));
			txtValorDiaria.setText(String.valueOf(q.getValorDiaria()));
			txtNumeroCamas.setText(String.valueOf(q.getNumeroCamas()));
			txtDataReserva.setText(sdf.format(q.getDataReserva()));
		}
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane painelPrincipal = new BorderPane();
		GridPane painelCampos = new GridPane();
		FlowPane painelBotoes = new FlowPane();
		painelPrincipal.setStyle("-fx-padding:15px");
		ColumnConstraints col0 = new ColumnConstraints();
		col0.setPercentWidth(30);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(70);
		painelCampos.getColumnConstraints().addAll(col0, col1);
		
		painelBotoes.setHgap(15);
		
		painelCampos.add(new Label("Id"), 0, 0);
		painelCampos.add(txtId, 1, 0);
		painelCampos.add(new Label("Numero Quarto"), 0, 1);
		painelCampos.add(txtNumeroQuarto, 1, 1);
		painelCampos.add(new Label("Data Reserva"), 0, 2);
		painelCampos.add(txtDataReserva, 1, 2);
		painelCampos.add(new Label("Valor Diaria"), 0, 3);
		painelCampos.add(txtValorDiaria, 1, 3);
		painelCampos.add(new Label("Numero de Camas"), 0, 4);
		painelCampos.add(txtNumeroCamas, 1, 4);
		painelCampos.add(new Label("Observações"), 0, 5);
		painelCampos.add(txtObservacao, 1, 5);
		
		painelBotoes.getChildren().addAll(btnAdicionar, btnPesquisar);
		
		painelPrincipal.setCenter(painelCampos);
		painelPrincipal.setBottom(painelBotoes);
		
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnPesquisar.addEventHandler(ActionEvent.ANY, this);
	
		Scene scn = new Scene(painelPrincipal, 400, 200);
		primaryStage.setScene(scn);
		primaryStage.setTitle("Gestão de Quarto de Hotel");
		primaryStage.show();
	}
	
	@Override
	public void handle(ActionEvent event) {
		if (event.getTarget() == btnAdicionar) { 
			control.adicionar( boundaryParaEntidade() );
		} else if (event.getTarget() == btnPesquisar) {
			String numQuarto = txtNumeroQuarto.getText();
			QuartoHotel q = control.pesquisarPorNumeroQuarto(numQuarto);
			entidadeParaBoundary(q);			
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
