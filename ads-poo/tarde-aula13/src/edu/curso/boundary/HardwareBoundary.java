package edu.curso.boundary;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import edu.curso.control.HardwareControl;
import edu.curso.entidades.Hardware;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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
	private DatePicker dtpDataCompra = new DatePicker();
	private TextField txtDescricao = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private TableView<Hardware> table = new TableView<>();
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
		
		painelPrincipal.setTop(painelCampos);
		painelPrincipal.setCenter(table);
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
		painelCampos.add(dtpDataCompra, 1, 4);
		painelCampos.add(new Label("Descricao"), 0, 5);
		painelCampos.add(txtDescricao, 1, 5);
		
		painelBotoes.getChildren().addAll(btnAdicionar, btnPesquisar);
		
		addTableColumns();
		
		btnAdicionar.addEventHandler(ActionEvent.ANY, this);
		btnPesquisar.addEventHandler(ActionEvent.ANY, this);
		table.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Hardware>() {
					@Override
					public void changed(ObservableValue<? extends Hardware> observable, Hardware oldValue,
							Hardware newValue) {
						entidadeParaBoundary(newValue);
					}
				});
		painelBotoes.setHgap(15);
		Scene scn = new Scene(painelPrincipal, 400, 200);
		
		primaryStage.setScene(scn);
		primaryStage.setTitle("Gestão de Hardware");
		primaryStage.show();
	}
	
	public void addTableColumns() { 
		TableColumn<Hardware, Long> columnId = new TableColumn<>("Id");
		columnId.setCellValueFactory(
				new PropertyValueFactory<Hardware, Long>("id"));
		
		TableColumn<Hardware, String> columnTipo = new TableColumn<>("Tipo");
		columnTipo.setCellValueFactory(
				new PropertyValueFactory<Hardware, String>("tipo"));
		
		TableColumn<Hardware, String> columnFabricante = new TableColumn<>("Fabricante");
		columnFabricante.setCellValueFactory(
				new PropertyValueFactory<Hardware, String>("fabricante"));
		
		table.getColumns().addAll(columnId, columnTipo, columnFabricante);
		table.setItems(control.getLista());
	}
	
	public Hardware boundaryParaEntidade() { 
		Hardware h = new Hardware();
		try {
			h.setTipo(txtTipo.getText());
			h.setFabricante(txtFabricante.getText());
			h.setDescricao(txtDescricao.getText());
			h.setId(Long.parseLong(txtId.getText()));
			h.setPreco(Double.parseDouble(txtPreco.getText()));
			LocalDate dt = dtpDataCompra.getValue();
			Date d = Date.from(dt.atStartOfDay()
				      .atZone(ZoneId.systemDefault())
				      .toInstant());
			// String dtTexto = 
			//		dt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			// Date d = sdf.parse(dtTexto);
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
			// String strData = sdf.format(h.getDataCompra());
			// dtpDataCompra.setText(strData);
			
			LocalDate dt = h.getDataCompra().toInstant()
		      .atZone(ZoneId.systemDefault())
		      .toLocalDate();
			dtpDataCompra.setValue(dt);
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
		} else if (event.getTarget() == table) { 
			System.out.println(table.getSelectionModel().getSelectedIndex());
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}	
}
