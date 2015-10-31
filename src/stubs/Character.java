package stubs;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class Character implements KeyListener,MouseListener,MouseMotionListener {

	
	
	
	private double xPos,yPos;
	private int health;
	
	
	public Character(){
		
	}
	
	
	public abstract void move();
	
	
	public abstract void onTick();
	
	
	public double getX(){
		return xPos;
	}
	public double getY(){
		return yPos;
	}
	
	public int getHealth(){
		return health;
	}
	
}
