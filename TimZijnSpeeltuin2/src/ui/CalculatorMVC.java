package ui;
import javax.swing.*;

import javafx.application.Application;
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
		Pane mainPane = new Pane();
		GridPane gridPane = new GridPane();
		Button btn0 = new Button("0");
		Button btn1 = new Button("1");
		Button btn2 = new Button("2");
		Button btn3 = new Button("3");
		Button btn4 = new Button("4");
		Button btn5 = new Button("5");
		Button btn6 = new Button("6");
		Button btn7 = new Button("7");
		Button btn8 = new Button("8");
		Button btn9 = new Button("9");
		
		gridPane.add(btn9, 0, 0);
		gridPane.add(btn8, 1, 0);
		gridPane.add(btn7, 2, 0);
		gridPane.add(btn6, 0, 1);
		gridPane.add(btn5, 1, 1);
		gridPane.add(btn4, 2, 1);
		gridPane.add(btn3, 0, 2);
		gridPane.add(btn2, 1, 2);
		gridPane.add(btn1, 2, 2);
		gridPane.add(btn0, 1, 3);
		
		Button buttonMultiply = new Button("X");
		Button buttonDivide = new Button("/");
		Button buttonSubtract = new Button("-");
		Button buttonSum = new Button("+");
		
		gridPane.add(buttonDivide, 3, 0);
		gridPane.add(buttonMultiply, 3, 1);
		gridPane.add(buttonSubtract, 3, 2);
		gridPane.add(buttonSum, 3, 3);
		
		Button buttonDot = new Button(".");
		Button buttonOpposit = new Button("+/-");
		
		gridPane.add(buttonDot, 2, 3);
		gridPane.add(buttonOpposit, 0, 3);
		
		mainPane.getChildren().add(gridPane);
		
		Scene scene = new Scene(mainPane, 250, 200);
		primaryStage.setTitle("Most Awesome Calculator Ever");
		primaryStage.setScene(scene);
		primaryStage.show();
				
		calc = new Calculator();
		controller = new CalculatorController(calc);
		//getContentPane().add(controller, BorderLayout.SOUTH);
		
		resultView = new ResultView();
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
