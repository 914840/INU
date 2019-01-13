
package controller;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		mainWindow();
	}
	
	public void mainWindow() {
		FXMLLoader loader = new FXMLLoader(
			Main.class.getResource("/view/MainWindowView.fxml")
			);
		try {
			AnchorPane pane = loader.load();
			primaryStage.setMinHeight(300.0);
			primaryStage.setMinWidth(400.0);
			Scene scene = new Scene(pane);
			MainWindowController mainWindowController = 
					loader.getController();
			mainWindowController.setMain(this ,this.primaryStage);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
