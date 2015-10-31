package stubs;

import java.util.ArrayList;

public class OverfishingGame extends Game {

	
	private int numFishLost;
	private int distance;
	private ArrayList<Fish> school;
	private ArrayList<Enemy> enemies;
	
	
	public OverfishingGame(){
		
	}


	@Override
	public void onTick() {
		

		randomlyMoveNetsAndHooks();
		checkAndRemoveFish();
		
	}
	
	
	private void randomlyMoveNetsAndHooks(){};
	private void checkAndRemoveFish(){};
	
	

}
