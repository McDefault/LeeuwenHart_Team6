package client;

import java.rmi.RemoteException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import server.GameServerInterface;
import server.Player;
import server.Turn;

public class Login extends Application {
	public static void main(String[] args) {
		// launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		AnchorPane thePane = FXMLLoader.load(Login.class.getResource("Login.fxml"));

		primaryStage.setMaximized(true);
		primaryStage.setScene(new Scene(thePane));
		// primaryStage.show();

		// create name
		String playerName;
		Player player;
		TurnSend sender;
		Turn turn;

		String host = "127.0.0.1";

		// TODO create connection to server once instead of multiple times (DRY
		// principle)
		// create connection with server
		// GameServerInterface server = (GameServerInterface) new
		// ServerConnection().getConnection();
		if (args.length == 0) {
			playerName = "Hardcoded";

		} else {
			playerName = args[0];
		}

		// make player object
		player = new Player(playerName);
		turn = new Turn(player);

		try {
			// create connection
			sender = new TurnSend(host);
			// send turn object to all listeners
			sender.sendTurnObject(player, turn);

		} catch (RemoteException re) {
			System.out.println("An exception occured");
			re.printStackTrace();
		} catch (Exception e) {
			System.out.println("An exception occured");
			e.printStackTrace();
		}

		// create lister to receive updates
		try {
			new TurnListen(host);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
