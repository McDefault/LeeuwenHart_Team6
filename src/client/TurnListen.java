package client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import server.GameServerInterface;
import server.Player;
import server.Turn;
import server.TurnListenInterface;

public class TurnListen extends UnicastRemoteObject implements TurnListenInterface {

	protected TurnListen() throws RemoteException {
		super();
		String serverAddress;
		serverAddress = "127.0.0.1";
		
		new TurnListen(serverAddress);
		System.out.println("ChatListen: ready to receive messages from server at " + serverAddress);
	}
	
	/**
	 * Get notified by server when new turn arrives at server
	 */
	
	@Override
	public void update(Turn turn) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("TurnListen: someone made a turn.");
	}
	
	private static final long serialVersionUID = 1L;

	protected TurnListen(String serverAddress) throws RemoteException {
		super();
		System.out.println("TurnListen: Game listener v2.0 starting up...");
		GameServerInterface server = null;

		try {
			System.out.println("TurnListen: looking up ChatServer in RMI Registry...");
			server = (GameServerInterface) Naming.lookup("//" + serverAddress + "/ChatService");
		} catch (NotBoundException nbe){
			System.out.println(nbe);
		} catch (MalformedURLException mfue){
			System.out.println(mfue);
		}

		System.out.println("TurnListen: register ourself with server (for notification of new messages).");
		server.registerObserver( this);

	}

/**
 * 
 * args[0] is servername or ip address
 * 
 */
	public static void main(String[] args) throws Exception {

		System.out.println("ChatListen: looking up server in RMI registry.");
		String serverAddress;
		
		if (args.length >= 1) {
			serverAddress = args[0].toString();
		} else { // no cmd line args given, use default server address
			serverAddress = "127.0.0.1";
		}
		serverAddress = "127.0.0.1";
		new TurnListen(serverAddress);
		System.out.println("ChatListen: ready to receive messages from server at " + serverAddress);
	}

	@Override
	public void update(Player player) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("PlayerListen: joined.");
	}





}
