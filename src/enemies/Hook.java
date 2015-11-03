package enemies;

public class Hook extends Enemy {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -4415134457991027093L;
	private int size;
	
	public Hook(double xPos,double yPos,int size){
		super (xPos,yPos);
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
