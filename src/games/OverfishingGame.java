package games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import characters.Fish;
import enemies.Enemy;
import enemies.Net;
import misc.SeaBottom;
import misc.Util;

/*
 * The first game played.  Demonstrates the effects of over-fishing.  Very educational.
 */

/**
 * main control class for the Overfishing game. Most functionality is implemented in the superclass.
 * @author abraham
 *
 */
public class OverfishingGame extends Game {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6483515886892518982L;
	private int numFishLost;			//how many fish have been captured
	private int distance;				// how far the player reached in the level
	private ArrayList<Fish> school;		// an array list of fish that the player guides through the level
	private ArrayList<Enemy> enemies;	// an array list of Enemy that try to capture the fish
	private SeaBottom seaBottom;
	private boolean isDone;
	private final Color blue = new Color(114,145,215);
	
	/**
	 * Constructor for the overfishing game. calls the super constructor
	 */
	public OverfishingGame(){	
		super();
		isDone = false;
	}
	
	public void init(){
		school = new ArrayList<Fish>();
		school.add(new Fish(0, 0));
		school.add(new Fish(-100,25));
		school.add(new Fish(-200,100));
		school.add(new Fish(-150,150));
		school.add(new Fish(100,100));
		school.add(new Fish(0,100));
		
		enemies = new ArrayList<Enemy>();
		enemies.add(new Net(0,-1000,Net.LILNET));
		enemies.add(new Net(1000,-500,Net.LILNET));
		
		seaBottom = new SeaBottom(500, 1000);
	}
	
	
	/**
	 * gets called at 60Hz to generate changes to the game
	 */
	@Override
	public void onTick() {				
		for(Enemy e : enemies){
			e.onTick();
		}
		for(Fish f : school){
			f.onTick();
		}
		seaBottom.onTick();
		
		
	}
	
	public void render(Graphics2D g){
		g.setColor(blue);
		g.fillRect(-Util.DISTANCE_TO_EDGE, -1000, 2*Util.DISTANCE_TO_EDGE, 2000);
		seaBottom.render(g);
		
		
		for(Enemy e : enemies){
			e.render(g);
		}
		for(Fish f : school){
			f.render(g);
		}
		
		
		
	}
	/**
	 * changes enemy position in random directions and distances
	 */
	private void randomlyMoveNetsAndHooks(){};	
	
	/**
	 * checks for a collision between fish and enemy and adds 1 to numFishLost if true
	 */
	private void checkAndRemoveFish(){}


	/**
	 * 
	 * @return the number of fish lost
	 */
	public int getNumFishLost() {
		return numFishLost;
	}


	/**
	 * 
	 * @return the distance traveled
	 */
	public int getDistance() {
		return distance;
	}


	/**
	 * 
	 * @return the school of fish being controlled by the user
	 */
	public ArrayList<Fish> getSchoolofFish() {
		return school;
	}


	/**
	 * 
	 * @return all the enemies present in the game
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	};		
	
	
	public boolean isDone(){
		return isDone;
	}



	@Override
	public void keyPressed(KeyEvent e) {
		for(Fish f : school){
			f.keyPressed(e);
		}
		
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		for(Fish f : school){
			f.keyReleased(e);
		}
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
