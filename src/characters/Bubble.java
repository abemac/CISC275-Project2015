package characters;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import enemies.Pollutant;

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
	private double xPos,yPos;
	
	/**
	 * Creates a Bubble with initial x,y
	 * @param x the initial x position
	 * @param y the initial y position
	 */
	public Bubble(double x, double y){
		super(x,y);
		this.xPos = x;
		this.yPos = y;
	}

	
	/**
	 * implements onTick() from character
	 */
	@Override
	public void onTick() {	
		
	}
	
	@Override
	public void render(Graphics g){
		
	}
	
	
	/**
	 * causes this bubble to go from the fish to a pollution p
	 * @param p the pollution to shoot towards
	 */
	public void shootFromFish(Pollutant p){
		
	}
	
	/**
	 * causes the bubble to float to the top after it surrounds pollution
	 */
	public void floatToTop(){
		
	}
	
	/**
	 * causes the bubble to pop
	 */
	public void pop(){
		
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
