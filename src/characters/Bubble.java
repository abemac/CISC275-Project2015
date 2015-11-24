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
	private double scale=1.0;
	
	private boolean hasPollutant;
	
	private int index;
	
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
		xPos+=xVel;
		yPos+=yVel;
		
		if(scale<1.0){
			scale+=.04;
		}
	}
	
	/**
	 * @param g renders the graphics
	 */
	@Override
	public void render(Graphics2D g){
		g.drawImage(bubble,(int) (xPos+(1.0-scale)*100),(int) yPos,(int)(200*scale),-(int)(200*scale), null);
		
	}
	
	
	/**
	 * causes this bubble to go from the fish
	 * 
	 */
	public void shootFromFish(double xPos,double yPos,double angle){
		this.xVel=6*Math.cos(angle-Math.PI/2f-.2);
		this.yVel=1*Math.sin(angle-Math.PI/2f);
		this.xPos=xPos;
		this.yPos=yPos;
		scale=0.2;
	}
	
	/**
	 * causes the bubble to float to the top after it surrounds pollution
	 */
	public void floatToTop(){
		if(yVel>-7){
			yVel-=.1;
		}
	}
	
	
	public boolean hasPollutant(){
		return hasPollutant;
	}
	
	public void setHasPollutant(boolean hasPollutant) {
		this.hasPollutant = hasPollutant;
	}
	
	
	public void setIndex(int index) {
		this.index = index;
	}
	public int getIndex() {
		return index;
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
