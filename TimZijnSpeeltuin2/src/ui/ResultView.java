package ui;
import javax.swing.*;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import multiformat.Calculator;

import java.awt.Dimension;
import java.awt.event.ActionListener;
    
public class ResultView extends FlowPane implements EventHandler<ActionEvent>
{
	private TextField resultField;
    Calculator calc;
    
	public ResultView()
	{
		 resultField = new TextField();
		 resultField.setMinWidth(Double.MAX_VALUE);
		 this.getChildren().add(resultField);
	}
	
	public void handle(ActionEvent e)
	{
	    calc = (Calculator) e.getSource();
	    resultField.setText(calc.getPrintText());
	}
	
	public Dimension getPreferredSize()
	{
	    return new Dimension(50,50);
	}
}
