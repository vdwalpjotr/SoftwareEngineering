package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class treeGui extends Application {
		
	private questionnaireController qc;
	
	public void start(Stage primaryStage) {
		qc = new questionnaireController();
		Scene scene = new Scene(qc, 250,250);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
