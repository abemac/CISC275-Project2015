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
	
	private boolean smooth=false;
	
	private Point centerPoint = new Point(168,147);
	private boolean countUp=false;
	private int xPos,yPos;
	public ClockTimer(int xPos,int yPos){
		this.xPos=xPos;
		this.yPos=yPos;
		loadRes();
		initialAngle=-Math.PI/18f;
	}
	
	
	private void loadRes(){
		try {
			image = Util.loadImage("/Clock.png",300,300, this);
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
		g.fillRoundRect(-5, -70, 10, 70, 10, 10);
		
		g.rotate(-handAngle);
		
		g.rotate(-initialAngle);
		g.translate(-xPos-centerPoint.x, -yPos-centerPoint.y);
		
	}
	
	private boolean going=true;
	
	public void pause(){
		going=false;
	}
	public void run(){
		going=true;
	}

	@Override
	public void onTick() {
		if(going){
			if(!countUp)
				timer-=1/60.0;
			else{
				timer+=1/60.0;
			}
		}
		if(smooth)
			handAngle+=2*Math.PI/(60*60);
		else{
			if(!countUp)
				handAngle=(1-((int)(timer))/60.0)*(2*Math.PI);
			else{
				handAngle=-(1-((int)(timer))/60.0)*(2*Math.PI);
			}
		}
	}
	
	public void setTimer(double d){
		this.timer=d;
	}
	public double getTimer(){
		return timer;
	}
	
	public void setCountUp(boolean countUp) {
		this.countUp = countUp;
		timer=0;
	}
	
	public void setInitialAngle(double initialAngle) {
		this.initialAngle = initialAngle;
	}

}
