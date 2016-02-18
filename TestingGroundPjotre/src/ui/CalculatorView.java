package ui;
import javax.swing.*;
import java.awt.event.*;
import multiformat.*;

/*
 * Deze klasse toont het resultaat van de user input in het scherm.
 */
public class CalculatorView extends JPanel implements ActionListener {
	private JLabel antwoordVeld = new JLabel();
	
	Calculator calc;

	public CalculatorView()
	{
		this.add(antwoordVeld);
		antwoordVeld.setText("<[dec, fixed, 0.0, 0.0]>" );
	}
	
	public void actionPerformed(ActionEvent e){
		calc = (Calculator) e.getSource();
		antwoordVeld.setText("<["+calc.getBase().getName()+","
                            + calc.getFormat().getName()+","
                            + calc.firstOperand() + ", "
                            + calc.secondOperand() + "] >");
	}
}