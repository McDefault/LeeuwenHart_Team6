package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import server.GameServerInterface;
import server.Player;
import server.Turn;

public class PlayerSend {
	
	private GameServerInterface server;
	
	public PlayerSend() throws RemoteException, MalformedURLException, NotBoundException  {
		// Get reference to remote object, i.e. the server object (which will consume the message)
		this.server = (GameServerInterface) new ServerConnection().getConnection();
		System.out.println("PlayerSend: looked up server in RMI Registry; \'PlayerService\'");
	}
	void sendPlayerObject(Player player) throws RemoteException {
		this.server.receivePlayer(player);
		System.out.println("PlayerSend: sending player done.");
	}
}
