package tests;

import enemies.Hook;
import enemies.Net;
import enemies.Pollutant;
import enemies.TheHuman;
import enemies.Trash;
import junit.framework.TestCase;

public class EnemyTests extends TestCase{
	
	
	
	//cant test enemy itself because its abstract
	
	public void testHook(){
		Hook hook = new Hook(50);
		assertEquals(hook.getSize(),50);
		double y = hook.getY();
		hook.act();
		assertFalse(y==hook.getY());
		
		
	}
	
	public void testNet(){
		Net net = new Net(Net.BIGNET);
		assertEquals(net.getType(),Net.BIGNET);
		double y = net.getY();
		net.act();
		assertFalse(y==net.getY());
	}
	
	
	public void testPollutant(){
		Pollutant p = new Pollutant(Pollutant.FERTILIZER);
		assertEquals(p.getType(),Pollutant.FERTILIZER);
		double y = p.getY();
		p.act();
		assertFalse(y==p.getY());
	}
	
	
	public void testTheHuman(){
		TheHuman h = new TheHuman();
		double x = h.getX();
		h.act();
		assertFalse(x==h.getX());
		
		double health = h.getHealth();
		h.decreaseHealth(-4);;
		assertEquals(health+4,h.getHealth());
	}
	
	public void testTrash(){
		Trash trash = new Trash(Trash.BANANA);
		assertEquals(trash.getType(),Trash.BANANA);
		
		//no other tests for trash.  Trash is a passive object. 
		
	
	}
	
	
	

}
