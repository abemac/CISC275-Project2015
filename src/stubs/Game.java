package stubs;

public abstract class Game implements Runnable{

	
	
	public Game(){
		init();
	}
	
	
	public void init(){}
	
	
	
	
	public synchronized void start(){};
	
	public synchronized void stop(){};
	
	
	public void run(){}
	
	
	public abstract void onTick();
	
	
	
	
	
}


