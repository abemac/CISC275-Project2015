package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import animation.SpriteSheet;
import misc.Util;

/**
 * TheHuman is a class for modeling the human in the Crab Save game. It is called "TheHuman" for reasons
 * no one can explain. The existence of its name is utterly inexplicable, from a certain point of view. Q.E.D.
 * @author abraham
 *
 */
public class TheHuman extends Enemy{
	
	private SpriteSheet human;
	private int spriteNum=1;
	/**
	 * 
	 */
	private static final long serialVersionUID = -410465131603543966L;
	private boolean hasFish;
	
	/**
	 * Creates a human with an initial x and y
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 */
	public TheHuman(double xPos,double yPos){
		super(xPos,yPos);
		loadRes();
		
	}
	
	private void loadRes(){
		BufferedImage pic = null;
		
		try {
			pic = Util.loadImage("/HumanPicFish.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		human = new SpriteSheet(pic, 1, 2, 300, 200);
		
	}

	/**
	 * implements act() from enemy
	 */
	@Override
	public void act() {		
		walk();
		letGoOfFishIfAttackedByCrab();
		
		
	}
	/**
	 * renders graphics
	 */
	public void render(Graphics2D g){
		g.drawImage(human.getSprite(1, spriteNum), (int)xPos, (int)yPos, null);
	}
	/**
	 * performs  a check to see if it is attacked by the crab.  It then will let got of the fish
	 */
	public void letGoOfFishIfAttackedByCrab(){
		
	}
	
	/**
	 * defines the walking behavior of the human
	 */
	public void walk(){
		
	}
	
	/**
	 * 
	 * @return whether or not TheHuman has the fish
	 */
	public boolean hasFish(){
		return hasFish;
	}

}
