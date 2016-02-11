package ui;
import javax.swing.*;

import multiformat.Calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
    
public class ResultView extends JPanel implements ActionListener
{
	private JTextField resultField = new JTextField();
    Calculator c;
    
	public ResultView()
	{
	    this.setLayout(new FlowLayout());
	    this.add(resultField);
	}
	
	public void actionPerformed( ActionEvent e )
	{
	    c = (Calculator) e.getSource();
	    resultField.setText(""+c.getCalculations());
	}
	
	public Dimension getPreferredSize()
	{
	    return new Dimension(50,50);
	} 
}
