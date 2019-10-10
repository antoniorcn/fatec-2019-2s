package edu.curso;

import java.awt.Point;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

class Ponto {
	double x;
	double y;
	public Ponto(double x, double y) { 
		this.x = x;
		this.y = y;
	}
	public void addX(double value) { 
		x += value;
	}
	public void addY(double value) { 
		y += value;
	}
}

public class Bolinha extends Application {
	final static double VELOCIDADE = 0.1;
	
	@Override
	public void start(Stage stage) throws Exception {
		Group grp = new Group();
		Scene scn = new Scene(grp, 640, 480);
		stage.setScene(scn);
		Canvas canvas = new Canvas(640, 480);
		grp.getChildren().add(canvas);
		GraphicsContext ctx = canvas.getGraphicsContext2D();
		ctx.setFill(Color.BLUE);
		ctx.setStroke(Color.BLACK);
		final Ponto p = new Ponto(300, 100);
		final Ponto vel = new Ponto(VELOCIDADE, 0);
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				ctx.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
				ctx.fillArc(p.x, p.y, 50, 50, 0, 360, ArcType.ROUND);
				ctx.beginPath();
				ctx.strokeArc(p.x, p.y, 50, 50, 0, 360, ArcType.ROUND);
				ctx.stroke();
				p.x = p.x + vel.x;
				if (p.x + 50 > canvas.getWidth()) { 
					vel.x = -VELOCIDADE;
				}
				if (p.x < 0) { 
					vel.x = VELOCIDADE;
				}
			} 
		}.start();
		stage.show();
	}
	
	public static void main(String[] args) {
		Bolinha.launch(args);
	}

}
