package enemies;

import java.awt.Graphics2D;

/**
 * the Hook class is used to model hooks
 * @author abraham
 *
 */
public class Hook extends Enemy {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4415134457991027093L;
	private int size;
	
	
	/**
	 * Creates a hook with initial x,y,and size
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param size the size of this hook
	 */
	public Hook(double xPos,double yPos,int size){
		super (xPos,yPos);
		this.size = size;
	}

	/**
	 * implements the act() method from Enemy
	 */
	@Override
	public void act() {
		moveRandomly();
		
	}
	
	@Override
	public void render(Graphics2D g){
		
	}
	
	/**
	 * cause the hook to move randomly up and down on the screen
	 */
	private void moveRandomly(){}
	
	

	/**
	 * 
	 * @return the size of the hook
	 */
	public int getSize(){
		return size;
	}
	
	
}
