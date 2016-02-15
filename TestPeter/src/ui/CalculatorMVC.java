package ui;
import multiformat.*;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JPanel;

public class CalculatorMVC extends JApplet {
	Calculator model; // het model
	Container container;
	CalculatorView antwoordView; // view
	CalculatorInputView inputView; //view
	CalculatorController controller; //controller
	
	public void init(){
		resize(200, 500);
		
		model = new Calculator();
	
		controller = new CalculatorController(model);
		container = new JPanel();
		 
		getContentPane().add(controller,BorderLayout.CENTER);
		inputView = new CalculatorInputView();
		getContentPane().add(container, BorderLayout.NORTH);
		container.add(inputView, BorderLayout.EAST);
		antwoordView = new CalculatorView();
		container.add(antwoordView, BorderLayout.WEST);
		model.addActionListener(inputView);
		model.addActionListener(antwoordView);
	}

}
