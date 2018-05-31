package server;

import java.io.Serializable;

public class Player implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean ready;
	private String name;
	
	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
