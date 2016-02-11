package ui;
import javax.swing.*;

import multiformat.Calculator;

import java.awt.*;

public class CalculatorMVC extends JApplet
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
	
	public void init()
	{
		resize(250,200);
		
		calc = new Calculator();
		controller = new CalculatorController(calc);
		getContentPane().add(controller, BorderLayout.SOUTH);
		
		resultView = new ResultView();
		getContentPane().add(resultView, BorderLayout.NORTH);
        
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
}
