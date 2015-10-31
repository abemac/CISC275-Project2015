package stubs;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class View extends Canvas{
	
	//state nums
	public static final int MENU_SCREEN = 0;
	public static final int OVERFISHING_GAME_ANIMATION = 1;
	public static final int OVERFISHING_GAME = 2;
	public static final int CRAB_SAVE_GAME_ANIMATION = 3;
	public static final int CRAB_SAVE_GAME = 4;
	public static final int POLLUTION_GAME_ANIMATION = 5;
	public static final int POLLUTION_GAME = 6;
	public static final int SHOW_STATS=7;
	
	
	private int state = MENU_SCREEN;
	
	
	private BufferStrategy bs;
	
	private void render(){
		bs = this.getBufferStrategy(); //creates triple buffer
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//////
		
		
		
		//////
		
		
		g.dispose();//releases resources
		bs.show(); //shows next available buffer
		
		
		
	
	}
}
