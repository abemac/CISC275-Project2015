package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;

import misc.Renderable;
import misc.Util;
/**
 * Handles rendering the View for all games
 * @author abraham
 *
 */
public class EstuaryView extends Canvas{
	
	private static int distanceToEdge=-1;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4412289037175187075L;
	
	
	
	private static BufferStrategy bs;
	/**
	 * implements a triple buffer strategry for rendering the view
	 */
	public void render(Renderable r){
		bs = this.getBufferStrategy(); //creates triple buffer
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.fillRect(0, 0, getWidth(), getHeight());
		if(distanceToEdge==-1)
			distanceToEdge= (int) (( (double)(getWidth()) / (double)(getHeight()) )*1000.0);
		
		Util.setCanvasHeight(getHeight());
		Util.setCanvasWidth(getWidth());
		Util.setCurrentScaleFactor(getHeight()/2000.0);
		
		g.translate(getWidth()/2.0,getHeight()/2.0);
		g.scale(getHeight()/(2000.0), getHeight()/2000.0);
		
		
		////// DO RENDERING HERE///////
		//g.rotate(45);
		
		r.render(g);
		
		///////////////////////////////
		
		
		g.dispose();//releases resources
		bs.show(); //shows next available buffer
		
		

	
	}
	
	
	/**
	 * 
	 * @return the distance from the center (0,0) to a horizontal edge.  
	 */
	public static int getDistanceToEdge(){
		return distanceToEdge;
	}
	
	/**
	 * 
	 * @return the extra Distance to add to 1000 to get to the edge of the horizontal screen
	 */
	public static int getExtraDistance(){
		return distanceToEdge -1000;
	}
	
	
	
}
