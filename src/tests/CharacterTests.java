package tests;

import characters.Bubble;
import characters.Crab;
import characters.Fish;
import enemies.Hook;
import enemies.TheHuman;
import enemies.Trash;
import games.OverfishingGame;
import junit.framework.TestCase;

/**
 * This class tests all subclasses of the abstract class Character.  Therfore, it also tests character itself, without directly 
 * instantiating Character, since that can't be done.
 * @author abraham
 *
 */
public class CharacterTests extends TestCase {
	
	/**
	 * tests the basic functions of Fish, such as decreasing its health and updating its x and y position
	 */
	public void testFish(){
		Fish fish = new Fish(0,0);
		int h = fish.getHealth();
		fish.decreaseHealth(5);
		assertEquals(fish.getHealth(),h-5);
		double x =fish.getX();
		fish.move(10, 0);
		assertEquals(fish.getX(), x+10);
		double y = fish.getY();
		fish.move(0, 10);
		assertEquals(fish.getY(),y+10);
		
		Fish fish2 = new Fish(0,0);
		Hook hook = new Hook(0,0,3);
		OverfishingGame game = new OverfishingGame();
		game.getEnemies().add(hook);
		game.getSchoolofFish().add(fish2);
		game.onTick();
		assertTrue(fish2.hasCollided());
		
		
		
		
		
		
	}
	
	/**
	 * tests the basic functions of Fish, such as decreasing its health and updating its x and y position
	 */
	public void testCrab(){
		Crab crab = new Crab(0,0,0);
		int h = crab.getHealth();
		crab.decreaseHealth(5);
		assertEquals(crab.getHealth(),h-5);
		double x =crab.getX();
		crab.move(10, 0);
		assertEquals(crab.getX(),10);
		double y = crab.getY();
		crab.move(0, 10);
		assertEquals(crab.getY(),y+10);
		
		Trash t = new Trash(0,0,Trash.BANANA);
		double x2 = t.getX();
		double y2 = t.getY();
		crab.throwTrash(t);
		assertFalse(x2==t.getX() && y2 == t.getY());
		
		TheHuman human = new TheHuman(0, 0);
		boolean b = human.hasFish();
		crab.pinchHumanToGetFish(human);
		assertFalse(human.hasFish());
		
		
	}
	
	
	/**
	 * tests the basic functions of the Bubble class
	 */
	public void testBubble(){
		Bubble b = new Bubble(0,0);
		
		
		
	}

}
