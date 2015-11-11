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
	
	private double lag;
	
	private double lagC;
	
	private double xVel,yVel;
	
	private double lostGround;
	private boolean leftPressed,rightPressed,upPressed,downPressed;
	
	private double angle,angleVel;
	
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
	public Fish(double xPos, double yPos,int health,double lag) {
		super(xPos, yPos);
		loadRes();
		this.lag = lag;
		lagC=lag;
	}
	
	
	public void loadRes(){
		try {
			if(fish==null)
				fish = Util.loadImage("/goldfish.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTick(){
		if(leftPressed){
			xVel=-5+lagC;
			lostGround-=lagC;
		}
		else if(rightPressed){
			xVel=5-lagC;
			lostGround+=lagC;
		}else{
			if(lostGround>3){
				xVel=5;
				lostGround-=5;
			}
			else if(lostGround<-3){
				xVel=-5;
				lostGround+=5;
			}
				
		}
		if(upPressed){
			yVel=-5;
			if(angle>-Math.PI/10.0f)
				angleVel=-.01;
		}
		else if(downPressed){
			yVel=6;
			if(angle<Math.PI/10.0f)
				angleVel=.01;
		}
		
		xPos+=xVel;
		if(xVel>.15){
			xVel-=.15;
		}else if(xVel<-.15){
			xVel+=.15;
		}else
			xVel=0;
		lagC=lagC>0.05? lagC-0.05:0;
		
		
		yPos+=yVel;
		if(yVel>.15){
			yVel-=.15;
		}else if(yVel<-.15){
			yVel+=.15;
		}else
			yVel=0;
		
		angle+=angleVel;
		
		if(angle<-0.01){
			angleVel=.005;
		}
		else if(angle>0.01){
			angleVel=-.005;
		}else{
			angleVel=0;
			
		}
		
	}
	
	@Override
	public void render(Graphics2D g){
		g.translate(getX(), getY());
		g.rotate(angle);
		g.drawImage(fish,0,0,200,200,null);
		g.rotate(-angle);
		g.translate(-getX(), -getY());
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
		if(e.getKeyCode()==KeyEvent.VK_UP){
			upPressed = true;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			downPressed= true;
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			leftPressed = false;
			lagC=lag;
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			rightPressed = false;
			lagC=lag;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			upPressed = false;
			lagC=lag;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			downPressed= false;
			lagC=lag;
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
