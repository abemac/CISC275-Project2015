package enemies;

import java.awt.Graphics2D;

/**
 * Trash is a class that models many different trash types
 * @author abraham
 *
 */
public class Trash extends Enemy {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2923480295498027702L;
	// Different Trash that will need to be picked up to clean Estuary 
	/**
	 * constant for Bananas
	 */
	public static final int BANANA =0;
	/**
	 * constant for Tires
	 */
	public static final int TIRE =1;
	/**
	 * constant for soda cans
	 */
	public static final int SODA_CAN =2;
	/**
	 * constant for books
	 */
	public static final int BOOK =3;
	/**
	 * constant for garbage bags
	 */
	public static final int GARBAGE_BAG =4;
	/**
	 * constant for shopping cart
	 */
	public static final int SHOPPING_CART =5;
	
	/**
	 * stores the type of the Trash
	 */
	private int type;
	
	/**
	 * the constructor for Trash initializes x,y,and type
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param type the initial type
	 */
	public Trash(double xPos,double yPos,int type){
		super(xPos,yPos);
		this.type = type;
	}

	/**
	 * implements act() from Enemy
	 */
	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}
	
	public void render(Graphics2D g){
		
	}

	 /**
	  * 
	  * @return the type of the trash
	  */
	public int getType(){
		return type;
	}
}
