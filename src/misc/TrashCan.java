package misc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TrashCan implements Tickable,Renderable{

	
	private double xPos,yPos;
	private BufferedImage trashCan;

	public TrashCan (double xPos,double yPos){
		this.xPos=xPos;
		this.yPos=yPos;
		loadRes();
	}
	
	
	private void loadRes(){
		try {
			Util.loadImage("/RubbishBin.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void render(Graphics2D g) {
		g.drawImage(trashCan, (int)xPos, (int)yPos, null);
		
	}

	@Override
	public void onTick() {
		
		
	}
	
	
	
}
