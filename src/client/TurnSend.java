package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import server.Turn;
import server.GameServerInterface;
import server.Player;


/**
 * 
 * Send a message to the server.
 * 
 * Sending a serializable object
 * Usage: 
 * 	java ChatSend [host] [username] [nessage]
 * 	vanuit project directory RMIChat
 * 	host is optioneel: default is "127.0.0.1"
 * 	username is optioneel: default is "Unknown"
 * 	message is optioneel: default is "no message"
 * 
 * @author Koen Warner, 2016
 */
public class TurnSend {
	
	private GameServerInterface server;

	/**
	 * Constructor
	 * 
	 * Create remote reference to server object.
	 */
	
	public TurnSend(String host) throws RemoteException, MalformedURLException, NotBoundException  {
		// Get reference to remote object, i.e. the server object (which will consume the message)
		this.server = (GameServerInterface) new ServerConnection().getConnection();
//		this.server = (GameServerInterface) Naming.lookup("//" + host +"/GameService");
		System.out.println("TurnSend: looked up server in RMI Registry; \'GameService\'");
	}

	/**
	 * Send turn object to server
	 */
	
	void sendTurnObject(Player player, Turn turn) throws RemoteException {
		
//		Turn turnObj = turn;
		this.server.receiveTurn(player, turn );
		System.out.println("TurnSend: send turn done.");
	}
	

}
