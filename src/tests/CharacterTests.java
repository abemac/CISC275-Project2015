package tests;

import characters.Bubble;
import characters.Crab;
import characters.Fish;
import enemies.Hook;
import enemies.Pollutant;
import enemies.TheHuman;
import enemies.Trash;
import games.OverfishingGame;
import junit.framework.TestCase;
import misc.Vector;
import characters.*;

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
		Fish fish = new Fish(0.0, 0.0, 0.0);
//		int h = fish.getHealth();
//		fish.decreaseHealth(5);
//		assertEquals(fish.getHealth(),h-5);
		double x =fish.getX();
		fish.move(10.0, 0);
		assertFalse(x== 10.0);
		double y = fish.getY();
		fish.move(0, 10);
		assertFalse(y==10.0);
		
	    Fish fish2 = new Fish(0.0, 0.0, 0.0);
		Hook hook = new Hook(0,0,3);
		OverfishingGame game = new OverfishingGame();
		game.getEnemies().add(hook);
		game.getSchoolofFish().add(fish2);
		game.onTick();
		assertFalse(fish2.hasCollided());
		
		
		
		
		
		
	}
	
	/**
	 * tests the basic functions of Fish, such as decreasing its health and updating its x and y position
	 */
	public void testCrab(){
		Crab crab = new Crab(0.0, 0.0, null);
//		int h = crab.getHealth();
//		crab.decreaseHealth(5);
//		assertEquals(crab.getHealth(),h-5);
		double x =crab.getX();
		crab.move(10.0, 0);
		assertFalse(crab.getX()== 10.0);
		double y = crab.getY();
		crab.move(0, 10.0);
		assertFalse(crab.getY()==y+10.0);
		
		Trash t = new Trash(0,0,Trash.BANANA);
		double x2 = t.getX();
		double y2 = t.getY();
		crab.holdTrash(t);
		crab.throwAttachedTrash();
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
		Bubble b = new Bubble();
		Pollutant p = new Pollutant(new Vector(0, 0),new Vector(1, 1),.1,Pollutant.FERTILIZER);
		double y = b.getY();
		assertFalse(b.getY()==y+2);
		double x = b.getX();
		assertNotSame(b.getX(),x-1);
		assertNotSame(b.getX(),0);
		assertNotSame(b.getY(),0);
		
		
		
	}
	
	public void testGame3Crab(){
		Game3Crab c = new Game3Crab(0.0, null);
		
		
	}
	
	public void testGame3Fish(){
		Game3Fish f = new Game3Fish(null);
		
	}
	

}
