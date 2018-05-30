package server;

import java.util.ArrayList;

public class Game {
	Board board;
	ArrayList<Player> players;
	Deck deck;
	
	public Game() {
		board = new Board();
		deck = new Deck();
	}
	
	public void start(){
		
	}
	
	public void end() {
		
	}
	
	public Board generateBoard() {
		return board;
		
	}
	

}
