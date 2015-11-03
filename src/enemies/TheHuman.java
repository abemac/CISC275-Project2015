package enemies;

/**
 * TheHuman is a class for modeling the human in the Crab Save game. It is called "TheHuman" for reasons
 * no one can explain. The existence of its name is utterly inexplicable, from a certain point of view. Q.E.D.
 * @author abraham
 *
 */
public class TheHuman extends Enemy{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -410465131603543966L;
	private boolean hasFish;
	
	/**
	 * Creates a human with an initial x and y
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 */
	public TheHuman(double xPos,double yPos){
		super(xPos,yPos);
		
	}

	/**
	 * implements act() from enemy
	 */
	@Override
	public void act() {		
		walk();
		letGoOfFishIfAttackedByCrab();
		
		
	}
	
	
	/**
	 * performs  a check to see if it is attacked by the crab.  It then will let got of the fish
	 */
	public void letGoOfFishIfAttackedByCrab(){
		
	}
	
	/**
	 * defines the walking behavior of the human
	 */
	public void walk(){
		
	}
	
	/**
	 * 
	 * @return whether or not TheHuman has the fish
	 */
	public boolean hasFish(){
		return hasFish;
	}

}
