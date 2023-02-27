package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
			KatController.Cafe();
			Parent root = null;
			try {
				root = FXMLLoader.load(getClass().getResource("KatGoruntule.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			

			Scene scene = new Scene(root);
			primaryStage.setTitle("Fingirdek Aile Çay Bahçesi");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

	
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
