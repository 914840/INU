package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Person;

public class MainWindowController {
	private Main main;
	private Stage primaryStage;
	
	private ObservableList<Person> personList = 
			FXCollections.observableArrayList();
	
	@FXML private TableView<Person> tableView;
	@FXML private TableColumn<Person, String> firstNameColumn;
	@FXML private TableColumn<Person,String> lastNameColumn;
	@FXML private TableColumn<Person,String> ageColumn;
	
	public void setMain(Main main, Stage primaryStage){
		this.main = main;
		this.primaryStage = primaryStage;
		setTable();
		tableView.setItems(personList);
	}
	
	public void initialize(){
		firstNameColumn.setCellValueFactory(
				new PropertyValueFactory<Person,String>("firstName"));
		lastNameColumn.setCellValueFactory(
				new PropertyValueFactory<Person,String>("lastName"));
		ageColumn.setCellValueFactory(
				new PropertyValueFactory<Person,String>("age"));
		
		tableView.getSelectionModel().selectedItemProperty().addListener(
				(ov, oldVal, newVal) -> 
				{
					System.out.println(newVal.getFirstName()+ " " + 
									newVal.getLastName()+ " " +
									newVal.getAge()+ " "
									);
				}
				);
	}
	
	private void setTable(){
		personList.add(new Person("10","Maciej"," Booo"));
		personList.add(new Person("20","Rysiek", "Z Klanu"));
		personList.add(new Person("30","Ala", "Bąk"));
		personList.add(new Person("33", "Jan", "Kot"));
	}
	
	@FXML
	public void closeStage(){
		primaryStage.close();
	}
	
	
}
