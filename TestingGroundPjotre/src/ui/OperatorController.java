package ui;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;
import multiformat.*;
/*
 * Deze klasse maakt en regelt de input van de getallen
 */
public class OperatorController extends JPanel implements ActionListener{
	private Calculator calc;
	private JButton plus = new JButton("+");
	private JButton min = new JButton("-");
	private JButton keer = new JButton("*");
	private JButton delen = new JButton("/");
	
	public OperatorController(Calculator c){
		calc = c;
		this.add(plus);
		plus.addActionListener(this);
		this.add(min);
		min.addActionListener(this);
		this.add(keer);
		keer.addActionListener(this);
		this.add(delen);
		delen.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == plus){
			calc.add();
		}
		if(e.getSource() == min){
			calc.subtract();
		}
		if(e.getSource()== keer){
			calc.multiply();
		}
		if(e.getSource()== delen){
			calc.divide();
		}
	}
}
