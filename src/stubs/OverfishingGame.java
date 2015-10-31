package stubs;

import java.util.ArrayList;

/*
 * The first game played.  Demonstrates the effects of over-fishing.  Very educational.
 */

public class OverfishingGame extends Game {

	
	private int numFishLost;			//how many fish have been captured
	private int distance;				// how far the player reached in the level
	private ArrayList<Fish> school;		// an array list of fish that the player guides through the level
	private ArrayList<Enemy> enemies;	// an array list of Enemy that try to capture the fish
	
	
	public OverfishingGame(){			// OverfishingGame constructor
		
	} //OverfishingGame()


	@Override
	public void onTick() {				// generates changes to the game
		

		randomlyMoveNetsAndHooks();
		checkAndRemoveFish();
		
	}
	
	
	private void randomlyMoveNetsAndHooks(){};	// changes enemy position in random directions and distances
	private void checkAndRemoveFish(){};		// checks for a collision between fish and enemy and adds 1 to numFishLost if true
	
	

}
