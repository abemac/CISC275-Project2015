package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.Util;

/**
 * The Net class is used to model nets
 * @author abraham
 *
 */
public class Net extends Enemy {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4749836762438935190L;
	/**
	 * BIGNET is a big, commercial fisherman type of net
	 */
	public static int BIGNET = 0;
	/**
	 * LILNET is a small, single person sized net
	 */
	public static int LILNET = 1;
	
	/**
	 * stores which type the Net is, either BIGNET or LILNET
	 */
	private int type; 
	
	private boolean up,down;
	
	private static BufferedImage lilNet;
	/**
	 * The constructor for net must accept and initial x,y and type
	 * If the type is not Net.BIGNET or Net.LILNET, it will default to Net.LILNET
	 * @param xPos the initial x position of the Net
	 * @param yPos the initial y position of the Net
	 * @param type the type of the Net
	 */
	public Net(double xPos, double yPos,int type){
		super(xPos,yPos);
		this.type = type;
		loadRes();
		up=false;
		down=true;
	}
	
	
	public void loadRes(){
		try {
			lilNet = Util.loadImage("/net.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * implements act() from enemy
	 */
	@Override
	public void act() {
		moveUpAndDown();
		
	}
	
	public void render(Graphics2D g){
		g.drawImage(lilNet, (int)xPos,(int) yPos,600,1300, null);
	}
	
	public void render2(Graphics2D g) {
		g.drawImage(lilNet, (int)xPos,(int) yPos,600,1300, null);
	}
	
	/**
	 * causes the net to move randomly in the y direction on the screen
	 */
	public void moveUpAndDown(){
		if(yPos<-2000){
			up = false;
			down = true;
		}
		else if(yPos>-300){
			up=true;
			down=false;
		}
		
		if(up){
			yPos-=8;
		}
		else if(down){
			yPos+=8;
		}
	}
	
	/**
	 * 
	 * @return the type of the net.  Either Net.BIGNET or Net.LILNET
	 */
	public int getType(){
		return type;
	}

	
	
	
	
}
