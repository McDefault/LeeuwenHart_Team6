package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TurnListenInterface extends Remote {

	// Registry ChatClient with server, to be able to receive message from the server
	void update(Turn turn)  throws RemoteException;
}