package ui;

import java.awt.Panel;
import java.awt.event.*;
import javax.swing.*;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import multiformat.Calculator;
import multiformat.FormatException;

public class CalculatorController extends Pane implements EventHandler<ActionEvent> {

	Calculator calc;

	private GridPane gridPane = new GridPane();
			
	private Button button0;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;
	private Button button6;
	private Button button7;
	private Button button8;
	private Button button9;
	
	private Button buttonMultiply;
	private Button buttonDivide;
	private Button buttonSubtract;
	private Button buttonSum;
		
	private Button buttonDot;
	private Button buttonOpposit;
		
	private Button buttonReset;
	private Button buttonResult;
	
	private ObservableList<Node> childrenList;
	
	public CalculatorController(Calculator c) {
		calc = c;
		
		gridPane = new GridPane();
				
		button0 = new Button("0");
		button1 = new Button("1");
		button2 = new Button("2");
		button3 = new Button("3");
		button4 = new Button("4");
		button5 = new Button("5");
		button6 = new Button("6");
		button7 = new Button("7");
		button8 = new Button("8");
		button9 = new Button("9");
		
		button9.setMaxWidth(50);
		
		gridPane.add(button0, 2, 1);
		gridPane.add(button1, 1, 1);
		gridPane.add(button2, 0, 1);
		gridPane.add(button3, 2, 2);
		gridPane.add(button4, 1, 2);
		gridPane.add(button5, 0, 2);
		gridPane.add(button6, 2, 3);
		gridPane.add(button7, 1, 3);
		gridPane.add(button8, 0, 3);
		gridPane.add(button9, 1, 4);
		
		buttonMultiply = new Button("x");
		buttonDivide = new Button("/");
		buttonSubtract = new Button("-");
		buttonSum = new Button("+");
		
		gridPane.add(buttonDivide, 3, 1);
		gridPane.add(buttonMultiply, 3, 2);
		gridPane.add(buttonSubtract, 3, 3);
		gridPane.add(buttonSum, 3, 4);
		
		buttonDot = new Button(".");
		buttonOpposit = new Button("+/-");
		
		gridPane.add(buttonDot, 2, 4);
		gridPane.add(buttonOpposit, 0, 4);
		
		buttonReset = new Button("Reset");
		buttonResult = new Button("=");
		
		gridPane.add(buttonReset, 1, 5);
		gridPane.add(buttonResult, 2, 5);
		
		childrenList = gridPane.getChildren();
		for(Node child : childrenList) {
			if(child instanceof Button) {
				((Button) child).setMaxWidth(50);
				((Button) child).setMinWidth(50);
				((Button) child).setOnAction(this);
			}
		}
		
		this.getChildren().add(gridPane);
	}

	public void handle(ActionEvent e) {		
		if(e.getSource() == button0) {
			calc.setCurrentNumber("0");
			System.out.println(calc.getCurrentNumber());
		}
		else if(e.getSource() == button1) {
			calc.setCurrentNumber("1");			
		}
		else if(e.getSource() == button2) {
			calc.setCurrentNumber("2");			
		}
		else if(e.getSource() == button3) {
			calc.setCurrentNumber("3");			
		}
		else if(e.getSource() == button4) {
			calc.setCurrentNumber("4");			
		}
		else if(e.getSource() == button5) {
			calc.setCurrentNumber("5");			
		}
		else if(e.getSource() == button6) {
			calc.setCurrentNumber("6");			
		}
		else if(e.getSource() == button7) {
			calc.setCurrentNumber("7");			
		}
		else if(e.getSource() == button8) {
			calc.setCurrentNumber("8");			
		}
		else if(e.getSource() == button9) {
			calc.setCurrentNumber("9");			
		}
		else if(e.getSource() == buttonOpposit) {
			calc.setCurrentNumber("-");		}
		else if(e.getSource() == buttonDivide) {
			calc.operatorClicked("/");		}
		else if(e.getSource() == buttonMultiply) {
			calc.operatorClicked("x");			
		}
		else if(e.getSource() == buttonSubtract) {
			calc.operatorClicked("-");			
		}
		else if(e.getSource() == buttonSum) {
			calc.operatorClicked("+");			
		}
		else if(e.getSource() == buttonResult) {
			calc.resultClicked();
		}
		else if(e.getSource() == buttonReset) {
			
		}
	}
}
