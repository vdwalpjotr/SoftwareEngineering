package ui;
import javax.swing.*;
import java.awt.event.*;
import multiformat.*;

public class TotaalBerekeningenView extends JPanel implements ActionListener {
	private JLabel totaalBerekeningen = new JLabel();
	Calculator calc;
	
	public TotaalBerekeningenView(){
		this.add(totaalBerekeningen);
	}
	public void actionPerformed(ActionEvent e){
		calc = (Calculator) e.getSource();
		totaalBerekeningen.setText("Totaal aantal berekeningen: "+calc.getTotaalBerekening());
	}
}
