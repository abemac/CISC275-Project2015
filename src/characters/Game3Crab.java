package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import enemies.Trash;
import misc.SpriteSheet;
import misc.Util;

public class Game3Crab extends Character{

	
	private SpriteSheet sprites;
	private boolean leftPressed,rightPressed,upPressed,downPressed=false;
	private int spriteNum=1;
	private int spriteTime=0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8431818079245300953L;

	public Game3Crab(double xPos, double yPos, int health) {
		super(xPos, yPos, health);
		loadRes();
	}
	/**
	 * loads the crag image used to represent the Crab character
	 */
	private void loadRes(){
		BufferedImage crabs = null;
		try {
			crabs = Util.loadImage("/crabsprite(150x150).png", this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sprites = new SpriteSheet(crabs, 1, 4, 150, 150);
		
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
			xPos=xPos<-Util.getDISTANCE_TO_EDGE()+5?-Util.getDISTANCE_TO_EDGE()+5:xPos;
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
			xPos=xPos>Util.getDISTANCE_TO_EDGE()-400?Util.getDISTANCE_TO_EDGE()-400:xPos;
		}
		
		if(leftPressed||rightPressed||upPressed||downPressed)
			spriteTime++;
		else
			spriteTime=0;
		
		
	}
	
	@Override
	public void render(Graphics2D g) {
		g.drawImage(sprites.getSprite(1, spriteNum), (int)xPos, (int)yPos, (int)(400+yPos/2.5),(int)( 400+yPos/2.5),null);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
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

	@Override
	public void move(double dx, double dy) {
		// TODO Auto-generated method stub
		
	}

	

}
