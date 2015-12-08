package games;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import misc.Renderable;
import misc.Tickable;
import scorekeeping.GameScore;

/**
 * Game is an overarching class that implements main loop control the game. It handles calling updates 
 * at 60Hz and handles rendering also, using the View class in our view package
 * @author abraham
 *
 */
public abstract class Game implements Serializable,Tickable,Renderable,KeyListener,MouseListener,MouseMotionListener{

	private boolean sendSignal=false;
	private boolean isDone;
	/**
	 * 
	 */
	private static final long serialVersionUID = -7877285904741522154L;
	
	
	
	
	/////////////////
	
	/**
	 * creates a game, calling the initializer (init()) method
	 */
	public Game(){			
		init();
	} 
	
	/**
	 * used to do any initialation required by the game
	 */
	public void init(){
		
	}
	
	
	/**
	 * returns whether or not the game is Done
	 * @return boolean representing whether or not the game is done
	 */
	public boolean isDone(){
		return isDone;
	}
	
	public void setIsDone(boolean b){
		isDone=b;
	}
	
	public void sendStopSignal(){
		sendSignal=true;
	}
	
	public boolean sentStopSignal(){
		return sendSignal;
	}
	
	public abstract GameScore getScore();
	
}


