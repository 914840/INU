package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Person;

public class MainWindowController {
	private Person person;
	
	private Main main;
	
	@FXML private Button button;
	@FXML private TextField field;
	@FXML private Label label;
	
	public void setMain(Main main){
		this.main = main;
		person = new Person("10", "Charlie", "Brown");
	}
	
	
	@FXML
	public void handleButton(){
		System.out.println("cos sie dzieje");
		label.setText(field.getText());
		person.setFirstName(field.getText());
		field.clear();
		
	}
}
