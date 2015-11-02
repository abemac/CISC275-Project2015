package enemies;

public class TheHuman extends Enemy{
	
	
	// Human constructor
	public TheHuman(){	
		
		
	}

	// gets called on tick
	@Override
	public void act() {		
		walk();
		letGoOfFishIfAttackedByCrab();
		
		
	}
	
	
	// ends the game
	public void letGoOfFishIfAttackedByCrab(){
		
	}
	
	// changes the position of the human;
	public void walk(){
		
	}

}
