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
	CalculatorController controller; //controller voor getalleninput
	OperatorController opcontroller; //controller voor operatorinput
	
	public void init(){
		resize(200, 500);
		
		model = new Calculator();
	
		controller = new CalculatorController(model);
		opcontroller = new OperatorController(model);
		container = new JPanel();
		inputView = new CalculatorInputView();
		antwoordView = new CalculatorView();
		
		getContentPane().add(controller,BorderLayout.CENTER);	
		getContentPane().add(container, BorderLayout.NORTH);
		container.add(inputView, BorderLayout.EAST);
		container.add(antwoordView, BorderLayout.WEST);
		getContentPane().add(opcontroller, BorderLayout.SOUTH);
		model.addActionListener(inputView);
		model.addActionListener(antwoordView);
	}

}
