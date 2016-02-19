package ui;
import javax.swing.*;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import multiformat.Calculator;

import java.awt.*;

public class CalculatorMVC extends Application
{
	/*
	DobbelsteenModel model;             //het model
	TekstView tekstView;              // view
	DobbelsteenView dobbelsteenView;  // view
	StatistiekView statistiekView; //view
	DobbelsteenController controller;             // Controller
	*/
	
	Calculator calc;
	CalculatorController controller;
	ResultView resultView;
	
	@Override
	public void start(Stage primaryStage)
	{
		calc = new Calculator();
		BorderPane mainPane = new BorderPane();
		
		
		CalculatorController calculatorController = new CalculatorController(calc);
	    calculatorController.setStyle("-fx-background-color: rgba(200,200,200,0.10);");
		resultView = new ResultView();
	    resultView.setStyle("-fx-background-color: black;");
		mainPane.setCenter(calculatorController);
		mainPane.setTop(resultView);
		
		calc.addEventHandler(resultView);
		
		Scene scene = new Scene(mainPane, 250, 200);
		primaryStage.setTitle("Most Awesome Calculator Ever");
		primaryStage.setScene(scene);
		primaryStage.show();
					
		
		//getContentPane().add(controller, BorderLayout.SOUTH);
		
		//resultView = new ResultView();
		//getContentPane().add(resultView, BorderLayout.NORTH);
        
		// Maak het model
		//model = new DobbelsteenModel();
        
        // Maak de controller en geef hem het model
		//controller = new DobbelsteenController(model);
        //controller.setBackground(Color.cyan);
        //getContentPane().add(controller,BorderLayout.NORTH);
                
        // Maak de views
        
       // statistiekView = new StatistiekView();
       // getContentPane().add(statistiekView, BorderLayout.EAST);
        
        
        // Registreer de views bij het model
        //model.addActionListener(tekstView);
        
        // Eerste worp
        //model.gooi();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
