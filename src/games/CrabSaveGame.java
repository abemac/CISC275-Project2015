package games;

import java.awt.Graphics2D;
import java.util.ArrayList;

import enemies.TheHuman;
import enemies.Trash;

/**
 * Models the CrabSaveGame
 * @author abraham
 *
 */
public class CrabSaveGame extends Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1609844265788718695L;
	private int numTrashPickedup;
	private ArrayList<Trash> trash;
	private TheHuman theHuman;
	
	/**
	 * calls the super constructor
	 */
	public CrabSaveGame(){
		super();
	}

	
	/**
	 * gets called 60 times/sec and handles updates to the game
	 */
	@Override
	public void onTick() {
		moveHuman();
		
	}
	
	public void render(Graphics2D g){
		
	}
	
	
	/**
	 * moves the Human
	 */
	public void moveHuman(){};
	/**
	 * removes Trash
	 * @param t the trash to remove
	 */
	public void removeTrash(Trash t){}


	/**
	 * 
	 * @return the number of Trash the user has cleaned up
	 */
	public int getNumTrashPickedup() {
		return numTrashPickedup;
	}


	/**
	 * 
	 * @return the arrayList of all current Trash objects
	 */
	public ArrayList<Trash> getTrash() {
		return trash;
	}


	/**
	 * 
	 * @return the Human in the game
	 */
	public TheHuman getTheHuman() {
		return theHuman;
	};
	
	
	
	public boolean isFinished(){
		return true;
	}
	
}
