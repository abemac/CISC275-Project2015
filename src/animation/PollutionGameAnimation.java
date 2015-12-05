package animation;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class PollutionGameAnimation extends Animation{

	/**
	 * 
	 */
	private ArrayList<Slide> slides;
	private static final long serialVersionUID = -4268209084988036700L;
	private int currentSlide=0;
	
	public PollutionGameAnimation(){
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void init() throws IOException{
		slides=new ArrayList<Slide>();
		slides.add(new Slide("/Game3Animation1.png", 4));
		slides.add(new Slide("/Game3Animation2.png", 6));
		slides.add(new Slide("/Game3Animation3.png", 4));
		
		slides.get(0).load();
		
		
	}
	
	
	
	@Override
	public void onTick() {
		if(isOnFinalSlide()){
			//throwAnimation.onTick();
			//pickUpAnimation.onTick();
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
			//throwAnimation.render(g);
			//pickUpAnimation.render(g);
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
