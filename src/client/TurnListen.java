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
	public String name;
	private static final long serialVersionUID = 1L;
//
//	protected TurnListen() throws RemoteException {
//		super();
//		String serverAddress;
//		serverAddress = "127.0.0.1";
//
//		new TurnListen(serverAddress);
//		System.out.println("ChatListen: ready to receive messages from server at " + serverAddress);
//	}

	protected TurnListen(String serverAddress) throws RemoteException {
		super();
		System.out.println("TurnListen: Game listener v2.0 starting up...");
		System.out.println("TurnListen: looking up server in RMI registry.");
		GameServerInterface server = null;

		try {
			
			server = (GameServerInterface) new ServerConnection().getConnection();
//			server = (GameServerInterface) Naming.lookup("//" + serverAddress + "/GameService");
		} catch (NotBoundException nbe) {
			System.out.println(nbe);
		} catch (MalformedURLException mfue) {
			System.out.println(mfue);
		}

		System.out.println("TurnListen: register ourself with server (for notification of new turns).");
		server.registerObserver(this);

		System.out.println("TurnListen: ready to receive messages from server at " + serverAddress);
	}

	/**
	 * Get notified by server when new turn arrives at server
	 */

	@Override
	public void update(server.Player player, server.Turn turn) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("TurnListen: " + turn.getPlayer().getName() + " made a turn.");
//		System.out.println("TurnListen: someone made a turn.");
	}

	@Override
	public void setNaam(String string) throws RemoteException {
		name = string;
		
	}
}
