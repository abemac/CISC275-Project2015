package games;

import java.awt.Graphics;
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
	
	public void render(Graphics g){
		
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
	
	

}
