package games;

import java.awt.Graphics;
import java.util.ArrayList;

import characters.Fish;
import enemies.Enemy;

/*
 * The first game played.  Demonstrates the effects of over-fishing.  Very educational.
 */

/**
 * main control class for the Overfishing game. Most functionality is implemented in the superclass.
 * @author abraham
 *
 */
public class OverfishingGame extends Game {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6483515886892518982L;
	private int numFishLost;			//how many fish have been captured
	private int distance;				// how far the player reached in the level
	private ArrayList<Fish> school;		// an array list of fish that the player guides through the level
	private ArrayList<Enemy> enemies;	// an array list of Enemy that try to capture the fish
	
	/**
	 * Constructor for the overfishing game. calls the super constructor
	 */
	public OverfishingGame(){	
		super();
	}
	
	

	/**
	 * gets called at 60Hz to generate changes to the game
	 */
	@Override
	public void onTick() {				
		

		randomlyMoveNetsAndHooks();
		checkAndRemoveFish();
		
	}
	
	public void render(Graphics g){
		
	}
	/**
	 * changes enemy position in random directions and distances
	 */
	private void randomlyMoveNetsAndHooks(){};	
	
	/**
	 * checks for a collision between fish and enemy and adds 1 to numFishLost if true
	 */
	private void checkAndRemoveFish(){}


	/**
	 * 
	 * @return the number of fish lost
	 */
	public int getNumFishLost() {
		return numFishLost;
	}


	/**
	 * 
	 * @return the distance traveled
	 */
	public int getDistance() {
		return distance;
	}


	/**
	 * 
	 * @return the school of fish being controlled by the user
	 */
	public ArrayList<Fish> getSchoolofFish() {
		return school;
	}


	/**
	 * 
	 * @return all the enemies present in the game
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	};		
	
	
	public boolean isFinished(){
		return true;
	}
	
	
	

}
