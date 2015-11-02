package games;

import java.io.Serializable;

public abstract class Game implements Runnable,Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7877285904741522154L;
	private boolean running= false;
	public Game(){			// Game constructor with initializer
		init();
	} //Game()
	
	// Initializes the game
	public void init(){}
	
	
	
	// start game
	public synchronized void start(){};
	
	//stop game
	public synchronized void stop(){};
	
	// run game
	public void run(){}
	
	// updates changes to the game
	public abstract void onTick();
	
	
	
	public boolean isRunning(){
		return running;
	}
	
	
	
}


