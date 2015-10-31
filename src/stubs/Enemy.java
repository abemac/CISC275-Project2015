package stubs;

public abstract class Enemy {

	private double xPos,yPos;
	private int health;
	
	public Enemy(){
		
	}
	
	
	
	public abstract void act();
	
	public void onTick(){
		act();
	}
	
	
	public double getX(){
		return xPos;
	}
	public double getY(){
		return yPos;
	}
	
	public int getHealth(){
		return health;
	}
	
	
	
	
	
	
		
}
