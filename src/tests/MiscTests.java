package tests;

import junit.framework.TestCase;
import misc.ArbitraryLine;
import misc.Point;

public class MiscTests extends TestCase{

	
	
	
	public void testArbitraryLine(){
		ArbitraryLine line = new ArbitraryLine(new int[]{1,2,3,4,5,6,7,8},1,1,0);
		assertEquals(4,line.getYatXPos(3));
		assertEquals(6,line.getYatXPos(5));
		
		assertFalse(line.isAboveLine(3, 5));
		assertFalse(line.isBelowLine(1, -5));
		
		ArbitraryLine line2=new ArbitraryLine(new Point(0, 0), new Point(10,10));
		assertTrue(line2.isAboveLine(-500, -500));
		assertFalse(line2.isBelowLine(500, 500));
		
		line2.setPoints(new Point(1, 1), new Point(11,11));
		assertTrue(line2.isAboveLine(-500, -500));
		assertFalse(line2.isBelowLine(500, 500));
		
		ArbitraryLine line3 = new ArbitraryLine(new double[]{1,2,3,4,5,6,7,8},1,1,0);
		assertEquals(4,line3.getYatXPos(3));
		assertEquals(6,line3.getYatXPos(5));
		
		assertFalse(line3.isAboveLine(3, 5));
		assertFalse(line3.isBelowLine(1, -5));
		
		line3.setX(1000);
		line3.setY(0);
		assertTrue(0==line3.getSlopeAt(1500));
		assertFalse(7==line3.getYatXPos(1500));
		
		
	}
}
