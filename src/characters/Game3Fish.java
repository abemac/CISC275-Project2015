package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.SpriteSheet;
import misc.Util;

public class Game3Fish extends Character {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7090938780360351384L;

	private static SpriteSheet fish;
	private int spriteNum=1;
	private double angle=0;
	private Game3Crab crab;
	
	public Game3Fish(Game3Crab crab) {
		super(crab.getX(), crab.getY()-100, 100);
		this.crab=crab;
		loadRes();
	}

	/**
	 * loads image of fish
	 */
	private void loadRes(){
		if(fish==null){
			BufferedImage tmp=null;
			try {
					tmp = Util.loadImage("/Goldfish5x(150x150).png", this);
					fish=new SpriteSheet(tmp,1,5,150,150);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void onTick(){
		xPos+=( (crab.getX()+50)-xPos)/40.0;
		yPos+=((crab.getY()-200)-yPos)/40.0;
		swim();
		
	}
	
	private boolean forward;
	private long limitSwim=0;
	private int swimSpeed=7;
	private void swim(){
		if(limitSwim%swimSpeed==0 && swimSpeed<=7){
			if(spriteNum==1){
				if(forward){
					spriteNum=3;
					forward=false;
				}else{
					spriteNum=2;
					forward=true;
				}
			}
			else{
				spriteNum=1;
			}
		}
		limitSwim++;
		if(limitSwim%7==0 && swimSpeed!=6){
			if(swimSpeed>6){
				swimSpeed-=1;
			}if(swimSpeed<6){
				swimSpeed+=1;
			}
		}
		
	}
	@Override
	public void render(Graphics2D g) {
		g.drawImage(fish.getSprite(1, spriteNum),(int)xPos,(int)yPos,200,200,null);
	}
	
	
	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
