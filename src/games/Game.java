package games;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

import misc.Renderable;
import misc.Tickable;

/**
 * Game is an overarching class that implements main loop control the game. It handles calling updates 
 * at 60Hz and handles rendering also, using the View class in our view package
 * @author abraham
 *
 */
public abstract class Game implements Serializable,Tickable,Renderable,KeyListener,MouseListener,MouseMotionListener{

	
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
	
	
	
	public abstract boolean isFinished();
	
	
	/**
	 * saves the current game state to a file
	 */
	public void saveGameState(){};
	
	
}


