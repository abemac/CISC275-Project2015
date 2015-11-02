package enemies;

public abstract class Enemy {

	private double xPos,yPos;	//Enemy has location
	private int health;			//Enemy has health
	
	public Enemy(){
		//create enemies with x and y position and health level
	}
	
	
	
	public abstract void act(); //enemies will do something to attack Character
	
	public void onTick(){
		//this will update act 60 times/sec
		act();
	}
	
	
	public double getX(){
		//returns X position of Enemy
		return xPos;
	}
	public double getY(){
		//returns Y position of Enemy
		return yPos;
	}
	
	public int getHealth(){
		//return health of Enemy
		return health;
	}
	
	public void decreaseHealth(int h){
		health-=h;
	}
	
	
	
	
	
	
		
}
