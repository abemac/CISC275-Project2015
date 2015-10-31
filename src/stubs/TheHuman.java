package stubs;

public class TheHuman extends Enemy{
	
	
	public TheHuman(){			// Human constructor
		
		
	}

	@Override
	public void act() {			// gets called on tick
		walk();
		letGoOfFishIfAttackedByCrab();
		
		
	}
	
	
	public void letGoOfFishIfAttackedByCrab(){	// ends the game
		
	}
	
	public void walk(){		// changes the position of the humanl;
		
	}

}
