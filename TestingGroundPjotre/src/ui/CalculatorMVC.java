package ui;
import multiformat.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.JApplet;
import javax.swing.JPanel;
/**
 * Het MVC voor de Calculator, hier krijgen de controllers hun model mee en wordt de app gevormd.
 * @author Peter
 *
 */
public class CalculatorMVC extends JApplet {
	Calculator model; // het model
	
	CalculatorView antwoordView; // view
	CalculatorInputView inputView; //view
	TotaalBerekeningenView totaalBerekeningView; // view
	CalculatorController controller; //controller voor getalleninput
	OperatorController opcontroller; //controller voor operatorinput
	
	public void init(){
		resize(260, 220);
		
		model = new Calculator();
	
		controller = new CalculatorController(model);
		opcontroller = new OperatorController(model);
		JPanel viewPanel = new JPanel();
		viewPanel.setPreferredSize(new Dimension(260, 35));
		viewPanel.setBackground(Color.white);
		JPanel controlPanel = new JPanel();
		JPanel opControlPanel = new JPanel();
		inputView = new CalculatorInputView();
		antwoordView = new CalculatorView();
		totaalBerekeningView = new TotaalBerekeningenView();
		
		getContentPane().add(controlPanel,BorderLayout.WEST);
		getContentPane().add(viewPanel, BorderLayout.NORTH);
		controlPanel.add(controller, BorderLayout.WEST);
		controlPanel.add(opcontroller, BorderLayout.EAST);
		viewPanel.add(inputView, BorderLayout.EAST);
		viewPanel.add(antwoordView, BorderLayout.WEST);
		getContentPane().add(totaalBerekeningView, BorderLayout.SOUTH);
		model.addActionListener(inputView);
		model.addActionListener(antwoordView);
		model.addActionListener(totaalBerekeningView);
		
	}

}
