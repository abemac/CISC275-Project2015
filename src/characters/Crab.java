package characters;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import enemies.TheHuman;
import enemies.Trash;

/**
 * Crab is a model class for the crab character that the player controls
 * @author abraham
 *
 */

public class Crab extends Character{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2918553662290310728L;
	private int angriness;		//anger level of crab
	
	/**
	 * makes a Character Crab which has xPos, yPos, health, and angriness
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param angriness the initial angriness
	 */
	public Crab(double xPos, double yPos, int health,int angriness) {
		super(xPos, yPos, health);
		this.angriness = angriness;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * creates a Crab with initial x,y and angriness, with default health value
	 * @param xPos the initial x position
	 * @param yPos this initial y posistion
	 * @param angriness the initial angriness
	 */
	public Crab(double xPos, double yPos,int angriness) {
		super(xPos, yPos);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * implements Crab throwing object trash
	 * @param t the thrash object to throw
	 */
	public void throwTrash(Trash t){
		
	}
	
	

	/**
	 * moves the crab according to how a crab moves
	 * @param dx the change in x
	 * @param dy the change in y
	 */
	@Override
	public void move(double dx,double dy){
		
	}
	
	
	/**
	 * Crab attacks Human, when Human health reaches 0, Crab saves Fish
	 * @param human
	 */
	public void pinchHumanToGetFish(TheHuman human){
		
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



	

}
