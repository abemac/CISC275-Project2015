package enemies;

import java.io.Serializable;

import misc.Tickable;

/**
 * Enemy is the overarching abstract class that defines the behavior of enemies in the game.  
 * An Enemy can be non moving, like a banana, or active, like a human.   
 * @author abraham
 *
 */
public abstract class Enemy implements Serializable,Tickable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7282749495474164940L;
	private double xPos,yPos;	//Enemy has location
	private int health;			//Enemy has health
	
	/**
	 * Creates an Enemy with initial x,y and health
	 * 
	 * @param xPos the initial x position 
	 * @param yPos the initial y position
	 * @param health the health level of the enemy
	 */
	public Enemy(double xPos, double yPos, int health){
		
	}
	
	/**
	 * Creates and enemy with initial x,y and a default health level
	 * 
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 */
	public Enemy(double xPos, double yPos){
		
	}
	
	/**
	 * defines the update behavior of the Enemy.  This method gets called in onTick.
	 */
	public abstract void act(); 
	
	/**
	 * gets called in the main game loop, 60 times per second
	 */
	public void onTick(){
		act();
	}
	
	
	public double getX(){
		//returns X position of Enemy
		return xPos;
	}
	public double getY(){
		//returns Y position of Enemy
		return yPos;
	}
	
	public int getHealth(){
		//return health of Enemy
		return health;
	}
	
	public void decreaseHealth(int h){
		health-=h;
	}
	
	
	
	
	
	
		
}
