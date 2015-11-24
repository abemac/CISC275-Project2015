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
	private double angle=0.0;
	private boolean hasPollutant;
	private double scaleVel;
	private int index;
	private Pollutant attachedPollutant;
	
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
		
		if(scale>0.2){
			scaleVel-=.01;
		}
		
		if(scaleVel<=0){
			scaleVel=0;
		}
		scale+=scaleVel;
		
	}
	
	/**
	 * @param g renders the graphics
	 */
	@Override
	public void render(Graphics2D g){
		g.translate((xPos), yPos);
		g.rotate(angle);
		g.drawImage(bubble,0,0,-(int)(200*scale),-(int)(200*scale), null);
		
		g.rotate(-angle);
		g.translate(-xPos, -yPos);
	}
	
	
	/**
	 * causes this bubble to go from the fish
	 * 
	 */
	public void shootFromFish(double xPos,double yPos,double angle,double crabX,double crabY){
		this.xVel=3*Math.cos(angle-Math.PI/2f-.2);
		this.yVel=1*Math.sin(angle-Math.PI/2f);
		this.angle=angle;
		double dx=xPos-(crabX);
		double dy=yPos-(crabY);
		double polarR=Math.sqrt(dx*dx+dy*dy)+20;
		this.xPos=crabX+polarR*Math.cos(Math.PI/2f-angle);
		this.yPos=crabY-polarR*Math.sin(Math.PI/2f-angle);
		scale=0.2;
		scaleVel=.14;
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
	
	public void attacheToPollutant(Pollutant p) {
		this.hasPollutant = true;
		this.attachedPollutant=p;
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
