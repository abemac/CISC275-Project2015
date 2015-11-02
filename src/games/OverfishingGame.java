package games;

import java.util.ArrayList;

import characters.Fish;
import enemies.Enemy;

/*
 * The first game played.  Demonstrates the effects of over-fishing.  Very educational.
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
	
	// OverfishingGame constructor
	public OverfishingGame(){	
		
	} //OverfishingGame()
	
	

	// generates changes to the game
	@Override
	public void onTick() {				
		

		randomlyMoveNetsAndHooks();
		checkAndRemoveFish();
		
	}
	
	// changes enemy position in random directions and distances
	private void randomlyMoveNetsAndHooks(){};	
	
	// checks for a collision between fish and enemy and adds 1 to numFishLost if true
	private void checkAndRemoveFish(){}



	public int getNumFishLost() {
		return numFishLost;
	}



	public int getDistance() {
		return distance;
	}



	public ArrayList<Fish> getSchoolofFish() {
		return school;
	}



	public ArrayList<Enemy> getEnemies() {
		return enemies;
	};		
	
	
	
	

}
