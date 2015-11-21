package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.Util;

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
	 * constant for Bottle
	 */
	public static final int BOTTLE =1;
	/**
	 * constant for soda cans
	 */
	public static final int SODA_CAN =2;
	/**
	 * constant for ropes
	 */
	public static final int ROPE =3;
	/**
	 * constant for shopping bags
	 */
	public static final int SHOPPING_BAG =4;
//	/**
//	 * constant for shopping cart
//	 */
//	public static final int SHOPPING_CART =5;
	
	public static final int MILK_JUG=5;
	/**
	 * stores the type of the Trash
	 */
	private int type;
	private double scale=1;
	
	public static int getRandomType(){
		return (int) (Math.random()*6);
	}
	
	
	private static boolean loadedImages=false;
	private static BufferedImage banana,sodaCan,bottle,rope,shoppingBag,milkJug=null;
	/**
	 * the constructor for Trash initializes x,y,and type
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param type the initial type
	 */
	public Trash(double xPos,double yPos,int type){
		super(xPos,yPos);
		this.type = type;
		loadRes();
	}
	
	
	private void loadRes(){
		if(!loadedImages){
			try{
				banana=Util.loadImage("/banana.png", this);
				sodaCan=Util.loadImage("/soda.png", this);
				bottle=Util.loadImage("/bottle.png", this);
				rope=Util.loadImage("/Rope.png", this);
				shoppingBag=Util.loadImage("/plasticbag.png",this);
				milkJug=Util.loadImage("/MilkGallon.png", this);
				
				
			}catch(IOException e){
				e.printStackTrace();
			}
			loadedImages=true;
		}
	}

	/**
	 * implements act() from Enemy
	 */
	@Override
	public void act() {
		// TODO Auto-generated method stub
		scale = (yPos+1000)/1000f;
		
	}
	/**
	 * renders graphics
	 */
	public void render(Graphics2D g){
		switch(type){
			case BANANA: g.drawImage(banana, (int)xPos, (int)yPos,(int)(340*scale),(int)(200*scale), null);break;
			case SODA_CAN: g.drawImage(sodaCan, (int)xPos, (int)yPos,(int)(200*scale),(int)(250*scale), null);break;
			case BOTTLE: g.drawImage(bottle, (int)xPos, (int)yPos,(int)(200*scale),(int)(375*scale), null);break;
			case MILK_JUG: g.drawImage(milkJug, (int)xPos, (int)yPos,(int)(500*scale),(int)(500*scale), null);break;
			case SHOPPING_BAG: g.drawImage(shoppingBag, (int)xPos, (int)yPos,(int)(395*scale),(int)(450*scale), null);break;
			case ROPE: g.drawImage(rope, (int)xPos, (int)yPos,(int)(500*scale),(int)(500*scale), null);break;
		}
		
		
	}

	 /**
	  * 
	  * @return the type of the trash
	  */
	public int getType(){
		return type;
	}
	
	public double getWidth(){
		switch(type){
			case BANANA: return(340*scale);
			case SODA_CAN: return (200*scale);
			case BOTTLE: return(200*scale);
			case MILK_JUG: return(500*scale);
			case SHOPPING_BAG:return(395*scale);
			case ROPE: return(500*scale);
			default: return-1;
	}
	}
	
	public double getHeight(){
		switch(type){
			case BANANA: return(200*scale);
			case SODA_CAN: return(250*scale);
			case BOTTLE: return(375*scale);
			case MILK_JUG: return(500*scale);
			case SHOPPING_BAG: return(450*scale);
			case ROPE: return(500*scale);
			default:return -1;
	}
	}
	
	public double getScale(){
		return scale;
	}
	
	
}
