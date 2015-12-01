package animation;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import misc.Util;

public class Slide {

	
	private BufferedImage image;
	private int time;
	private long timeDisplayed=0;
	private java.awt.Color color;
	
	private static final int TYPE_COLOR=0;
	private static final int TYPE_IMAGE=1;
	private final int type;
	
	/**
	 * creates a slide that will display an image
	 * @param image SCALE the image before you put it in here please
	 * @param time in seconds
	 */
	public Slide(BufferedImage image,int time){
		this.image=image;
		this.time=time*60;
		type=TYPE_IMAGE;
	}
	
	/**
	 * creates a slide that shows only one color, specified by the color parameter
	 * @param color in java.awt
	 * @param time in seconds
	 */
	public Slide(java.awt.Color color,int time){
		this.color = color;
		this.time = time*60;
		type=TYPE_COLOR;
	}
	
	
	/**
	 * displays this slide to the graphics2d g, and returns true after it has been displayed for its time
	 * you can only display once.  If you want to display again, you must call reset() on a slide.
	 * However, if you call this function after it returns false, it will still draw to the screen. But it returned false so you 
	 * would know not to call it anymore.
	 * @param g
	 * @return true if it has displayed for its amount of time, false otherwise
	 */
	public boolean display(Graphics2D g){
		
		if(type==TYPE_IMAGE){
			g.drawImage(image, -Util.getDISTANCE_TO_EDGE(),-1000,null);
		}
		else if (type==TYPE_COLOR){
			g.setColor(color);
			g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), Util.getCANVAS_HEIGHT_SCALED());
		}
		
		timeDisplayed++;
		return (timeDisplayed>=time);
	}
	
	
	/**
	 * resets the timer on this slide.  Don't use it really
	 */
	public void reset(){
		timeDisplayed=0;
	}
	
	
	
	
}
