package tests;

import characters.Fish;
import junit.framework.TestCase;

public class CharacterTests extends TestCase {
	
	//cant test character class iteself because its abstract
	
	public void testFish(){
		Fish fish = new Fish();
		int h = fish.getHealth();
		fish.decreaseHealth(5);
		assertEquals(fish.getHealth(),h-5);
		double x =fish.getX();
		fish.move(10, 0);
		assertEquals(fish.getX(), x+10);
		double y = fish.getY();
		fish.move(0, 10);
		assertEquals(fish.getY(),y+10);
		
		
		
	}
	
	
	public void testCrab(){
		
	}
	

}
