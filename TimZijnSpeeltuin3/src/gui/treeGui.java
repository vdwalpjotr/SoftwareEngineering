package gui;

import classifier.FileReader;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class treeGui extends Application implements EventHandler<WindowEvent> {
		
	private questionnaireController qc;
	protected static int prefHeight = 300;
	protected static int prefWidth = 300;
	
	public void start(Stage primaryStage) {
		FileReader fr = new FileReader();
		
		qc = new questionnaireController(prefHeight, prefWidth, fr);
		Scene scene = new Scene(qc, prefHeight, prefWidth);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Car insurance");
		primaryStage.show();
		
		primaryStage.setOnCloseRequest(this);
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	public void handle(WindowEvent arg0) {
		Alert alert = qc.getWindowAlert();
		if(alert != null) {
			alert.showAndWait();
			arg0.consume();			
		}
	}
}
