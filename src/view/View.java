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
	
	
	
	private GameState state = GameState.MENU_SCREEN; //first state is the menu screen
	
	
	private BufferStrategy bs;
	/**
	 * implements a triple buffer strategry for rendering the view
	 */
	public void render(){
		bs = this.getBufferStrategy(); //creates triple buffer
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		////// DO RENDERING HERE///////
		
		
		
		
		
		///////////////////////////////
		
		
		g.dispose();//releases resources
		bs.show(); //shows next available buffer
		
		
		
	
	}
	
	public void setState(GameState state){
		this.state = state;
	}
}
