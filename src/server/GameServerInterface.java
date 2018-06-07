package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameServerInterface extends Remote {
	
    // send an message object to all other clients
    void notifyObservers(Player player, Turn turn) throws RemoteException;
    
    // registerObserver a listener (listener client)
    void registerObserver(TurnListenInterface listen) throws RemoteException;
	// unregisterObserver a listener  (listener client)
	void unregisterObserver(TurnListenInterface listen) throws RemoteException;
	// receive player from a client
//	void receivePlayer(Player player) throws RemoteException;
	// receive turn from a client
	void receiveTurn(Player player, Turn turn) throws RemoteException;
}
