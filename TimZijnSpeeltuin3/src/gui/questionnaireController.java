package gui;

import classifier.Feature;
import classifier.FileReader;
import classifier.Item;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class questionnaireController extends Pane implements EventHandler<ActionEvent> {
	private FileReader fr;
	
	private Pane currentPane;
	
	private String[] questionList;
	private int[] resultList;
	
	private Button bStart;
	private Label l;
	private RadioButton rb1;
	private RadioButton rb2;
	private Button	b;
	private int currentQuestion;
	
	public questionnaireController(FileReader fr) {
		this.fr = fr;
		currentQuestion = 0;
		questionList = getQuestionList();
		resultList = new int[8];
		currentPane = getStartPane();
		this.getChildren().add(currentPane);
	}
	
	private FlowPane getStartPane() {
		FlowPane fp = new FlowPane();
		
		bStart = new Button("Start");
		fp.getChildren().add(bStart);
		
		bStart.setOnAction(this);
		
		return fp;
	}
	
	private GridPane getQuestionPane() {
		GridPane gp = new GridPane();
		l = new Label();
		l.setText(questionList[currentQuestion]);
		rb1 = new RadioButton("Ja");
		rb2 = new RadioButton("Nee");
		b = new Button("Proceed");
		
		gp.add(l, 0,0,2,1);
		gp.add(rb1, 0,1);
		gp.add(rb2, 1,1);
		gp.add(b, 0,2);
		
		rb1.setOnAction(this);
		rb2.setOnAction(this);
		b.setOnAction(this);
		
		return gp;
	}
	
	private FlowPane getLastPane() {
		FlowPane fp = new FlowPane();
		fp.setPrefWidth(250);
		
		Label lEnd = new Label("Thank you answering all the questions.");
		Label lResult = new Label();
		
		Feature[] ft = fr.fillFeatureList(resultList);
		/*
		for(Feature f : ft) {
			
			System.out.println(f.toString());
		}
		*/
		
		Item item = new Item("JeMoeder", ft);
		//System.out.println(fr.getCategory(item));
		/*
		String result = "Result: ";
		for(int i : resultList) {
			result = result+i;
		}
		*/
		
		lResult.setText(fr.getCategory(item));
		
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
			System.out.println("disarmed");
		}
		else if(e.getSource() == rb2 && rb1.isSelected()== true) {
			rb1.setSelected(false);
			System.out.println("disarmed");
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
