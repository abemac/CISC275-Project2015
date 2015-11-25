package enemies;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import characters.Bubble;
import misc.Point;
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
	private Vector position,velocity;
	private double angle;
	private double rotationSpeed;
	private static BufferedImage fertilizer,sewage,oil;
	private boolean out=false;
	
	private boolean fixedToBubble=false;
	private Bubble cleanMe;
	private double initVx,initVy;
	private int index;
	
	/**
	 * Creates a pollutant with initial x,y,and type. The nastiness of the Pollutant is determined by the type
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param type the type.  One of the static constants defined in Pollutant
	 */
	public Pollutant(Vector initialPosition,Vector velocity,double rotationSpeed,int type){
		super(initialPosition.getX(),initialPosition.getY());
		this.type = type;
		this.position = initialPosition;
		this.velocity = velocity;
		initVx=velocity.getX();
		initVy=velocity.getY();
		
		this.rotationSpeed=rotationSpeed;
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
		if(!fixedToBubble)
			floatDown();
		else if (fixedToBubble){
			Point bcenter=cleanMe.getCenterPoint();
			Point pcenter=this.getCenterPoint();
			velocity.setX((bcenter.x-pcenter.x)/30.0);
			velocity.setY((bcenter.y-pcenter.y)/5.0);
			position.add(velocity);
		}
		
	}
	/**
	 *  defines the the way in which the pollutant floats down from the top of the screen
	 * 
	 */
	public void floatDown(){
		position.add(velocity);
		if(out && position.getX()>Util.getDISTANCE_TO_EDGE()+150){
			position.setX(xPos);
			position.setY(yPos);
			out=false;
		}else if (out && position.getX()<-Util.getDISTANCE_TO_EDGE()-150){
			position.setX(xPos);
			position.setY(yPos);
			out=false;
		}
		else if(out &&position.getY()<-1150){
			position.setX(xPos);
			position.setY(yPos);
			out=false;
		}
		else if(out && position.getY()>1150){
			position.setX(xPos);
			position.setY(yPos);
			out=false;
		}else{
			out=true;
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
//		g.setColor(Color.BLACK);
//		g.drawRect(0, 0, 150, 150);
//		g.setColor(Color.RED);
//		g.fillRect(0, 0, 10, 10);
		
		g.rotate(-angle);	
		g.translate(-position.getX(), -position.getY());
		
//		g.setColor(Color.RED);
//		g.fillOval((int)getCenterPoint().x, (int)getCenterPoint().y, 20, 20);
		
		
	}
	
	

	public Point centerPoint=new Point(0,0);
	public Point getCenterPoint(){
		centerPoint.x=position.getX()+106.07*Math.cos(angle+Math.PI/4.0);
		centerPoint.y=position.getY()+106.07*Math.sin(angle+Math.PI/4.0);
		return centerPoint;
	}
	
	/**
	 * 
	 * @return the type of this Pollutant
	 */
	public int getType(){
		return type;
	}
	
	public int getIndex(){
		return index;
	}

	public void setIndex(int i){
		this.index = i;
	}
	
	public void fixToBubble(Bubble b){
		cleanMe=b;
		fixedToBubble=true;
		
	}
	
	
	private double dx,dy;
	public boolean isIn(Bubble b){
		Point bubbleCenter=b.getCenterPoint();
		Point pollutantCenter= this.getCenterPoint();
		dx = bubbleCenter.x-pollutantCenter.x;
		dy=bubbleCenter.y-pollutantCenter.y;
		return (Math.sqrt(dx*dx+dy*dy)<165);
		
	}
	
	public boolean isInBubble(){
		return fixedToBubble;
	}
	
	public void reset(){
		fixedToBubble=false;
		cleanMe=null;
		position.setX(xPos);
		position.setY(yPos);
		velocity.setX(initVx);
		velocity.setY(initVy);
		out=false;
		
	}
}
