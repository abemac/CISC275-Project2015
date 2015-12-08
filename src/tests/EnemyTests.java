package tests;

import characters.Bubble;
import characters.Crab;
import characters.Fish;
import enemies.Hook;
import enemies.Net;
import enemies.Pollutant;
import enemies.TheHuman;
import enemies.Trash;
import junit.framework.TestCase;
import misc.Vector;

/**
 * Tests all subclasses of Enemy, and therefore tests the abstract class Enemy itself
 * @author abraham
 *
 */
public class EnemyTests extends TestCase{
	
	
	
	
	/**
	 * tests basic functions of the Hook. The hook's only function is to move up and down randomly. Therfore,
	 * a simple but absolutely valid test is to test whether when hook.act() is called, that it is not in the same position as 
	 * before.  This tests the functionality of the act() method, and also demontrates whether or not it is correctly
	 * getting called in the main game loop.  Simple test, but lots of insight into the game's inner workings.
	 */
	public void testHook(){
		Hook hook = new Hook(0,0,50);
		assertEquals(hook.getType(),50);
		double y = hook.getY();
		hook.act();
		assertFalse(y==hook.getY());
		
	}
	
	/**
	 * tests the basic functions of net, such as moving up and down randomly and being distinguishable two
	 * different types of net. For the some reasons as stated testHook(), this test can validate many inner workings of the game.
	 * See the description of testHook() for more details.
	 */
	public void testNet(){
		Net net = new Net(0,0,Net.BIGNET);
		assertEquals(net.getType(),Net.BIGNET);
		double y = net.getY();
		net.act();
		assertFalse(y==net.getY());
		
		Net net2 = new Net(5,-2001,Net.LILNET);
		for (int i = 0; i < 50; i++) {
			net2.onTick();
		}
//		Fish fishyy = new Fish(206, 0, 1, 1);
//		assertEquals(net2.isIn(fishyy), false);
//		net2.addAttachedFish(fishyy);
//		assertEquals(net2.attachedFish,  )
	}
	
	
	/**
	 * tests the basic functions of Pollutant
	 */
	public void testPollutant(){
		Pollutant p = new Pollutant(new Vector(0, 0), new Vector(0, -1), .1, Pollutant.SEWAGE);
		assertEquals(p.getType(),Pollutant.SEWAGE);
		double y = p.getY();
		p.act(); // tests float down also, since float down is called in act()
		assertFalse(y<p.getY());//pollutant should float down the screen
		Bubble bub = new Bubble();
	//	p.fixToBubble(bub);
		bub.setX(0);
		bub.setY(0);
//		assertTrue(p.fixedToBubble, true)
//		p.act();
		
		
	}
	
	
	/**
	 * tests the basic functions of TheHuman
	 */
	public void testTheHuman(){
		
		
		
		
	}
	/**
	 * tests basic functions of trash
	 */
	public void testTrash(){
		Trash trash = new Trash(0,0,Trash.BANANA);
		assertEquals(trash.getType(),Trash.BANANA);
		//no other tests for trash.  Trash is a passive object. 
		
	
	}
	
	
	

}
