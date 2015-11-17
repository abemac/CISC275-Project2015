package misc;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

/**
 * class to model the trash can in game 2
 * @author abraham
 *
 */
public class TrashCan implements Tickable,Renderable,Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6648940524863588982L;
	private double xPos,yPos;
	private BufferedImage trashCan,trashCanOverlay;

	/**
	 * creates a trash can with position x and y
	 * @param xPos the x position of the trash
	 * @param yPos the y position of the trash
	 */
	public TrashCan (double xPos,double yPos){
		this.xPos=xPos;
		this.yPos=yPos;
		loadRes();
	}
	
	/**
	 * loads the resources need for a trash can. Gets called in the constructor
	 */
	private void loadRes(){
		try {
			trashCan=Util.loadImage("/RubbishBin.png",400,600, this);
			trashCanOverlay=Util.loadImage("/RubbishBinOverlay.png",400,600, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * defines how to render a trash can
	 * @param g the graphics to use to draw
	 */
	@Override
	public void render(Graphics2D g) {
		g.drawImage(trashCan, (int)xPos, (int)yPos, null);
		
	}
	/**
	 * defines how to render the overlay for the trash can to give the illusion of things going 
	 * into the trash
	 * @param g the graphics to use to draw
	 */
	public void renderOverlay(Graphics2D g){
		g.drawImage(trashCanOverlay, (int)xPos, (int)yPos, null);
	}

	
	/**
	 * updates to the trash can, if needed
	 */
	@Override
	public void onTick() {
		
		
	}
	
	
	
}
