package ui;
import javax.swing.*;
import java.awt.event.*;
import multiformat.*;
public class CalculatorInputView extends JPanel implements ActionListener{
	private JLabel inputVeld = new JLabel();
	Calculator calc;

	public CalculatorInputView(){
		this.add(inputVeld);
	}
	public void actionPerformed(ActionEvent e){
		calc = (Calculator) e.getSource();
		inputVeld.setText(calc.getInputOperand());
	}
}
