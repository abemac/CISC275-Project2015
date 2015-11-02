package enemies;

public class Pollutant extends Enemy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7101253794644730026L;
	// Forms of Pollutants
	public static final int OIL = 0;
	public static final int SEWAGE = 1;
	public static final int FERTILIZER = 2;

	private int type;	// Will be used to launch pollutant into game
	private boolean isRemoved; // Make true if user has cleaned up the pollutatn
	private int nastiness;
	private double sourcePos; // Position of the pollutant
	
	// call to decide type of pollutant
	public Pollutant(int type){
		this.type = type;
	}
	
	// When called, this method will cause the pollutants to flow down the screen 
	@Override
	public void act() {
		floatDown();
		
	}
	// Get position and set logic for how pollutants will move on the screen
	public void floatDown(){
		
	}
	
	
	
	public int getType(){
		return type;
	}

}
