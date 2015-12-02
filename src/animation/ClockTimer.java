package animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.Point;
import misc.Renderable;
import misc.Tickable;
import misc.Util;

public class ClockTimer implements Tickable,Renderable{

	private double timer = 61.0;
	private BufferedImage image;
	private double initialAngle;
	private double handAngle;
	
	private Point centerPoint = new Point(100,100);
	
	private int xPos,yPos;
	public ClockTimer(int xPos,int yPos){
		this.xPos=xPos;
		this.yPos=yPos;
		loadRes();
	}
	
	
	private void loadRes(){
		try {
			image = Util.loadImage("/Clock.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(Graphics2D g) {
		g.translate(xPos+centerPoint.x, yPos+centerPoint.y);
		g.rotate(initialAngle);
		
		g.drawImage(image, (int)-centerPoint.x, (int)-centerPoint.y,null);
		
		g.rotate(handAngle);
		g.setColor(Color.BLACK);
		g.fillRoundRect(0, 0, 10, 50, 10, 10);
		
		g.rotate(-handAngle);
		
		g.rotate(-initialAngle);
		g.translate(-xPos-centerPoint.x, -yPos-centerPoint.y);
		
	}

	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		
	}

}
