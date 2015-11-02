package tests;

<<<<<<< HEAD
public class GameTests {
	// hello world
	// Testing this
=======
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
	
	
	
	
	
	//Overfishing game tests
	public void testStartStop(){
		OverfishingGame game = new OverfishingGame();//this test is general and is sufficiant for all Games
		assertEquals(game.isRunning(),false);
		game.start();
		assertEquals(game.isRunning(), true);
		game.stop();
		assertEquals(game.isRunning(),false);
		
		
	}
	
	public void testOnTick(){
		OverfishingGame game = new OverfishingGame();
		double x = game.getSchoolofFish().get(0).getX();
		game.onTick();
		assertTrue(x!=game.getSchoolofFish().get(0).getX());
	}
	
	//Crab Save Game tests
	
	
	public void testOnTick2(){
		CrabSaveGame game = new CrabSaveGame();
		double x = game.getTheHuman().getX();
		game.onTick();
		assertTrue(x!=game.getTheHuman().getX());
		
	}
	
	//Pullution Game tests
	
	public void testonTick3(){
		PollutionGame game = new PollutionGame();
		double x = game.getPollutants().get(0).getX();
		game.onTick();
		assertTrue(x!=game.getPollutants().get(0).getX());
		
	}
	
	
	
>>>>>>> 35f9d32085705824b46914fb1959f16a51ad903c
}
