package client;

import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import server.Player;

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
//		primaryStage.show();
		
		//create name
		String playerName;
		Player player;
		PlayerSend sender;
		playerName = "Hardcoded";
		
		//make player object
		player = new Player(playerName);
		
		try {
		
		//create connection
		sender = new PlayerSend();
		sender.sendPlayerObject(player);
		
	} catch (RemoteException re){
		System.out.println("An exception occured");
		re.printStackTrace();
	} catch (Exception e){
		System.out.println("An exception occured");
		e.printStackTrace();
	}
		
	}
}
