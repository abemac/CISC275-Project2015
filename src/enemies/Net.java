package enemies;

import java.awt.Graphics2D;

/**
 * The Net class is used to model nets
 * @author abraham
 *
 */
public class Net extends Enemy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4749836762438935190L;
	/**
	 * BIGNET is a big, commercial fisherman type of net
	 */
	public static int BIGNET = 0;
	/**
	 * LILNET is a small, single person sized net
	 */
	public static int LILNET = 1;
	
	/**
	 * stores which type the Net is, either BIGNET or LILNET
	 */
	private int type; 
	
	/**
	 * The constructor for net must accept and initial x,y and type
	 * If the type is not Net.BIGNET or Net.LILNET, it will default to Net.LILNET
	 * @param xPos the initial x position of the Net
	 * @param yPos the initial y position of the Net
	 * @param type the type of the Net
	 */
	public Net(double xPos, double yPos,int type){
		super(xPos,yPos);
		this.type = type;
	}
	
	/**
	 * implements act() from enemy
	 */
	@Override
	public void act() {
		moveRandomly();
		
	}
	
	public void render(Graphics2D g){
		
	}
	
	/**
	 * causes the net to move randomly in the y direction on the screen
	 */
	public void moveRandomly(){
		
	}
	
	/**
	 * 
	 * @return the type of the net.  Either Net.BIGNET or Net.LILNET
	 */
	public int getType(){
		return type;
	}

	
	
	
	
}
