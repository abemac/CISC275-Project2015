package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import enemies.TheHuman;
import enemies.Trash;
import misc.SpriteSheet;
import misc.Util;

/**
 * Crab is a model class for the crab character that the player controls
 * @author abraham
 *
 */

public class Crab extends Character{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2918553662290310728L;	
	
	private SpriteSheet sprites;
	private int spriteNum=1;
	private int spriteTime=0;
	
	private boolean leftPressed,rightPressed,upPressed,downPressed=false;
	
	
	/**
	 * makes a Character Crab which has xPos, yPos, health
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param angriness the initial angriness
	 */
	public Crab(double xPos, double yPos, int health) {
		super(xPos, yPos, health);
		loadRes();
	}
	
	
	private void loadRes(){
		BufferedImage crabs = null;
		try {
			crabs = Util.loadImage("/crabsprite(150x150).png", this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sprites = new SpriteSheet(crabs, 1, 3, 150, 150);
		
	}
	

	
	public void onTick(){
		
		if(leftPressed){
			if(spriteNum==1){
				spriteNum=3;
			}
			if(spriteTime>=6){
				spriteTime=0;
				if(spriteNum==2){spriteNum=3;}
				else if (spriteNum==3){spriteNum=2;}
			}
			xPos-=10*(yPos+1000)/2000.0;
		}
		if(rightPressed){
			if(spriteNum==1){
				spriteNum=2;
			}
			if(spriteTime>=6){
				spriteTime=0;
				if(spriteNum==2){spriteNum=3;}
				else if (spriteNum==3){spriteNum=2;}
			}
			xPos+=10*(yPos+1000)/2000.0;
		}
		if(upPressed){
			if(spriteNum==1){
				spriteNum=2;
			}
			if(spriteTime>=6){
				spriteTime=0;
				if(spriteNum==2){spriteNum=3;}
				else if (spriteNum==3){spriteNum=2;}
			}
			yPos-=6*(yPos+800)/1500.0;
			xPos+=.5;
		}
		if(downPressed){
			if(spriteNum==1){
				spriteNum=3;
			}
			if(spriteTime>=6){
				spriteTime=0;
				if(spriteNum==2){spriteNum=3;}
				else if (spriteNum==3){spriteNum=2;}
			}
			yPos+=6*(yPos+1000)/1500.0;
			xPos-=.5;
		}
		
		if(leftPressed||rightPressed||upPressed||downPressed)
			spriteTime++;
		else
			spriteTime=0;
	}
	
	@Override
	public void render(Graphics2D g){
		g.drawImage(sprites.getSprite(1, spriteNum), (int)xPos, (int)yPos, (int)(400+yPos/2.5),(int)( 400+yPos/2.5),null);
	}
	
	/**
	 * implements Crab throwing object trash
	 * @param t the thrash object to throw
	 */
	public void throwTrash(Trash t){
		
	}
	
	

	/**
	 * moves the crab according to how a crab moves
	 * @param dx the change in x
	 * @param dy the change in y
	 */
	@Override
	public void move(double dx,double dy){
		
	}
	
	
	/**
	 * Crab attacks Human, when Human health reaches 0, Crab saves Fish
	 * @param human
	 */
	public void pinchHumanToGetFish(TheHuman human){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			leftPressed=true;
		}if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rightPressed=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			upPressed=true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			downPressed=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			spriteNum=1;
			leftPressed=false;
		}if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rightPressed=false;
			spriteNum=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			upPressed=false;
			spriteNum=1;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			downPressed=false;
			spriteNum=1;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	

}
