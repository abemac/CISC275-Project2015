package enemies;

import java.awt.Graphics2D;

/**
 * The Pollutant class is used to model different types of pollutants
 * @author abraham
 *
 */
public class Pollutant extends Enemy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7101253794644730026L;
	// Forms of Pollutants
	/**
	 * constant for oil
	 */
	public static final int OIL = 0;
	/**
	 * constant for sewage
	 */
	public static final int SEWAGE = 1;
	/**
	 * constant for fertilizer
	 */
	public static final int FERTILIZER = 2;

	/**
	 * stores the type of Pollutant.  Either Pollutant.OIL, Pollutant.SEWAGE, or Pollutant.FERTILIZER
	 */
	private int type;
	private boolean isRemoved; // Make true if user has cleaned up the pollutatn
	private int nastiness;
	private double sourcePos; // Position of the pollutant
	
	/**
	 * Creates a pollutant with initial x,y,and type. The nastiness of the Pollutant is determined by the type
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param type the type.  One of the static constants defined in Pollutant
	 */
	public Pollutant(double xPos,double yPos,int type){
		super(xPos,yPos);
		this.type = type;
	}
	
	/**
	 *  Implements act() from Enemy 
	 */
	@Override
	public void act() {
		floatDown();
		
	}
	/**
	 * renders graphics
	 */
	public void render(Graphics2D g){
		
	}
	
	/**
	 *  defines the the way in which the pollutant floats down from the top of the screen
	 * 
	 */
	public void floatDown(){
		
	}
	
	/**
	 * 
	 * @return the type of this Pollutant
	 */
	public int getType(){
		return type;
	}

}
