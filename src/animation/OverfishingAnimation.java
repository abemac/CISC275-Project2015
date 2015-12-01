package animation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import misc.Renderable;
import misc.SoundDoer;
import misc.Tickable;
import misc.Util;

public class OverfishingAnimation extends Animation{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6504012050432476847L;
	
	
	private ArrayList<Slide> slides;
	private int currentSlide=0;
	private SoundDoer soundDoer = new SoundDoer();
	
	public OverfishingAnimation(){
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void init() throws IOException{
		slides=new ArrayList<Slide>();
		slides.add(new Slide("/menuScreen.png",2){{
			setFadeIn(false);
			setFadeOutTime(1.0);
		}});
		slides.add(new Slide("/Black.png", 2));
		slides.add(new Slide("/Game1AnimationSlide3.png", 9));
		slides.add(new Slide("/Game1AnimationSlide4.png", 9){{
			//setFadeOut(false);
		}});
		slides.add(new Slide("/Game1AnimationSlide5.png", 6){{
			//setFadeIn(false);
		}});
		
	}
	
	
	

	@Override
	public void render(Graphics2D g) {
		if(slides.get(currentSlide).display(g)){
			currentSlide++;
		}
		if(currentSlide>=slides.size()){
			setIsDone(true);
		}
		
	}


	@Override
	public void onTick() {
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	
	
}
