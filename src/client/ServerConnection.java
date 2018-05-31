package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import server.GameServerInterface;

public class ServerConnection {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameServerInterface server;

	ServerConnection() throws RemoteException, MalformedURLException, NotBoundException {
		
		String host = "127.0.0.1";	
		this.server = (GameServerInterface) Naming.lookup("//" + host +"/GameService");
		// Get reference to remote object, i.e. the server object (which will consume the message)
//		System.out.println("ChatSend: looked up server in RMI Registry; \'ChatService\'");
	}
	
	GameServerInterface getConnection() {
		return this.server;
	}

}
