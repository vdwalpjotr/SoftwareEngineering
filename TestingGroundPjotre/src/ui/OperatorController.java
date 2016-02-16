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
	private JButton fixedPoint = new JButton("fixP");
	private JButton floatingPoint = new JButton("float");
	private JButton rationalFormat = new JButton("rat");
	private JButton delete = new JButton("del");
	public OperatorController(Calculator c){
		this.setLayout(new GridLayout(7,2));
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
		this.add(fixedPoint);
		fixedPoint.addActionListener(this);
		this.add(floatingPoint);
		floatingPoint.addActionListener(this);
		this.add(rationalFormat);
		rationalFormat.addActionListener(this);
		this.add(delete);
		delete.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == plus){
			calc.addCalc();
			calc.add();
			
		}
		if(e.getSource() == min){
			calc.addCalc();
			calc.subtract();
			
		}
		if(e.getSource()== keer){
			calc.addCalc();
			calc.multiply();
			
		}
		if(e.getSource()== delen){
			calc.divide();
			calc.addCalc();
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
		if(e.getSource() == fixedPoint){
			calc.setFormat(new FixedPointFormat());
		}
		if(e.getSource()== floatingPoint){
			calc.setFormat(new FloatingPointFormat());
		}
		if(e.getSource()== rationalFormat){
			calc.setFormat(new RationalFormat());
		}
		if(e.getSource() == delete){
			calc.delete();
		}
	}
}
