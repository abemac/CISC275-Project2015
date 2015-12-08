package tests;

import java.util.Vector;

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
	
	
	
	public void testVector(){
		misc.Vector v = new misc.Vector(1, 1);
		assertEquals(v.getX(), 1.0);
		assertEquals(v.getY(), 1.0);
		assertEquals(v.getZ(), 0.0);
		v.add(new misc.Vector(4,5));
		assertEquals(v.getX(), 5.0);
		assertEquals(v.getY(), 6.0);
		assertEquals(v.getZ(), 0.0);
		misc.Vector v2 = new misc.Vector(1, 1,3);
		assertEquals(v2.getX(), 1.0);
		assertEquals(v2.getY(), 1.0);
		assertEquals(v2.getZ(), 3.0);
		v2.add(new misc.Vector(4,5,1));
		assertEquals(v2.getX(), 5.0);
		assertEquals(v2.getY(), 6.0);
		assertEquals(v2.getZ(), 4.0);
		v2.setX(0);
		v2.setY(0);
		v2.setZ(0);
		assertEquals(v2.getX(), 0.0);
		assertEquals(v2.getY(), 0.0);
		assertEquals(v2.getZ(),0.0);
		
		
		
	}
}
