package games;

import java.util.ArrayList;

import enemies.TheHuman;
import enemies.Trash;

public class CrabSaveGame extends Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1609844265788718695L;
	private int numTrashPickedup;
	private ArrayList<Trash> trash;
	private TheHuman theHuman;
	
	
	public CrabSaveGame(){
		
	}

	
	
	@Override
	public void onTick() {
		moveHuman();
		removeTrash();
		
	}
	
	
	
	public void moveHuman(){};
	public void removeTrash(){}



	public int getNumTrashPickedup() {
		return numTrashPickedup;
	}



	public ArrayList<Trash> getTrash() {
		return trash;
	}



	public TheHuman getTheHuman() {
		return theHuman;
	};
	
	
	
	
}
