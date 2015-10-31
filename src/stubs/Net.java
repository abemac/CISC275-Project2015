package stubs;

public class Net extends Enemy {

	// Two types of nets will be used to capture the fish in OverfishingGame
	// Fish will avoid both - Big net can capture more fish in one try
	public static int BIGNET = 0;
	public static int LILNET = 1;
	
	private int type; 
	// Use this method to select type of net enemy we want to launch
	public Net(int type){
		this.type = type;
	}
	
	// Movement of the fishnet will be random as fish try to avoid them
	@Override
	public void act() {
		moveRandomly();
		
	}
	
	public void moveRandomly(){
		
	}

	
	
	
	
}
