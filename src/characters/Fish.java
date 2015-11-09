package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.Util;

/**
 * Fish is a model class for the fish that the player controls
 * @author abraham
 *
 */
public class Fish extends Character {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1015644809982634515L;
	
	private static BufferedImage fish;
	
	private boolean hasCollided;
	
	
	private boolean leftPressed,rightPressed,upPressed,downPressed;
	
	/**
	 * Creates a fish with initial x,y, and health
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param health the initial health
	 */
	
	public Fish(double xPos, double yPos, int health) {
		super(xPos, yPos, health);
		loadRes();
	}
	
	/**
	 * Creates a fish with initial x,y and default health value
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 */
	public Fish(double xPos, double yPos) {
		super(xPos, yPos);
		loadRes();
	}
	
	
	public void loadRes(){
		try {
			fish = Util.loadImage("/goldfish.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTick(){
		if(leftPressed){
			move(-50,0);
		}
		if(rightPressed){
			move(50,0);
		}
	}
	
	@Override
	public void render(Graphics2D g){
		g.drawImage(fish,getXInt(),getYInt(),200,200,null);
	}
	
	/**
	 * implements move according to how a fish moves
	 * @param dx the change in x 
	 * @param dy the change in y
	 */
	@Override
	public void move(double dx, double dy) {
		xPos+=dx;
		yPos+=dy;
		
	}
	
	public boolean hasCollided(){
		return hasCollided;
	}
	
	

	/////*** listeners ***///////
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			leftPressed = true;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rightPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			leftPressed = false;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rightPressed = false;
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
