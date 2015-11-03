package enemies;

public class TheHuman extends Enemy{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -410465131603543966L;

	// Human constructor
	public TheHuman(double xPos,double yPos){
		super(xPos,yPos);
		
	}

	// gets called on tick
	@Override
	public void act() {		
		walk();
		letGoOfFishIfAttackedByCrab();
		
		
	}
	
	
	// ends the game
	public void letGoOfFishIfAttackedByCrab(){
		
	}
	
	// changes the position of the human;
	public void walk(){
		
	}

}
