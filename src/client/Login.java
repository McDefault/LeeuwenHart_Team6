package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Login extends Application{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane thePane = FXMLLoader.load(Login.class.getResource("Login.fxml"));
		
		primaryStage.setMaximized(true);
		primaryStage.setScene(new Scene(thePane));
		primaryStage.show();
	}
}
