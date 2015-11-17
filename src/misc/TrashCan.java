package misc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TrashCan implements Tickable,Renderable{

	
	private double xPos,yPos;
	private BufferedImage trashCan,trashCanOverlay;

	public TrashCan (double xPos,double yPos){
		this.xPos=xPos;
		this.yPos=yPos;
		loadRes();
	}
	
	
	private void loadRes(){
		try {
			trashCan=Util.loadImage("/RubbishBin.png",400,600, this);
			trashCanOverlay=Util.loadImage("/RubbishBinOverlay.png",400,600, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void render(Graphics2D g) {
		g.drawImage(trashCan, (int)xPos, (int)yPos, null);
		
	}
	
	public void renderOverlay(Graphics2D g){
		g.drawImage(trashCanOverlay, (int)xPos, (int)yPos, null);
	}

	@Override
	public void onTick() {
		
		
	}
	
	
	
}
