package games;

import java.io.Serializable;
import misc.Tickable;

/**
 * Game is an overarching class that implements main loop control the game. It handles calling updates 
 * at 60Hz and handles rendering also, using the View class in our view package
 * @author abraham
 *
 */
public abstract class Game implements Runnable,Serializable,Tickable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7877285904741522154L;
	private boolean running= false;
	/**
	 * creates a game, calling the initializer (init()) method
	 */
	public Game(){			
		init();
	} 
	
	/**
	 * used to do any initialation required by the game
	 */
	public void init(){}
	
	
	
	/**
	 * starts the main game loop on its own thread
	 */
	public synchronized void start(){};
	
	/**
	 * stops the main game loop
	 */
	public synchronized void stop(){};
	
	/**
	 * implements run() from Runnable.  gets called in start
	 */
	public void run(){}
	
	
	/**
	 * 
	 * @return whether or not the game is currently running
	 */
	public boolean isRunning(){
		return running;
	}
	
	/**
	 * saves the current game state to a file
	 */
	public void saveGameState(){};
	
}


