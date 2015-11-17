package enemies;

import java.awt.Graphics2D;

import java.io.Serializable;

import characters.Fish;
import misc.Renderable;
import misc.Tickable;

/**
 * Enemy is the overarching abstract class that defines the behavior of enemies in the game.  
 * An Enemy can be non moving, like a banana, or active, like a human.   
 * @author abraham
 *
 */
public abstract class Enemy implements Serializable,Tickable,Renderable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7282749495474164940L;
	protected double xPos;	//Enemy has location
	protected double yPos;
	protected int health;			//Enemy has health
	
	private int myIndex;
	
	/**
	 * Creates an Enemy with initial x,y and health
	 * 
	 * @param xPos the initial x position 
	 * @param yPos the initial y position
	 * @param health the health level of the enemy
	 */
	public Enemy(double xPos, double yPos, int health){
		this.xPos = xPos;
		this.yPos = yPos;
		this.health = health;
	}
	
	/**
	 * Creates and enemy with initial x,y and a default health level
	 * 
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 */
	public Enemy(double xPos, double yPos){
		this.xPos = xPos;
		this.yPos = yPos;
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
	/**
	 * 
	 */
	public abstract void render(Graphics2D g);
	
	/**
	 * 
	 * @return the current x position of the Enemy
	 */
	public double getX(){
		return xPos;
	}
	/**
	 * 
	 * @return the current y position of the Enemy
	 */
	public double getY(){
		return yPos;
	}
	
	/**
	 * 
	 * @return the Enemy's current health
	 */
	public int getHealth(){
		return health;
	}
	
	/**
	 * decreases the Enemy's health by amount h
	 * @param h the amount to decrease health by
	 */
	public void decreaseHealth(int h){
		health-=h;
	}
	/**
	 * set the x posintion
	 * @param x
	 */
	public void setX(double x){
		this.xPos=x;
	}
	/**
	 * set the y position
	 * @param y
	 */
	public void setY(double y){
		this.yPos=y;
	}
	
	/**
	 * used for keeping track of available enemies from the enemy  bank
	 * @param i
	 */
	public void setIndex(int i){
		this.myIndex=i;
	}
	/**
	 * used for keeping track of available enemies from the enemy  bank
	 * @return
	 */
	public int getIndex(){
		return myIndex;
	}
	/**
	 * detects collision between fish and enemies
	 * @param fish
	 * @return
	 */
	public boolean isIn(Fish fish){return false;}
	/**
	 * removes attached fish
	 */
	public void removeAttachedFish(){}
	/**
	 * adds an attached fish
	 * @param f
	 */
	public void addAttachedFish(Fish f){}
		
}
