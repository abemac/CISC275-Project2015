package characters;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import enemies.TheHuman;
import enemies.Trash;
import games.CrabSaveGame;
import misc.ArbitraryLine;
import misc.Point;
import misc.SpriteSheet;
import misc.Util;

/**
 * Crab is a model class for the crab character that the player controls
 * and extends the abstract Character class.
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
	
	private Trash attachedTrash;
	private boolean isHoldingTrash;
	private boolean drawPowerBar=false;
	private boolean leftPressed,rightPressed,upPressed,downPressed=false;
	
	private Color barColor=Color.GREEN;
	private Point trashPoint= new Point(575,-320);
	private double lowestYThrowingTrash=0.0;
	
	private ArbitraryLine throwLine;
	private CrabSaveGame csg;
	private int barLength;
	
	private Stroke optimalStroke= new BasicStroke(10f);
	
	
	/**
	 * makes a Character Crab which has xPos, yPos, health
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param angriness the initial angriness
	 */
	public Crab(double xPos, double yPos, int health,CrabSaveGame csg) {
		super(xPos, yPos, health);
		loadRes();
		this.csg=csg;
		throwLine=new ArbitraryLine(new Point(-1000,1000), new Point(1000,1000));
		
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
		
		sprites = new SpriteSheet(crabs, 1, 3, 150, 150);
		
	}
	

	/**
	 * onTick is called 60 times per second and controls the movement of the Crab
	 */
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
		
		holdTrash();
		if(isThrowingTrash){
			throwAttachedTrash();
		}
		if(spacePressed && isHoldingTrash){
			accumulateTime();
		}
		if(drawPowerBar){
			calculateBarLength();
		}
		
		
		
		for(Trash t : previouslyThrownTrash){
			if(t.getY()<-600){
				t.setY(t.getY()+40);
				t.setX(t.getX()+(565-t.getX()-t.getWidth()/2.0)/10.0 );
			}
		}
		
		
	}
	
	
	private void accumulateTime(){
		
			if(timeSpacePressed==-1){
				timeSpacePressed=System.nanoTime();
				lastTime=timeSpacePressed;
				spaceReleased=false;
				drawPowerBar=true;
				timeHeld=0;
			}else{
				if(up && timeHeld>NANOS_MAX){
					up=false;
				}else if (!up && timeHeld<=200000000){//5th of a second
					up=true;
				}
				if(up)
					timeHeld+=(System.nanoTime()-lastTime);
				else
					timeHeld-=(System.nanoTime()-lastTime);
				lastTime=System.nanoTime();
				
			}
			if(spaceReleased){
				spacePressed=false;
				if(isHoldingTrash){
					setPowerByTimePressed();
					isThrowingTrash=true;
					spacePressed=false;
					spaceReleased=false;
					drawPowerBar=false;
					timeSpacePressed=-1;
					timeHeld=0;
					up=true;
					
				}
			}
		
	}
	
	private void holdTrash(){
		if(isHoldingTrash && attachedTrash!=null){
			if(attachedTrash.getType()==Trash.SODA_CAN ){
				attachedTrash.setX(xPos+110+yPos/12.0);
				attachedTrash.setY(yPos-100-yPos/12.0);
			}
			if(attachedTrash.getType()==Trash.BANANA ){
				attachedTrash.setX(xPos+50+yPos/12.0);
				attachedTrash.setY(yPos-50-yPos/12.0);
			}
			if(attachedTrash.getType()==Trash.ROPE ){
				attachedTrash.setX(xPos+30+yPos/9.0);
				attachedTrash.setY(yPos-240-yPos/4.0);
			}
			if(attachedTrash.getType()==Trash.MILK_JUG ){
				attachedTrash.setX(xPos+yPos/25.0);
				attachedTrash.setY(yPos-230-yPos/4.0);
			}
			if(attachedTrash.getType()==Trash.BOTTLE ){
				attachedTrash.setX(xPos+110+yPos/10.0);
				attachedTrash.setY(yPos-180-yPos/6.0);
			}
			if(attachedTrash.getType()==Trash.SHOPPING_BAG ){
				attachedTrash.setX(xPos+50+yPos/20.0);
				attachedTrash.setY(yPos-240-yPos/4.5);
			}
			attachedTrash.act();
		}
	}
	
	
	private void calculateBarLength(){
		barLength=(int)((400+yPos/2.5)*
				(timeHeld/NANOS_MAX));
	}
	
	/**
	 * @param g renders the graphics
	 */
	@Override
	public void render(Graphics2D g){
		g.drawImage(sprites.getSprite(1, spriteNum), (int)xPos, (int)yPos, (int)(400+yPos/2.5),(int)( 400+yPos/2.5),null);
		for(Trash t: previouslyThrownTrash){
			t.render(g);
		}
		
		if(drawPowerBar){
			g.setColor(barColor);
			g.fillRoundRect((int)xPos,(int)( yPos+400+yPos/2.5+50),barLength, 10, 5, 5);
			g.setColor(Color.BLACK);
			g.setStroke(optimalStroke);
			g.drawRect((int)(xPos+(400+yPos/2.5)*.6), (int)( yPos+400+yPos/2.5+45), (int)((400+yPos/2.5)*0.2),20);
		}
		
		//throwLine.testRender(g);
	}
	
	public void renderThrownTrash(Graphics2D g){
		if(( isThrowingTrash|| isHoldingTrash) && attachedTrash!=null){
			attachedTrash.render(g);
		}
		
		//g.drawLine(-1000, (int)lowestYThrowingTrash, 1000,(int)lowestYThrowingTrash);
		
		
		
	}
	
	
	private boolean isThrowingTrash=false;
	private boolean calculatedTrajecory=false;
	private boolean reachedVertex=false;
	private boolean aboveCan=false;
	private ArrayList<Trash> previouslyThrownTrash = new ArrayList<Trash>();
	/**
	 * implements Crab throwing object trash
	 */
	public void throwAttachedTrash(){
		
		if(!calculatedTrajecory)
			calculateTrajectory();
		
		attachedTrash.setX(attachedTrash.getX()+Vx);
		attachedTrash.setY(attachedTrash.getY()-Vy);
		Vy-=gravity;
		attachedTrash.act();
		if(attachedTrash.getY()<-900){
			aboveCan=true;
		}
		if(reachedVertex==false && Math.abs(Math.abs(Vy)-gravity)<=gravity){
			reachedVertex=true;
		}
		
		
		if(reachedVertex && (attachedTrash.getY()>lowestYThrowingTrash||
				throwLine.isBelowLine(attachedTrash.getX()+attachedTrash.getWidth()/2f,
						attachedTrash.getY()+attachedTrash.getHeight()/2f))){
			
			isThrowingTrash=false;
			calculatedTrajecory=false;
			attachedTrash.setBeingThrown(false);
			csg.addBackTrash(attachedTrash);
			isHoldingTrash=false;
			attachedTrash=null;
			reachedVertex=false;
			aboveCan=false;
		}
		
		else if(aboveCan && attachedTrash.getX()>trashX-200 && attachedTrash.getX()+attachedTrash.getWidth()<trashX+250 &&
				attachedTrash.getY()+attachedTrash.getHeight()>trashY && reachedVertex){
			isThrowingTrash=false;
			isHoldingTrash=false;
			calculatedTrajecory=false;
			attachedTrash.setBeingThrown(false);
			previouslyThrownTrash.add(attachedTrash);
			attachedTrash=null;
			reachedVertex=false;
			aboveCan=false;
		}
		
	}
	
	
	private int gravity=3;
	private double trashX=575;
	private double trashY=-800;
	private double Vy;
	private double Vx;
	private double power=0.5;//1.0 is optimal
	private void calculateTrajectory(){
		double Xinit=attachedTrash.getX();
		double Yinit=attachedTrash.getY();
		Vy=power*Math.sqrt(2*gravity*(Yinit+1100));
		double Tt = ((Vy/gravity)+(Math.sqrt((2200+2*trashY)/gravity)));
		Vx = power*(trashX-Xinit)/Tt;
		if(power<=1.0)
			lowestYThrowingTrash=-power*300;
		else
			lowestYThrowingTrash=-300;
		throwLine.setPoints(new Point(xPos+(400+yPos/2.5)/2f,yPos+(400+yPos/2.5)), trashPoint);
		calculatedTrajecory=true;
		isHoldingTrash=false;
		attachedTrash.setBeingThrown(true);
		
		
		
	}
	
	private boolean up=true;
	private long timeHeld=0;
	private boolean spacePressed,spaceReleased=false;
	private long lastTime;
	private long timeSpacePressed=-1;
	private static final double NANOS_MAX=1000000000;
	private static final double POWER_MAX=1.2;
	
	/**
	 * sets the power of the throw according to time space bar is pressed
	 */
	private void setPowerByTimePressed(){
		
		double percetange = timeHeld/NANOS_MAX;
		if(percetange>.8){
			power=POWER_MAX;
		}else if (percetange>.6){
			power=1.0;//Optimal
		}else if (percetange > .4){
			power=0.8;
		}
		else if (percetange > .2){
			power=0.6;
		}
		else if (percetange > 0){
			power=0.4;
		}
			
		
	}
	
	
	private double buffer=150;
	public boolean isTouchingTrash(Trash t){
		if(isHoldingTrash || isThrowingTrash){
			return false;
		}
		switch(t.getType()){
			case Trash.BANANA: buffer=150*t.getScale();break;
			case Trash.SODA_CAN: buffer=200*t.getScale();break;
			case Trash.BOTTLE:buffer=180*t.getScale();break;
			case Trash.MILK_JUG: buffer=300*t.getScale();break;
			case Trash.SHOPPING_BAG:buffer=250*t.getScale();break;
			case Trash.ROPE: buffer=300*t.getScale();break;
			default: buffer=150;
		}
		return(xPos+400+yPos/2.5-buffer>t.getX() && yPos+400+yPos/2-buffer>t.getY()
				&& xPos+buffer<t.getX()+t.getWidth() && yPos+buffer<t.getY()+t.getHeight());

		
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
	
	
	
	
	public boolean isHoldingTrash(){
		return isHoldingTrash;
	}
	public void setIsHoldingTrash(boolean b){
		this.isHoldingTrash=b;
		if(b==false){
			attachedTrash=null;
		}
	}
	public void holdTrash(Trash t){
		attachedTrash=t;
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
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			if(isHoldingTrash){
				spacePressed=true;
			}
			
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
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			spaceReleased=true;
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
