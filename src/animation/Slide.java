package animation;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.Util;

public class Slide {

	
	private BufferedImage image;
	private double time;
	private long timeDisplayed=0;
	private java.awt.Color color;
	
	private static final int TYPE_COLOR=0;
	private static final int TYPE_IMAGE=1;
	private boolean finalSlide=false;
	private final int type;
	
	private boolean fadedIn;
	private double fade_time_in = 120.0;
	private double fade_time_out=120.0;
	private float alpha=0f;
	
	private boolean fadeIn=true;
	private boolean fadeOut=true;
	
	private double timeBlackAfterFadeOut=40.0;
	
	/**
	 * creates a slide that will display an image
	 * @param image SCALE the image before you put it in here please
	 * @param time in seconds
	 */
	public Slide(String image,double time){
		try {
			this.image=Util.loadImage(image,Util.getCANVAS_WIDTH_SCALED(),Util.getCANVAS_HEIGHT_SCALED(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.time=time*60;
		type=TYPE_IMAGE;
	}
	/**
	 * creates a slide that will display an image
	 * @param image SCALE the image before you put it in here please
	 * @param time in seconds
	 */
	public Slide(BufferedImage image,double time){
		this.image=image;
		this.time=time*60;
		type=TYPE_IMAGE;
	}
	
	/**
	 * creates a slide that shows only one color, specified by the color parameter
	 * @param color in java.awt
	 * @param time in seconds
	 */
	public Slide(java.awt.Color color,double time){
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
		g.setComposite(AlphaComposite.getInstance(
	            AlphaComposite.SRC_OVER, alpha));
	    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		
	    if(type==TYPE_IMAGE){
			g.drawImage(image, -Util.getDISTANCE_TO_EDGE(),-1000,null);
		}
		else if (type==TYPE_COLOR){
			g.setColor(color);
			g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), Util.getCANVAS_HEIGHT_SCALED());
		}
		
	    
	    if(fadeIn && !fadedIn){
	    	alpha+=1/fade_time_in;
	    	if(alpha>=1.0){
	    		alpha=1.0f;
	    		fadedIn=true;
	    	}
	    }
	    
	    else if (fadeOut && timeDisplayed >= time-fade_time_out){
	    	alpha-=1/fade_time_out;
	    	if(alpha<=0){
	    		alpha=0f;
	    	}
	    }
	    
		timeDisplayed++;
		return (timeDisplayed>=time+timeBlackAfterFadeOut);
	}
	
	
	/**
	 * resets the timer on this slide.  Don't use it really
	 */
	public void reset(){
		timeDisplayed=0;
	}
	
	
	
	public void setTimeBlackAfterFadeOut(double timeBlackAfterFadeOut) {
		this.timeBlackAfterFadeOut = timeBlackAfterFadeOut;
	}
	
	/**
	 * sets fade time 
	 * @param d in secondds
	 */
	public void setFadeInTime(double d ){	
		this.fade_time_in=d*60.0;
		if(fade_time_in==0){
			fadeIn=false;
		}
	}
	
	/**
	 * 
	 * @param d in seconds
	 */
	public void setFadeOutTime(double d){
		this.fade_time_out=d*60.0;
		if(fade_time_out==0){
			fadeOut=false;
		}
	}
	
	public void setFinalSlide(boolean finalSlide) {
		this.finalSlide = finalSlide;
	}
	
	public void setFadeIn(boolean fadeIn) {
		this.fadeIn = fadeIn;
		alpha=1f;
	}
	public void setFadeOut(boolean fadeOut) {
		this.fadeOut = fadeOut;
	}
	
}