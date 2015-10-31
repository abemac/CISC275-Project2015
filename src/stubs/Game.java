package stubs;

public abstract class Game implements Runnable{

	
	
	public Game(){
		init();
	}
	
	
	public abstract void init();
	
	
	
	
	public synchronized void start(){};
	
	public synchronized void stop(){};
	
	
	public void run(){}
	
	
	private void onTick(){};
	
	private void render(){};
	
	
	
	
}


