package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class questionnaireController extends Pane implements EventHandler<ActionEvent> {
	private Pane currentPane;
	
	private String[] questionList;
	private int[] resultList;
	
	private Button bStart;
	private Label l;
	private RadioButton rb1;
	private RadioButton rb2;
	private Button	b;
	private int currentQuestion;
	
	private int prefHeight;
	private int prefWidth;
	
	public questionnaireController(int prefHeight, int prefWidth) {
		this.prefHeight = prefHeight;
		this.prefWidth = prefWidth;
		
		currentQuestion = 0;
		questionList = getQuestionList();
		resultList = new int[8];
		
		this.setPrefSize(prefHeight, prefWidth);
		
		currentPane = getStartPane();
		this.getChildren().add(currentPane);
	}
	
	private FlowPane getStartPane() {
		FlowPane fp = new FlowPane();
		fp.setPrefSize(prefHeight, prefWidth);
		fp.setAlignment(Pos.CENTER);
		
		
		bStart = new Button("Start");
		fp.getChildren().add(bStart);
		bStart.setFocusTraversable(false);
		
		bStart.setOnAction(this);		
		
		return fp;
	}
	
	private VBox getQuestionPane() {
		VBox gp = new VBox();
		gp.setPrefSize(prefHeight, prefWidth);
		gp.setAlignment(Pos.CENTER);
		
		l = new Label();
		l.setFont(new Font("Times new Roman", 15));
		l.setText(questionList[currentQuestion]);
		
		HBox hb = new HBox();
		hb.setPrefWidth(prefWidth);
		hb.setAlignment(Pos.CENTER);
		
		rb1 = new RadioButton("Ja");
		rb2 = new RadioButton("Nee");
		b = new Button("Proceed");		

		b.setFocusTraversable(false);
		rb1.setFocusTraversable(false);
		rb2.setFocusTraversable(false);
		
		hb.getChildren().add(rb1);
		hb.getChildren().add(rb2);
		
		gp.getChildren().add(l);
		gp.getChildren().add(hb);
		gp.getChildren().add(b);
		
		rb1.setOnAction(this);
		rb2.setOnAction(this);
		b.setOnAction(this);
		
		HBox.setMargin(rb1, new Insets(5, 5, 5, 5));
		HBox.setMargin(rb2, new Insets(5, 5, 5, 5));
		
		return gp;
	}
	
	private FlowPane getLastPane() {
		FlowPane fp = new FlowPane(Orientation.VERTICAL);
		fp.setPrefSize(prefHeight, prefWidth);
		fp.setColumnHalignment(HPos.CENTER);
		fp.setAlignment(Pos.CENTER);
				
		Label lEnd = new Label("Thank you answering all the questions.");
		Label lResult = new Label();
		
		lEnd.setFont(new Font("Times new Roman", 15));
		lResult.setFont(new Font("Times new Roman", 20));
		lResult.setStyle("-fx-text-fill: red");		
		
		String result = "Result: ";
		for(int i : resultList) {
			result = result+i;
		}
		lResult.setText(result);
		
		fp.getChildren().add(lEnd);
		fp.getChildren().add(lResult);
		
		return fp;
	}
	
	private String[] getQuestionList() {
		String[] list = {
				"Vraag 1: Heeft uw auto een turbo?",
				"Vraag 2: Heeft uw auto EnginPower?",
				"Vraag 3: Heeft uw auto een sportbumber?",
				"Vraag 4: Heeft uw auto een sportring?",
				"Vraag 5: Heeft uw auto cruisecontroll?",
				"Vraag 6: Heeft uw auto ABS?",
				"Vraag 7: Heeft uw auto AC?",
				"Vraag 8: Is uw auto Metalic?"
				};
		return list;
	}
	
	private void nextQuestion() {
		if(currentQuestion == 7) {
			lastQuestion();
		}
		else {
			currentQuestion++;
			l.setText(questionList[currentQuestion]);
			//rb1.setSelected(false);
			//rb2.setSelected(false);
		}
	}
	
	private void lastQuestion() {
		currentPane = getLastPane();
		this.getChildren().clear();
		this.getChildren().add(currentPane);
	}
	
	private void throwAlert(String message) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
	}

	public void handle(ActionEvent e) {
		if(e.getSource() == bStart) {
			currentPane = getQuestionPane();
			this.getChildren().clear();
			this.getChildren().add(currentPane);
		}
		else if(e.getSource() == rb1 && rb2.isSelected()== true) {
			rb2.setSelected(false);
		}
		else if(e.getSource() == rb2 && rb1.isSelected()== true) {
			rb1.setSelected(false);
		}
		if(e.getSource() == b) {
			if(rb1.isSelected()) {
				resultList[currentQuestion] = 1;
				nextQuestion();
			}
			else if(rb2.isSelected()) {
				resultList[currentQuestion] = 0;
				nextQuestion();				
			}
			else {
				throwAlert("Please select an option.");
			}
		}
	}
	
}
