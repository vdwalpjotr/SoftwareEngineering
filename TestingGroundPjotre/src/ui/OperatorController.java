package ui;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.event.*;
import multiformat.*;
/*
 * Deze klasse maakt en regelt de input van de getallen
 */
public class OperatorController extends JPanel implements ActionListener{
	private Calculator calc;
	//Operatoren
	private JButton plus = new JButton("+");
	private JButton min = new JButton("-");
	private JButton keer = new JButton("*");
	private JButton delen = new JButton("/");
	//talstel modi
	private JButton decimal = new JButton("Dec");
	private JButton binairy = new JButton("Bin");
	private JButton hexadecimal = new JButton("hex");
	private JButton octal = new JButton("oct");
	public OperatorController(Calculator c){
		this.setLayout(new GridLayout(4,2));
		calc = c;
		this.add(plus);
		plus.addActionListener(this);
		this.add(min);
		min.addActionListener(this);
		this.add(keer);
		keer.addActionListener(this);
		this.add(delen);
		delen.addActionListener(this);
		this.add(decimal);
		decimal.addActionListener(this);
		this.add(binairy);
		binairy.addActionListener(this);
		this.add(octal);
		octal.addActionListener(this);
		this.add(hexadecimal);
		hexadecimal.addActionListener(this);
		
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
		if(e.getSource() == decimal){
			calc.setBase(new DecimalBase());
		}
		if(e.getSource() == binairy){
			calc.setBase(new BinaryBase());
		}
		if(e.getSource() == hexadecimal){
			calc.setBase(new HexBase());
		}
		if(e.getSource() == octal){
			calc.setBase(new OctalBase());
		}
	}
}
