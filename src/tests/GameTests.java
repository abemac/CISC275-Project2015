package tests;

import games.CrabSaveGame;
import games.OverfishingGame;
import games.PollutionGame;
import junit.framework.TestCase;

/**
 * Tests all subclasses of Game
 * @author abraham
 *
 */
public class GameTests extends TestCase{
	
	/**
	 * tests the start and stopping mechanism of the Game class, and other aspects specifically related to the
	 * Overfishing Game.
	 */
	public void testStartStop(){
		OverfishingGame game = new OverfishingGame();//this test is general and is sufficiant for all Games
		assertEquals(game.isRunning(),false);
		game.start();
		assertEquals(game.isRunning(), true);
		game.stop();
		assertEquals(game.isRunning(),false);
		
		
	}
	/**
	 * makes sure that the tick method accurately updates the position of elements in the game
	 */
	public void testOverfishing(){
		OverfishingGame game = new OverfishingGame();
		double x = game.getSchoolofFish().get(0).getX();
		game.onTick();
		assertTrue(x!=game.getSchoolofFish().get(0).getX());
	}
	
	
	/**
	 * tests the on tick method of the CrabSaveGame
	 */
	
	public void testCrabSave(){
		CrabSaveGame game = new CrabSaveGame();
		double x = game.getTheHuman().getX();
		game.onTick();
		assertTrue(x!=game.getTheHuman().getX());
		
	}
	
	/**
	 * tests the on tick function of the Pollution Game
	 */
	
	public void testPollutionGame(){
		PollutionGame game = new PollutionGame();
		double x = game.getPollutants().get(0).getX();
		game.onTick();
		assertTrue(x!=game.getPollutants().get(0).getX());
		
	}
	
	
	

}
