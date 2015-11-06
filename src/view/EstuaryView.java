package view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import misc.Renderable;
/**
 * Handles rendering the View for all games
 * @author abraham
 *
 */
public class EstuaryView extends Canvas{
	
	
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
		////// DO RENDERING HERE///////
		
		
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.translate(100, 100);
		g.rotate(45);
		g.fillRect(0, 0, 100, 100);
		r.render(g);
		
		///////////////////////////////
		
		
		g.dispose();//releases resources
		bs.show(); //shows next available buffer
		
		

	
	}
	
	
}
