package stubs;

public abstract class Character {

	
	
	
	private double xPos,yPos;
	private int health;
	
	
	public Character(){
		
	}
	
	
	public abstract void move();
	
	
	public void onTick(){
		
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
