package view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import misc.GameState;
/**
 * Handles rendering the View for all games
 * @author abraham
 *
 */
public class View extends Canvas{
	
	
	private static BufferStrategy bs;
	/**
	 * implements a triple buffer strategry for rendering the view
	 */
	public void render(GameState state){
		bs = this.getBufferStrategy(); //creates triple buffer
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		////// DO RENDERING HERE///////
		
		
		g.fillRect(0, 0, getWidth(), getHeight());
		
		
		///////////////////////////////
		
		
		g.dispose();//releases resources
		bs.show(); //shows next available buffer
		
		
		
	
	}
	
	
}
