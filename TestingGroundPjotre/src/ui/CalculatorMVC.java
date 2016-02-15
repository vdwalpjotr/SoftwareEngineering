package ui;
import multiformat.*;

import java.awt.BorderLayout;

import javax.swing.JApplet;

public class CalculatorMVC extends JApplet {
	Calculator model; // het model
	CalculatorView antwoordView; // view
	CalculatorInputView inputView; //view
	CalculatorController controller; //controller
	
	public void init(){
		resize(200, 500);
		
		model = new Calculator();
	
		controller = new CalculatorController(model);
		getContentPane().add(controller,BorderLayout.CENTER);
		inputView = new CalculatorInputView();
		getContentPane().add(inputView, BorderLayout.NORTH);
		model.addActionListener(inputView);
		
	}

}
