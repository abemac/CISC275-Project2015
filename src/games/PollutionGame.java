package games;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import enemies.Pollutant;

/**
 * Models the Pollution Game
 * @author abraham
 *
 */
public class PollutionGame extends Game {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4135658807008338789L;
	private int numCollided;
	private int numRemoved;
	private ArrayList<Pollutant> pollutants;
	
	/**
	 * calls the super constructor
	 */
	public PollutionGame(){
		super();
		
	}

	/**
	 * gets called 60 times per second.  Handles updating
	 */
	@Override
	public void onTick() {
		
		
	}
	/**
	 * defines how to draw the pollution game
	 */
	public void render(Graphics2D g){
		
	}
	
	/**
	 * starts the pollution flow
	 */
	public void startPollutionFlow(){};
	/**
	 * stops the pollution flow
	 */
	public void stopPollutionFlow(){}

	/**
	 * 
	 * @return the number of pollution ojbects the fish has collided with
	 */
	public int getNumCollided() {
		return numCollided;
	}
	/**
	 * 
	 * @return the numbmer of pollution objects the fish has helped remove
	 */
	public int getNumRemoved() {
		return numRemoved;
	}
	
	/**
	 * @return the ArrayList of pollutants
	 */
	public ArrayList<Pollutant> getPollutants() {
		return pollutants;
	};
	
	/**
	 * returns whether or not this game is done
	 * @return boolean whether or not game is done
	 */
	public boolean isDone(){
		return true;
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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
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
