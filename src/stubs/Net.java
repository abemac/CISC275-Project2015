package stubs;

public class Net extends Enemy {

	public static int BIGNET = 0;
	public static int LILNET = 1;
	
	private int type;
	public Net(int type){
		this.type = type;
	}
	
	@Override
	public void act() {
		moveRandomly();
		
	}
	
	public void moveRandomly(){
		
	}

	
	
	
	
}
