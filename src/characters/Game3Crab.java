package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.ArbitraryLine;
import misc.SpriteSheet;
import misc.Util;

public class Game3Crab extends Character{

	
	private SpriteSheet sprites;
	private boolean leftPressed,rightPressed,upPressed,downPressed=false;
	private int spriteNum=1;
	private int spriteTime=0;
	private ArbitraryLine seaFloor;
	private double angle=0;
	private double angleVel=.015;
	private double slope=0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -8431818079245300953L;

	public Game3Crab(double xPos, int health,ArbitraryLine seaFloor) {
		super(xPos, seaFloor.getYatXPos(xPos+150)-200, health);
		loadRes();
		this.seaFloor=seaFloor;
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
		slope=seaFloor.getSlopeAt(xPos+150)/1.5;
		//System.out.println(slope);
		if(leftPressed){
			if(spriteNum==1){
				spriteNum=3;
			}
			if(spriteTime>=6){
				spriteTime=0;
				if(spriteNum==2){spriteNum=3;}
				else if (spriteNum==3){spriteNum=2;}
			}
			if(slope>.5)
				xPos-=3;
			else
				xPos-=5;
			xPos=xPos<-Util.getDISTANCE_TO_EDGE()+5?-Util.getDISTANCE_TO_EDGE()+5:xPos;
			yPos=seaFloor.getYatXPos(xPos+150)-200;
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
			if(slope>.5)
				xPos+=3;
			else
				xPos+=5;
			xPos=xPos>Util.getDISTANCE_TO_EDGE()-400?Util.getDISTANCE_TO_EDGE()-400:xPos;
			yPos=seaFloor.getYatXPos(xPos+150)-200;
		}
		
		if(leftPressed||rightPressed)
			spriteTime++;
		else
			spriteTime=0;
		
		
		angle+=(slope-angle)/6f;
		
		
		
	}
	
	@Override
	public void render(Graphics2D g) {
		g.translate(xPos+150,yPos+150);
		g.rotate(angle);
		g.drawImage(sprites.getSprite(1, spriteNum),-150, -150,300,300,null);
		
		g.rotate(-angle);
		g.translate(-xPos-150, -yPos-150);
		
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
