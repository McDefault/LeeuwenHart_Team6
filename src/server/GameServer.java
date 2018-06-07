package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Receives message objects from send clients and sends the message object to all registered
 * listen clients
 * 
 * Here the server object is the remote object itself (UnicastRemoteObject)
 * 
 * Usage: 
 * 	java -cp bin ChatServer
 * 	vanuit project directory RMIChat
 * 
 * @author Koen Warner, 2016
 *
 */
public class GameServer extends UnicastRemoteObject implements GameServerInterface {

	private static final long serialVersionUID = 1L;
	// A list of registered listener clients
	private ArrayList<TurnListenInterface> turnListeners = new ArrayList<TurnListenInterface>();
	private ArrayList<Player> players = new ArrayList<Player>();
	// Port where RMI Registry listens
	private int port = 1099;
	
	public GameServer() throws RemoteException {

		System.out.println("Server: GameServer v2.0 starting up...");

		try {
			// Connect to RMI Registry
			LocateRegistry.createRegistry(port);
			System.out.println("Server: connected to RMI registry.");
			// Register this server object in the RMI Registry
			Naming.rebind("GameService", this);
			System.out.println("Server: server registered as \'GameService\' in RMI registry.");
		} catch (MalformedURLException mfue) {
			System.out.println(mfue);
		} catch (RemoteException re){
			System.out.println(re);
		}
	}
	
	/**
	 *	Start up server
	 */
	public static void main(String args[]) throws Exception {
		GameServer gameServer = new GameServer();
		System.out.println("Server: Server running.");
//		Game game = new Game();
		System.out.println("Server: Creating new board. Waiting for players to connect.");
		//wait for all ready.
		
	}
	
	/**
	 *	Receive message from TurnSend object and resent to all registered TurnListen objects
	 */
	public synchronized void notifyObservers(Player player, Turn turn) throws RemoteException {
		System.out.println("Server: notifying all listening clients");
	    for (TurnListenInterface client : turnListeners) {
	    	client.update(player, turn);
	    }
	}
	
	

	/**
	 *	Register a ChatListen object as an observer
	 */
	public synchronized void registerObserver(TurnListenInterface listener) throws RemoteException {
		System.out.println("Server: adding listener");
		this.turnListeners.add(listener);
		System.out.println("Server: listener added");
	}


	/**
	 *	Unregister a ChatLisApplicatie model en Implementatiemodelten object as an observer
	 */
	public synchronized void unregisterObserver(TurnListenInterface listener) throws RemoteException {
		System.out.println("Server: removinglistener");
		this.turnListeners.remove(listener);
		System.out.println("Server: listener removed");
	}

	/**
	 *	Receive turn from client and notify all listeners
	 */
	public synchronized void receiveTurn(Player player, Turn turn){
		System.out.println("GameServer: received turn:");
		// notify listeners.
		try {
			this.notifyObservers(player, turn);

		} catch (RemoteException re) {
			System.out.println("Server: Failed to notify listners");
		}
	}
}
