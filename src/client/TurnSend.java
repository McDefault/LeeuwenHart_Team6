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
	 * args[0] is server address or ip
	 * args[1] is user name
	 * args[1] is message to send
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("ChatSend: Chat sender v2.0 starting up...");
		
		TurnSend sender; 
//		String host;
//		String username;
//		String message;
		
		try {
			
//			if ( args.length == 0 ){
//				host = "127.0.0.1";	
//				username = "Unknown";
//				message = "no message";
//				
//			} else {
//				host = args[0];
//				username = args[1];
//				message = args[2];
//			}
			
			System.out.println("TurnSend: Create turn send object");
			sender = new TurnSend();
			//TODO do something with connection
			//dummy player object
			Player player = new Player("kees");
			Turn turn = new Turn();
			sender.sendTurnObject(player, turn);

		} catch (Exception e){
			System.out.println("An exception occured");
			e.printStackTrace();
		}
	}
	
	/**
	 * Constructor
	 * 
	 * Create remote reference to server object.
	 */
	
	public TurnSend() throws RemoteException, MalformedURLException, NotBoundException  {
		// Get reference to remote object, i.e. the server object (which will consume the message)
		this.server = (GameServerInterface) new ServerConnection().getConnection();
		System.out.println("TurnSend: looked up server in RMI Registry; \'TurnService\'");
	}

	/**
	 * Send turn object to server
	 */
	
	private void sendTurnObject(Player player, Turn turn) throws RemoteException {
		
		Turn turnObj = turn;
//		this.server.receiveMessage(player, turn );
		System.out.println("TurnSend: send turn done.");
	}
	

}
