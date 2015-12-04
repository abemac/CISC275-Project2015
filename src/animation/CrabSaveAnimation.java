package animation;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import misc.SoundDoer;

public class CrabSaveAnimation extends Animation{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7197410829940008609L;
	private ArrayList<Slide> slides;
	private int currentSlide=0;
	private SoundDoer soundDoer = new SoundDoer();
	
	private AnimationCrabThrowTrash throwAnimation = new AnimationCrabThrowTrash(0, 0);
	
	public CrabSaveAnimation() {
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void init() throws IOException{
		slides=new ArrayList<Slide>();
		slides.add(new Slide("/Black.png", 1));
		slides.add(new Slide("/Game2AnimationInstructionSlide1.png", 8));
		slides.add(new Slide("/Game2AnimationInstructionSlide2.png", 4){{
			setFinalSlide(true);
		}});
		
		slides.get(0).load();
		
		
	}
	@Override
	public void onTick() {
		if(isOnFinalSlide()){
			throwAnimation.onTick();
		}
		
	}
	
	private boolean isOnFinalSlide(){
		return currentSlide==slides.size()-1;
	}
	
	@Override
	public void render(Graphics2D g) {
		if(slides.get(currentSlide).display(g)){
			currentSlide++;
			if(currentSlide<slides.size())
				slides.get(currentSlide).load();
			
		}
		if(currentSlide>=slides.size()){
			setIsDone(true);
		}
		
		if(isOnFinalSlide()){
			throwAnimation.render(g);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(currentSlide==slides.size()-1){
			slides.get(slides.size()-1).mouseClicked(arg0);
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		if(currentSlide==slides.size()-1){
			slides.get(slides.size()-1).mouseMoved(arg0);
		}
		
		
	}

}
