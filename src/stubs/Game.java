package stubs;

public abstract class Game implements Runnable{

	
	
	public Game(){			// Game constructor with initializer
		init();
	} //Game()
	
	
	public void init(){}	// Initializes the game
	
	
	
	
	public synchronized void start(){};	// sart game
	
	public synchronized void stop(){};	//stop game
	
	
	public void run(){}
	
	
	public abstract void onTick();	// updates changes to the game
	
	
	
	
	
}


