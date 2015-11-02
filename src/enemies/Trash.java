package enemies;

public class Trash extends Enemy {
	// Different Trash that will need to be picked up to clean Estuary 
	public static final int BANANA =0;
	public static final int TIRE =1;
	public static final int SODA_CAN =2;
	public static final int BOOK =3;
	public static final int GARBAGE_BAG =4;
	public static final int SHOPPING_CART =5;
	
	
	private int type;
	
	
	public Trash(int type){
		this.type = type;
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}
	
	
	public int getType(){
		return type;
	}
}
