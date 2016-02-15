package ui;
import multiformat.*;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JApplet;
import javax.swing.JPanel;

public class CalculatorMVC extends JApplet {
	Calculator model; // het model
	
	CalculatorView antwoordView; // view
	CalculatorInputView inputView; //view
	CalculatorController controller; //controller voor getalleninput
	OperatorController opcontroller; //controller voor operatorinput
	
	public void init(){
		resize(300, 500);
		
		model = new Calculator();
	
		controller = new CalculatorController(model);
		opcontroller = new OperatorController(model);
		JPanel viewPanel = new JPanel();
		JPanel controlPanel = new JPanel();
		JPanel opControlPanel = new JPanel();
		inputView = new CalculatorInputView();
		antwoordView = new CalculatorView();
		
		getContentPane().add(controlPanel,BorderLayout.WEST);
		getContentPane().add(opControlPanel, BorderLayout.CENTER);
		getContentPane().add(viewPanel, BorderLayout.NORTH);
		controlPanel.add(controller, BorderLayout.CENTER);
		opControlPanel.add(opcontroller,BorderLayout.CENTER);
		viewPanel.add(inputView, BorderLayout.EAST);
		viewPanel.add(antwoordView, BorderLayout.WEST);
		getContentPane().add(opcontroller, BorderLayout.SOUTH);
		model.addActionListener(inputView);
		model.addActionListener(antwoordView);
	}

}
