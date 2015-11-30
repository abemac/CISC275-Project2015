package animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Slide {

	
	private BufferedImage image;
	private int time;
	private int startTime=0;
	private java.awt.Color color;
	
	public Slide(BufferedImage image,int time){
		this.image=image;
		this.time=time;
	}
	
	public Slide(java.awt.Color color,int time){
		this.color = color;
		this.time = time;
	}
	
	
	public boolean display(Graphics2D g){
		
		
		return false;
	}
	
	
	
	
	
}
