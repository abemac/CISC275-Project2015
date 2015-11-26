package games;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import characters.Fish;
import enemies.Enemy;
import enemies.Hook;
import enemies.Net;
import misc.DialogBox;
import misc.Point;
import misc.SeaBottom;
import misc.SoundDoer;
import misc.Tickable;
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
	
	private long distance=0;      // how far the player reached in the level
	private double timer = 61.0;
	private ArrayList<Fish> school;		// an array list of fish that the player guides through the level
	private ArrayList<Enemy> enemies;	// an array list of Enemy that try to capture the fish
	private SeaBottom seaBottom;
	private final Color blue = new Color(114,145,215);
	
	private ArrayList<Enemy> enemyBank;
	private ArrayList<Integer> enemiesAvailable;
	
	private static BufferedImage tooCloseToEdge;
	private boolean tooCloseToggle;
	private long tooCloseTimer;
	
	private boolean donePlaying=false;
	
	
	private SoundDoer soundDoer=new SoundDoer();
	
	private Color timerColor=Color.RED;
	private final Font timerFont = new Font("default",Font.BOLD,200);
	
	private DialogBox dialogBox;
	//private DecimalFormat df = new DecimalFormat("#.##");
	
	/**
	 * Constructor for the overfishing game. calls the super constructor
	 */
	public OverfishingGame(){	
		super();
		setIsDone(false);
		loadRes();
		
		soundDoer.playSound("/game1song.wav");
		
		dialogBox=new DialogBox(this);
		
	}
	
	
	private void loadRes(){
		try {
			tooCloseToEdge = Util.loadImage("/tooclosetoedge.png",Util.getCANVAS_WIDTH_SCALED()+50,400, this);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * gets called in the super constructor and initialize components
	 */
	public void init(){
		school = new ArrayList<Fish>();
		school.add(new Fish(0, 0,100,2));
		school.add(new Fish(-100,25,100,4));
		school.add(new Fish(-200,100,100,5));
		school.add(new Fish(-150,150,100,3));
		school.add(new Fish(100,100,100,1));
		school.add(new Fish(0,100,100,4));
		school.add(new Fish(50, 100, 100,2));
		school.add(new Fish(-200,25,100,3));
		school.add(new Fish(0, 200,100,2));
		school.add(new Fish(-100,25,100,4));
		school.add(new Fish(-250,250,100,5));
		school.add(new Fish(-150,300,100,3));
		school.add(new Fish(200,200,100,1));
		school.add(new Fish(0,300,100,4));
		school.add(new Fish(-250,150,100,4));
		
		enemies = new ArrayList<Enemy>();
		generatInitialEnemies();
		
		seaBottom = new SeaBottom();
	}
	
	
	/**
	 * gets called at 60Hz to generate changes to the game
	 */
	boolean oneFishIn,leftEdge,rightEdge,topEdge=false;
	@Override
	public void onTick() {				
		for(Enemy e : enemies){
			e.onTick();
		}
		for(Fish f : school){
			f.onTick();
			if(seaBottom.isIn(f)){
				oneFishIn=true;
			}
			if(f.getX()<-Util.getDISTANCE_TO_EDGE()){
				leftEdge=true;
			}
			if(f.getX()>Util.getDISTANCE_TO_EDGE()){
				rightEdge=true;
			}
			if(f.getY()<-1000){
				topEdge=true;
			}
		}
		if(leftEdge){
			for(Fish f  : school){
				f.setX(f.getX()+5);
			}
		}
		else if (rightEdge){
			for(Fish f  : school){
				f.setX(f.getX()-5);
			}
		}
		
		if(topEdge){
			for(Fish f  : school){
				f.setY(f.getY()+5);
			}
		}
		leftEdge=false;
		rightEdge=false;
		topEdge=false;
		if(oneFishIn){
			for(Fish f:school){
				f.setY(f.getY()-6);
				f.setStopCheating(true);
			}
		}else{
			for(Fish f:school){
				f.setStopCheating(false);
			}
		}
		
		oneFishIn=false;
		
		seaBottom.onTick();
		
		limiter++;
		if(limiter>120){
			//System.out.println(enemies.size());// GOOD
			removeNotNeeded();
			limiter=0;
		}
		
		
		
		if(!donePlaying){
			distance++;
			checkAndRemoveFish();
			timer-=1/60.0;
			
			if(timer<1){
				timer=0;
				donePlaying=true;
			}
		}
		
		if(donePlaying){
			if(timer>0){
				EstuaryAdventureMain.showMenuCursor();
				soundDoer.stopSound();
				dialogBox.setTitle(DialogBox.TITLE_CAUGHT);
			}else{
				EstuaryAdventureMain.showMenuCursor();
				dialogBox.setTitle(DialogBox.TITLE_NICE_JOB);
			}
		}
		
	}
	
	private long limiter=0;
	/**
	 * defines how to draw the overfishing game to the screen
	 * @param g Graphics2D to use to draw
	 */
	public void render(Graphics2D g){
		g.setColor(blue);
		g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), 2000);
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
		
		if(Fish.getBack()){
			if(tooCloseToggle)
				g.drawImage(tooCloseToEdge,-Util.getDISTANCE_TO_EDGE(),-300,null);
			
			if(tooCloseTimer%20==0){
				tooCloseToggle=!tooCloseToggle;
			}
			tooCloseTimer++;
		}
		
		if(donePlaying){
			dialogBox.render(g);
		}
		
		
		g.setColor(timerColor);
		g.setFont(timerFont);
		Util.drawCenteredString(""+(int)timer, -Util.getDISTANCE_TO_EDGE()+200, -800, g);
		
		
	}
	
	
	/**
	 * generates initial Enemies (12 of them). It does so by choosing from a pre-made 
	 * enemy bank to avoid deleting and creating ojbects during the game
	 */
	private void generatInitialEnemies(){
		enemyBank = new ArrayList<Enemy>(12);
		enemiesAvailable =new ArrayList<Integer>(12);
		for(int k=0;k<12;k++){
			enemiesAvailable.add(k);
		}
		int i =0;
		int choose;
		while(i<12){
			//System.out.println(i%4);  //GOOD
			switch(i%4){
				case 0:
					enemyBank.add(new Net(0,-1000,Net.LILNET));break;
				case 1:
					enemyBank.add(new Hook(0,-1000,Hook.SINGLE));break;
				case 2:
					enemyBank.add(new Hook(0,-500,Hook.DOUBLE_1));break;
				case 3:
					enemyBank.add(new Hook(0,-1500,Hook.DOUBLE_2));break;
			}
			
			i++;
		}
		
		choose = enemiesAvailable.get(0);
		enemiesAvailable.remove(0);
		enemyBank.get(choose).setX(Util.getDISTANCE_TO_EDGE()*1.5);
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
	
	/**
	 * removes enemies off the screen from the list of current enemies, but does not delete them from memory.
	 * if one is removed, it puts a new enemy on the other end of the screen
	 */
	private void removeNotNeeded(){
		if(enemies.get(0).getX()<-2*Util.getDISTANCE_TO_EDGE()){
			enemiesAvailable.add(enemies.get(0).getIndex());
			enemies.get(0).removeAttachedFish();
			enemies.remove(0);
			generateNewEnemy();
		}
		
		
	}
	/**
	 * called in removeNotNeeded() if an enemy has been removed.  Does not
	 * create a new object in memory, just chooses a new one from the Enemy bank. 
	 */
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
	private void checkAndRemoveFish(){
		for(Enemy e : enemies){
			Iterator<Fish> i = school.iterator();
			while(i.hasNext()){
				Fish f = i.next();
				if(e.isIn(f)){
					e.addAttachedFish(f);
					f.setCaptured(true);
					i.remove();
				}
			}
		}
		if(school.size()==0){
			donePlaying=true;
			EstuaryAdventureMain.showMenuCursor();
		}
		
	}


	/**
	 * returns the number of fish lost
	 * @return the number of fish lost
	 */
	public int getNumFish() {
		return school.size();
	}


	/**
	 * returns the distance traveled
	 * @return the distance traveled
	 */
	public int getDistance() {
		return (int) (distance/1000);
	}


	/**
	 * returns the current school of fish that are being controlled by the user
	 * @return the school of fish being controlled by the user
	 */
	public ArrayList<Fish> getSchoolofFish() {
		return school;
	}


	/**
	 * returns the enemies
	 * @return all the enemies present in the game
	 */
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	};		
	



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
		if(donePlaying){
			dialogBox.mouseClicked(e);
		}
		
		
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
		if(donePlaying){
			dialogBox.mouseMoved(e);
		}
	}
	
	
	

}
