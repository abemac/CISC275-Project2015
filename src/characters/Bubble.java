package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import enemies.Pollutant;
import misc.Util;

/**
 * Bubble is the model class for the bubbles that the Fish fires in the PollutionGame
 * @author abraham
 *
 */
public class Bubble extends Character{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3339567082395475772L;
	private static BufferedImage bubble;
	private double xVel,yVel;
	private static final double SHOOT_VELOCITY=20;
	
	private boolean hasPollutant;
	
	/**
	 * Creates a bubbles
	 */
	public Bubble(){
		super(0,0);
		loadRes();
		
	}

	private void loadRes(){
		if(bubble==null){
			try {
				bubble =Util.loadImage("/BubbleSortOfTransparent.png",200,200, this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * implements onTick() from character
	 */
	@Override
	public void onTick() {	
		
		floatToTop();
		if(xVel>0){
			xVel-=1;
		}else if(xVel<0){
			xVel+=1;
		}
		
		
	}
	
	/**
	 * @param g renders the graphics
	 */
	@Override
	public void render(Graphics2D g){
		g.drawImage(bubble,(int) xPos,(int) yPos, null);
		
	}
	
	
	/**
	 * causes this bubble to go from the fish
	 * 
	 */
	public void shootFromFish(double xPos,double yPos,double angle){
		this.xVel=SHOOT_VELOCITY*Math.cos(angle);
		this.yVel=SHOOT_VELOCITY*Math.sin(angle);
		this.xPos=xPos;
		this.yPos=yPos;
	}
	
	/**
	 * causes the bubble to float to the top after it surrounds pollution
	 */
	public void floatToTop(){
		if(yVel<-10){
			yVel+=1;
		}else if (yVel>10){
			yVel-=1;
		}
	}
	
	
	public boolean hasPollutant(){
		return hasPollutant;
	}
	
	public void setHasPollutant(boolean hasPollutant) {
		this.hasPollutant = hasPollutant;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}
	
	
}
