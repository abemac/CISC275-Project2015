package tests;

import junit.framework.TestCase;
import stubs.OverfishingGame;


/**
 * Tests all subclasses of Game
 * @author abraham
 *
 */
public class GameTests extends TestCase{
	
	
	
	
	
	//Overfishing game tests
	public void testStartStop(){
		OverfishingGame game = new OverfishingGame();
		assertEquals(game.isRunning(),false);
		game.start();
		assertEquals(game.isRunning(), true);
		game.stop();
		assertEquals(game.isRunning(),false);
		
		
		
		
	}
	
	
	
}
