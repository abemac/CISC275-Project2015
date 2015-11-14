package misc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SeaBottom implements Renderable,Tickable {
	
	private int xPos=-Util.DISTANCE_TO_EDGE;;
	private int xPos2 = Util.DISTANCE_TO_EDGE*3-30;
	
	
	private static BufferedImage seaFloor;
	
	
	public SeaBottom(){
		loadRes();
		
	}
	
	public void loadRes(){
		try {
			seaFloor = Util.loadImage("/sea floor.png", this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTick() {
		xPos-=6;
		xPos2-=6;
		if(xPos<=-5*Util.DISTANCE_TO_EDGE){
			xPos=xPos2+(Util.DISTANCE_TO_EDGE*4-30);
			
		}
		else if(xPos2<=-Util.DISTANCE_TO_EDGE * 5){
			xPos2=xPos+Util.DISTANCE_TO_EDGE*4-30;
			
		}
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(seaFloor, xPos,250,Util.DISTANCE_TO_EDGE*4,750,null);
		g.drawImage(seaFloor, xPos2, 250, Util.DISTANCE_TO_EDGE*4, 750, null);
	}
	
	
	
	public boolean isIn(characters.Character c){
		
		return false;
	}
	

}
