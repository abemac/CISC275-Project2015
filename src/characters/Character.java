package characters;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;


public abstract class Character implements KeyListener,MouseListener,MouseMotionListener,Serializable {

	
	
	
	private double xPos,yPos;	// the x and y position of the Character on the screen
	private int health;			// health of the character represented in int
	
	// Character constructor, enter xPos and yPos
	public Character(){			
		
	} // Character()
	
	
	// change xPos and yPos
	public abstract void move(double dx,double dy);
	
	
	// controls updates to the game
	public abstract void onTick();
	
	
	
	
	// returns the xPos double value of the Character
	public double getX(){		
		return xPos;
	} //getX()
	
	// returns the yPos double value of the Character
	public double getY(){
		return yPos;
	} //getY()
	
	// returns the health int value of the Character 
	public int getHealth(){	
		return health;
	} //getHealth()
	
	
	public void decreaseHealth(int h){
		health-=h;
	}
	
}
