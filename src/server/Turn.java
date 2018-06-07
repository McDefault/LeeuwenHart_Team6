package server;

import java.io.Serializable;

public class Turn implements Serializable {
	
	private static final long serialVersionUID = 1L;
	public Player player;
	public Action actions;
	
	public Turn(Player player){
		setPlayer(player);
	}
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Action getActions() {
		return actions;
	}
	public void setActions(Action actions) {
		this.actions = actions;
	}
}
