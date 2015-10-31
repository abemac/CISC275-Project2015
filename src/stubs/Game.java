package stubs;

public abstract class Game implements Runnable{

	
	
	public Game(){			// Game constructor with initializer
		init();
	} //Game()
	
	// Initializes the game
	public void init(){}
	
	
	
	// start game
	public synchronized void start(){};
	
	//stop game
	public synchronized void stop(){};
	
	// run games
	public void run(){}
	
	// updates changes to the game
	public abstract void onTick();
	
	
	
	
	
}


