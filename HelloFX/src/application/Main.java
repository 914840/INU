package application;
	
import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Label lable = new Label("Hello World");
			//root.setCenter(lable);
			
			//==================================================================
			Button but = new Button(" klik ");
			but.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					System.out.println("Klik");
				}
			});
			//root.setBottom(but);
			//===================================================================
			Label label1 = new Label("nr 1");
			Label label2 = new Label("nr 2 ");
			VBox left_vbox = new VBox(10);
			left_vbox.getChildren().add(label1);
			left_vbox.getChildren().add(label2);
			root.setLeft(left_vbox);
			//===================================================================
			TextField text1 = new TextField();
			text1.getStyleClass().add("my-field");
			text1.setLayoutX(0);
			text1.setLayoutY(0);
			
			TextField text2 = new TextField();
			text2.getStyleClass().add("my-field");
			text2.setLayoutX(0);
			text2.setLayoutY(30);
			
			lable.setLayoutY(-30);
			
//			Image test_image = new Image(
//					"http://galera.ii.pw.edu.pl/~zsz/javafx/img/lenna256px.png"
//					);
			
			Image test_image = new Image(
					getClass().getResourceAsStream("lenna256px.png")
					);
			ImageView test_image_view = new ImageView (test_image);
			
			
			Group center_group = new Group();
			center_group.getChildren().add(test_image_view);
			center_group.getChildren().add(text1);
			center_group.getChildren().add(text2);
			center_group.getChildren().add(lable);
			root.setCenter(center_group);
			//====================================================================
			RadioButton r1 = new RadioButton("1");
			RadioButton r2 = new RadioButton("2");
			r1.setUserData("przycisk 1");
			r2.setUserData("przycisk 2");
			ToggleGroup tgroup = new ToggleGroup();
			r1.setToggleGroup(tgroup);
			r2.setToggleGroup(tgroup);
			
			tgroup.selectedToggleProperty().addListener(
					(ov, oldToggled, newToggle ) -> {
						System.out.println(newToggle.getUserData().toString());
					}
					);
			HBox bottom_hbox = new HBox(10);
			bottom_hbox.getChildren().addAll(r1,r2);
			
			root.setBottom(bottom_hbox);
			//====================================================================
			HBox top_hbox = new HBox(10);
			root.setTop(top_hbox);
			Button button1 = new Button("klik 1");
			button1.setId("button1");
			button1.setOnAction(
					event -> {
						System.out.println(" znów mnie ktoś kliknął ");
						
					if (tgroup.getSelectedToggle() != null ){
						System.out.println(" Radio Button wciśnięty");
					}
					else
						System.out.println(" Radio button NIE Wciśnięty");
						//r1.isSelected();
						
					if(text1.getText().matches("[JGBDjgbd][AKDSakds][0-2][0-9][ZLzl][0-9][0-9][ABCabc]") )
					{
		
						String rok_text = text1.getText().substring(2, 4);
						int i = Integer.parseInt(rok_text);
						
						if (i > 0 && i < 21){
							System.out.println("Dane Poprawne");
						}
						else
							System.out.println("Dane nie poprawne");
						
					}
					else 
						System.out.println("Dane nie poprawne.");
					}
					);
			
			Button button2 = new Button();
			button2.setText("NR.2");
			button2.setOnAction(
					event -> {
						System.out.println(" klik top - p2");
						Alert alert = new Alert(AlertType.CONFIRMATION," Kliknąłeś button 2 w panelu TOP ");
						//alert.show();
						Optional<ButtonType> result = alert.showAndWait();
						if (result.isPresent() && result.get() == ButtonType.OK)
							System.out.println("Wciśnięto OK w alercie");
					}
					);
		
			Button button3 = new Button();
			button3.setOnAction(
					event -> {
						Stage stage_dlg = new Stage();
						stage_dlg.setTitle("Okno Dialogowe");
						
						BorderPane root_dlg = new BorderPane();
						stage_dlg.setScene(new Scene(root_dlg));
						
						Label msg = new Label("To jest okno dialogowe");
						root_dlg.setCenter(msg);
						
						stage_dlg.initOwner(primaryStage);
						stage_dlg.initModality(Modality.WINDOW_MODAL);
						stage_dlg.show();
					}
					);
			
			
			top_hbox.getChildren().addAll(button1, button2, button3);
			
			primaryStage.setTitle("Nowe okno - hello World");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
