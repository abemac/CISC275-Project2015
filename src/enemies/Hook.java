package enemies;

public class Hook extends Enemy {
	
	

	private int size;
	
	public Hook(int size){
		this.size = size;
	}

	@Override
	public void act() {
		moveRandomly();
		
	}
	
	private void moveRandomly(){}
	
	
	
	public int getSize(){
		return size;
	}
	
	
}
