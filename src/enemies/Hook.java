package enemies;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import characters.Fish;
import misc.SpriteSheet;
import misc.Util;

/**
 * the Hook class is used to model hooks
 * @author abraham
 *
 */
public class Hook extends Enemy {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4415134457991027093L;
	public static final int SINGLE=0;
	public static final int DOUBLE_1=1;
	public static final int DOUBLE_2=2;
	
	private static SpriteSheet hooks=null;
	
	private boolean up,down;
	
	private int type;
	
	/**
	 * Creates a hook with initial x,y,and size
	 * @param xPos the initial x position
	 * @param yPos the initial y position
	 * @param size the size of this hook
	 */
	public Hook(double xPos,double yPos,int type){
		super (xPos,yPos);
		this.type = type;
		up=false;
		down=true;
		loadRes();
	}

	private void loadRes(){
		if(hooks==null){
			BufferedImage hooks_tmp=null;
			try {
				hooks_tmp = Util.loadImage("/hooks-sprite(3)(250x700).png",this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hooks = new SpriteSheet(hooks_tmp, 1, 3, 750, 250);
		}
	}
	
	
	/**
	 * implements the act() method from Enemy
	 */
	@Override
	public void act() {
		moveUpAndDown();
		xPos-=6;
		
	}
	
	@Override
	public void render(Graphics2D g){
		if(type==SINGLE){
			g.drawImage(hooks.getSprite(1, 1),(int)xPos,(int)yPos,800,1500,null);
		}
		else if (type==DOUBLE_1){
			g.drawImage(hooks.getSprite(1, 2),(int)xPos,(int)yPos,800,1500,null);
		}else if (type==DOUBLE_2){
			g.drawImage(hooks.getSprite(1, 3),(int)xPos,(int)yPos,800,1500,null);
		}
	}
	
	/**
	 * cause the hook to move randomly up and down on the screen
	 */
	private void moveUpAndDown(){
		if(yPos<-2000){
			up = false;
			down = true;
		}
		else if(yPos>-1000){
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
	
	public boolean isIn(Fish fish){
		
		return false;
	}
	

	/**
	 * 
	 * @return the type of the hook
	 */
	public int getType(){
		return type;
	}
	
	
}
