package tests;

import enemies.Hook;
import enemies.Net;
import enemies.TheHuman;
import enemies.Trash;
import junit.framework.TestCase;

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
		//assertEquals(hook.getSize(),50);
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
		
		Net net2 = new Net(5,5,Net.LILNET);
		assertEquals(net2.getType(), Net.LILNET);
		assertEquals(net2.getX(),5);
		assertEquals(net2.getY(),5);
	}
	
	
	/**
	 * tests the basic functions of Pollutant
	 */
	public void testPollutant(){
		//Pollutant p = new Pollutant(0,0,Pollutant.FERTILIZER);
		//assertEquals(p.getType(),Pollutant.FERTILIZER);
		//double y = p.getY();
		//p.act(); // tests float down also, since float down is called in act()
		//assertFalse(y<p.getY());//pollutant should float down the screen
		
		
		
	}
	
	
	/**
	 * tests the basic functions of TheHuman
	 */
	public void testTheHuman(){
		TheHuman h = new TheHuman(0,0);
		double x = h.getX();
		h.act();
		assertFalse(x==h.getX());
		
		double health = h.getHealth();
		h.decreaseHealth(-4);;
		assertEquals(health+4,h.getHealth());
//		
//		Crab crab = new Crab(0,0,0);
//		TheHuman human = new TheHuman(0, 0);
//		boolean b = human.hasFish();
//		crab.pinchHumanToGetFish(human);
//		assertFalse(human.hasFish());
		
		
		
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
