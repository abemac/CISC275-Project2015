package characters;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.ArbitraryLine;
import misc.SpriteSheet;
import misc.Util;

public class Game3Fish extends Character {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7090938780360351384L;

	private static SpriteSheet fish;
	private int spriteCol=1;
	private int spriteRow=1;
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
					tmp = Util.loadImage("/Goldfish(game3).png", this);
					fish=new SpriteSheet(tmp,2,3,150,150);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private double slope;
	
	public void onTick(){
		xPos+=( (crab.getX()+50)-xPos)/30.0;
		yPos+=((crab.getY()-200)-yPos)/30.0;
		

		
		if(crab.getX()+50<xPos){
			swimLeft=true;
			swimRight=false;
		}else if (crab.getX()+50>xPos){
			swimRight=true;
			swimLeft=false;
			
		}
		else{
			swimRight=false;
			swimLeft=false;
		}
		
		swimSpeed=8-(int)(Math.abs( (crab.getX()+50)-xPos)/7.0);
		
		
		slope=(8-swimSpeed)*(crab.getSeaFloor().getSlopeAt(xPos+1)/(1.5*15));
		slope=slope>.2?.2:slope;
		swimSpeed=swimSpeed<2?2:swimSpeed;
		if(swimRight){
			angle+=(slope-angle)/15f;
			swimRight();
		}
		else if(swimLeft){
			angle+=(slope-angle)/15f;
			swimLeft();
		}
		
		
		
		
	}
	
	private boolean forward;
	private boolean swimRight,swimLeft;
	private long limitSwim=0;
	private int swimSpeed=8;
	private void swimRight(){
		spriteRow=1;
		if(limitSwim%swimSpeed==0 && swimSpeed<=7){
			if(spriteCol==1){
				if(forward){
					spriteCol=3;
					forward=false;
				}else{
					spriteCol=2;
					forward=true;
				}
			}
			else{
				spriteCol=1;
			}
		}
		limitSwim++;
		
	}
	private void swimLeft(){
		spriteRow=2;
		if(limitSwim%swimSpeed==0 && swimSpeed<=7){
			if(spriteCol==1){
				if(forward){
					spriteCol=3;
					forward=false;
				}else{
					spriteCol=2;
					forward=true;
				}
			}
			else{
				spriteCol=1;
			}
		}
		limitSwim++;
		
	}
	@Override
	public void render(Graphics2D g) {
		g.translate(xPos+100, yPos+100);
		g.rotate(angle);
		g.drawImage(fish.getSprite(spriteRow, spriteCol),-100,-100,200,200,null);
		g.rotate(-angle);
		g.translate(-xPos-100, -yPos-100);
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
