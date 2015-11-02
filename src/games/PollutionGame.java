package games;

import java.util.ArrayList;

import enemies.Pollutant;

public class PollutionGame extends Game {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4135658807008338789L;
	private int numCollided;
	private int numRemoved;
	private ArrayList<Pollutant> pollutants;
	
	public PollutionGame(){
		
		
	}

	@Override
	public void onTick() {
		
		
	}
	
	
	
	public void startPollutionFlow(){};
	public void stopPollutionFlow(){}

	public int getNumCollided() {
		return numCollided;
	}

	public int getNumRemoved() {
		return numRemoved;
	}

	public ArrayList<Pollutant> getPollutants() {
		return pollutants;
	};
	
	

}
