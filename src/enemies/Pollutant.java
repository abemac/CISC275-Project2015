package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.ArbitraryLine;
import misc.Util;
import misc.Vector;

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
	private boolean isRemoved;
	private Vector position,velocity;
	private Vector initialPos;
	private double angle;
	private double rotationSpeed;
	private static ArbitraryLine seaFloor;
	private static BufferedImage fertilizer,sewage,oil;
	
	/**
	 * Creates a pollutant with initial x,y,and type. The nastiness of the Pollutant is determined by the type
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param type the type.  One of the static constants defined in Pollutant
	 */
	public Pollutant(Vector initialPosition,Vector velocity,double rotationSpeed,int type,ArbitraryLine seaFloor){
		super(initialPosition.getX(),initialPosition.getY());
		this.initialPos=initialPosition;
		this.type = type;
		this.position = initialPosition;
		this.velocity = velocity;
		this.rotationSpeed=rotationSpeed;
		this.seaFloor=seaFloor;
		loadRes();
	}
	
	
	private void loadRes(){
		if(type==FERTILIZER && fertilizer==null){
			try {
				fertilizer=Util.loadImage("/fertilizer.png", this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(type == OIL && oil==null){
			try {
				oil=Util.loadImage("/oilspill.png", this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(type == SEWAGE && sewage==null){
			try {
				sewage=Util.loadImage("/sewagefornow.png", this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 *  Implements act() from Enemy 
	 */
	
	@Override
	public void act() {
		floatDown();
		
	}
	/**
	 *  defines the the way in which the pollutant floats down from the top of the screen
	 * 
	 */
	public void floatDown(){
		position.add(velocity);
		if(position.getX()>Util.getDISTANCE_TO_EDGE()){
			
		}
		angle+=rotationSpeed;
	}
	
	
	/**
	 * renders graphics
	 */
	public void render(Graphics2D g){
		g.translate(position.getX(),position.getY());
		g.rotate(angle);
		
		if(type==FERTILIZER){
			g.drawImage(fertilizer, 0,0, null);
		}else if(type==OIL){
			g.drawImage(oil, 0,0, null);
		}
		else if(type==SEWAGE){
			g.drawImage(sewage, 0,0, null);
		}
		
		g.rotate(-angle);	
		g.translate(-position.getX(), -position.getY());
	}
	
	
	
	/**
	 * 
	 * @return the type of this Pollutant
	 */
	public int getType(){
		return type;
	}

}
