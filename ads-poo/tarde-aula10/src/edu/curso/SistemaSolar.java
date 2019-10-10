package edu.curso;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class SistemaSolar extends Application {
	
//	public void start(Stage stage) { 
//		Group grp = new Group();
//		Canvas canvas = new Canvas( 512 - 64, 256 );
//		Scene scn = new Scene(grp, 512, 512);
//		grp.getChildren().add(canvas);
//		
//		Image img = new Image("file://C:/tmp/images/space.png");
//		GraphicsContext gc = 
//				canvas.getGraphicsContext2D();
//		
//		new AnimationTimer() {
//			@Override
//			public void handle(long now) {
//				gc.clearRect(0,  0, 448, 256);
//				gc.drawImage(img, 0,  0);
//			} 
//		}.start();
//		// gc.rect(100, 100, 200, 200);
//		
//		
//		stage.setScene(scn);
//		stage.setTitle("Sistema Solar");
//		stage.show();
//	}
	
	public void start(Stage theStage) 
	{
	    theStage.setTitle( "Canvas Example" );
	        
	    Group root = new Group();
	    Scene theScene = new Scene( root );
	    theStage.setScene( theScene );
	    Canvas canvas = new Canvas( 400, 200 );
	    root.getChildren().add( canvas );
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    gc.setFill( Color.RED );
	    gc.setStroke( Color.BLACK );
	    gc.setLineWidth(2);
	    gc.fillRect(100, 100, 200, 200);

	    gc.setFill( Color.YELLOW );
	    gc.setStroke( Color.BLUE );
	    gc.beginPath();
	    gc.moveTo(200, 200);
	    gc.lineTo(100, 100);
	    gc.arc(100, 100, 50, 50, 0, 360);
	    gc.stroke();
	    // Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
	    // gc.setFont( theFont );
	    // gc.fillText( "Hello, World!", 60, 50 );
	    // gc.strokeText( "Hello, World!", 60, 50 );	    
	    theStage.show();
	}

	public static void main(String[] args) {
		SistemaSolar.launch(args);
	}

}
