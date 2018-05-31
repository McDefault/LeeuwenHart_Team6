package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PlayerListenInterface extends Remote {

	// Registry GameClient with server, to be able to receive message from the server
	void update(Player player)  throws RemoteException;
	
}
