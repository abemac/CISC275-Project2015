package stubs;

import java.util.ArrayList;

public class CrabSaveGame extends Game {

	private int numTrashPickedup;
	private ArrayList<Trash> trash;
	private TheHuman theHuman;
	
	
	public CrabSaveGame(){
		
	}

	
	
	@Override
	public void onTick() {
		moveHuman();
		removeTrash();
		
	}
	
	
	
	public void moveHuman(){};
	public void removeTrash(){};
	
}
