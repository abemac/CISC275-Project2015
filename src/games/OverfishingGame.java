package games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashSet;

import characters.Fish;
import enemies.Enemy;
import enemies.Hook;
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
	
	private ArrayList<Enemy> enemyBank;
	private ArrayList<Integer> enemiesAvailable;

	
	/**
	 * Constructor for the overfishing game. calls the super constructor
	 */
	public OverfishingGame(){	
		super();
		isDone = false;
		
		
	}
	
	public void init(){
		school = new ArrayList<Fish>();
		school.add(new Fish(0, 0,100,2));
		school.add(new Fish(-100,25,100,4));
		school.add(new Fish(-200,100,100,5));
		school.add(new Fish(-150,150,100,3));
		school.add(new Fish(100,100,100,1));
		school.add(new Fish(0,100,100,4));
		
		school.add(new Fish(0, 200,100,2));
		school.add(new Fish(-100,25,100,4));
		school.add(new Fish(-250,250,100,5));
		school.add(new Fish(-150,300,100,3));
		school.add(new Fish(200,200,100,1));
		school.add(new Fish(0,300,100,4));
		
		enemies = new ArrayList<Enemy>();
		generatInitialEnemies();
		
		seaBottom = new SeaBottom();
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
		
		limiter++;
		if(limiter>120){
			//System.out.println(enemies.size());// GOOD
			removeNotNeeded();
			limiter=0;
		}
	}
	
	private long limiter=0;
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
		
		for(Enemy e : enemies){
			if(e instanceof Net){
				((Net) e).render2(g);
			}
		}
		
		
	}
	
	
	
	private void generatInitialEnemies(){
		enemyBank = new ArrayList<Enemy>(12);
		enemiesAvailable =new ArrayList<Integer>(12);
		for(int k=0;k<12;k++){
			enemiesAvailable.add(k);
		}
		int i =0;
		int choose;
		while(i<12){
			System.out.println(i%4);
			switch(i%4){
				case 0:
					enemyBank.add(new Net(0,-1000,Net.LILNET));break;
				case 1:
					enemyBank.add(new Hook(0,-1000,Hook.SINGLE));break;
				case 2:
					enemyBank.add(new Hook(0,-1000,Hook.DOUBLE_1));break;
				case 3:
					enemyBank.add(new Hook(0,-1000,Hook.DOUBLE_2));break;
			}
			
			i++;
		}
		
		choose = enemiesAvailable.get(0);
		enemiesAvailable.remove(0);
		enemyBank.get(choose).setX(Util.DISTANCE_TO_EDGE*1.5);
		enemyBank.get(choose).setIndex(choose);
		enemies.add(enemyBank.get(choose));
		
		while(enemies.size()<7){
			choose = enemiesAvailable.get(0);
			enemiesAvailable.remove(0);
			enemyBank.get(choose).setX(enemies.get(enemies.size()-1).getX()+1000);
			enemyBank.get(choose).setIndex(choose);
			enemies.add(enemyBank.get(choose));
			
		}
	}
	
	private void removeNotNeeded(){
		if(enemies.get(0).getX()<-2*Util.DISTANCE_TO_EDGE){
			enemiesAvailable.add(enemies.get(0).getIndex());
			enemies.remove(0);
			generateNewEnemy();
		}
		
		
	}
	
	private void generateNewEnemy(){
		int choose2 = enemiesAvailable.get(0);
		enemiesAvailable.remove(0);
		enemyBank.get(choose2).setX(enemies.get(enemies.size()-1).getX()+1000);
		enemyBank.get(choose2).setIndex(choose2);
		enemies.add(enemyBank.get(choose2));
	}
	
	
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
