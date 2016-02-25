package gui;

import classifier.FileReader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class treeGui extends Application implements EventHandler<ActionEvent> {
		
	private questionnaireController qc;
	protected static int prefHeight = 300;
	protected static int prefWidth = 300;
	
	public void start(Stage primaryStage) {
<<<<<<< HEAD
		FileReader fr = new FileReader();
		qc = new questionnaireController(fr);
		Scene scene = new Scene(qc, 250,250);
=======
		qc = new questionnaireController(prefHeight, prefWidth);
		Scene scene = new Scene(qc, prefHeight,prefWidth);
>>>>>>> origin/master
		primaryStage.setScene(scene);
		primaryStage.setTitle("Car insurance");
		primaryStage.show();
		
		//primaryStage.setOnCloseRequest(this);
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(ActionEvent arg0) {
		//Alert a = new Alert();
		
	}
}
