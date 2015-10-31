package stubs;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public abstract class Character implements KeyListener,MouseListener,MouseMotionListener {

	
	
	
	private double xPos,yPos;	// the x and y position of the Character on the screen
	private int health;			// health of the character represented in int
	
	public Character(){			// Character constructor
		
	} // Character()
	
	
	public abstract void move();	// change xPos and yPos
	
	
	public abstract void onTick();	// controls updates to the game
	
	
	public double getX(){			// returns the xPos double value of the Character
		return xPos;
	} //getX()
	public double getY(){			// returns the yPos double value of the Character
		return yPos;
	} //getY()
	
	public int getHealth(){			// returns the health int value of the Character 
		return health;
	} //getHealth()
	
}
