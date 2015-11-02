package characters;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;


/**
 * Character is an abstract class that provides basic implementation for all characters to be contolled by
 * the user. 
 * It implements listener interfaces.
 * @author abraham
 * 
 */
public abstract class Character implements KeyListener,MouseListener,MouseMotionListener,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6777058852530701862L;
	private double xPos,yPos;	// the x and y position of the Character on the screen
	private int health;			// health of the character represented in int
	
	/**
	 * default constructor for Character
	 * @param none
	 */
	public Character(){			
		
	} 
	
	/** move the character a certain amount dx and a certain amount dy
	 * @param dx
	 * @param dy
	 */
	public abstract void move(double dx,double dy);
	
	
	/**
	 * called 60 times/second in the main Game loop.  This is where all updates that occur based 
	 * on time will go. For Characters, it may not be used. Updates that occur as a result of user action should be put in the listener 
	 * methods. 
	 */
	public void onTick(){};
	
	
	
	/** returns the xPos double value of the Character
	 * @return x Position
	 */
	public double getX(){		
		return xPos;
	}
	
	/**
	 * returns the yPos double value of the Character
	 * @return y Position
	 */
	public double getY(){
		return yPos;
	} 
	
	/** returns the health int value of the Character 
	 * @return health
	 */
	public int getHealth(){	
		return health;
	}
	
	/**
	 * decreases the health by amount h
	 * @param h
	 */
	public void decreaseHealth(int h){
		health-=h;
	}
	
}
