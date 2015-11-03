package characters;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Fish is a model class for the fish that the player controls
 * @author abraham
 *
 */
public class Fish extends Character {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1015644809982634515L;
	
	
	
	private boolean hasCollided;
	
	/**
	 * Creates a fish with initial x,y, and health
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param health the initial health
	 */
	
	public Fish(double xPos, double yPos, int health) {
		super(xPos, yPos, health);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Creates a fish with initial x,y and default health value
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 */
	public Fish(double xPos, double yPos) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * implements move according to how a fish moves
	 * @param dx the change in x 
	 * @param dy the change in y
	 */
	@Override
	public void move(double dx, double dy) {
		
		
	}
	
	

	/////*** listeners ***///////
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
	



	
	
}