package stubs;

public class Pollutant extends Enemy {

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
	
	
	@Override
	public void act() {
		floatDown();
		
	}
	
	public void floatDown(){
		
	}
	
	
	
	public int getType(){
		return type;
	}

}
