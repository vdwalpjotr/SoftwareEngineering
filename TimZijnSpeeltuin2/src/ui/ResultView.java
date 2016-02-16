package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import multiformat.Calculator;

import java.awt.Dimension;
    
public class ResultView extends FlowPane implements EventHandler<ActionEvent>
{
	private TextField resultField;
    Calculator calc;
    
	public ResultView()
	{
		 resultField = new TextField();
		 //resultField.setMinWidth(USE_COMPUTED_SIZE);
		 resultField.setAlignment(Pos.CENTER);
		 this.getChildren().add(resultField);
		 resultField.setDisable(true);
		 resultField.setStyle("-fx-opacity: 1.0; -fx-background-radius: 0;");
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
