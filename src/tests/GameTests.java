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
		
		
		
	}
	/**
	 * test the overfishing game
	 */
	public void testOverfishing(){
		OverfishingGame game = new OverfishingGame();
		double x = game.getSchoolofFish().get(0).getX();
		game.onTick();
		assertTrue(x!=game.getSchoolofFish().get(0).getX());
		
		
	}
	
	
	/**
	 * tests the crab save game
	 */
	
	public void testCrabSave(){
		CrabSaveGame game = new CrabSaveGame();
		double x = game.getTheHuman().getX();
		game.onTick();
		assertTrue(x!=game.getTheHuman().getX());
		
	}
	
	/**
	 * tests the functions of the Pollution Game
	 */
	
	public void testPollutionGame(){
		PollutionGame game = new PollutionGame();
		double x = game.getPollutants().get(0).getX();
		game.onTick();
		assertTrue(x!=game.getPollutants().get(0).getX());
		
	}
	
	
	

}
