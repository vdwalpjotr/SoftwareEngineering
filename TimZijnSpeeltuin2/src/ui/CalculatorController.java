package ui;

import java.awt.event.*;
import javax.swing.*;
import multiformat.Calculator;
import multiformat.FormatException;

public class CalculatorController extends JPanel implements ActionListener {

	private Calculator calc;
	
	private JButton calculate = new JButton("=");
	
	public CalculatorController(Calculator c) {
		calc = c;
		try {
			calc.addOperand("2.0");
			calc.addOperand("4.0");
		} catch (FormatException e) {
			e.printStackTrace();
		}
		
		this.add(calculate);
		calculate.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == calculate) {
			calc.increaseCalculations();
			calc.add();
			System.out.println(calc.secondOperand());
			
		}
	}
}
