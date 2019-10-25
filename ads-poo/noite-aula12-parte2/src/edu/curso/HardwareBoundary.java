package edu.curso;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class HardwareBoundary implements BoundaryContent {
	
	@Override
	public Pane boundaryContent() {
		GridPane panConteudo = new GridPane();
		panConteudo.add(new Label("Id"), 0, 0);
		panConteudo.add(new TextField(), 1, 0);
		panConteudo.add(new Label("Fabricante"), 0, 1);
		panConteudo.add(new TextField(), 1, 1);
		panConteudo.add(new Label("Tipo"), 0, 2);
		panConteudo.add(new TextField(), 1, 2);
		return panConteudo;
	}
	
}
