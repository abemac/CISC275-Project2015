package stubs;

public class Pollutant extends Enemy {

	public static final int OIL = 0;
	public static final int SEWAGE = 1;
	public static final int FERTILIZER = 2;

	private int type;
	private boolean isRemoved;
	private int nastiness;
	private double sourcePos;
	
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
