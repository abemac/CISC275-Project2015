package animation;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import misc.SoundDoer;
import misc.Util;

public class OverfishingAnimation extends Animation{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6504012050432476847L;
	
	
	private ArrayList<Slide> slides;
	private int currentSlide=0;
	private SoundDoer soundDoer = new SoundDoer();
	private BufferedImage crabFish;
	
	private AnimationFishAvoidNet fishAvoidNet;
	
	public OverfishingAnimation(){
		fishAvoidNet = new AnimationFishAvoidNet();
		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private void init() throws IOException{
		slides=new ArrayList<Slide>();
		slides.add(new Slide("/menuScreen.png",1){{
			setFadeIn(false);
			setFadeOutTime(1.0);
		}});
		//slides.add(new Slide("/Black.png", 1));
		slides.add(new Slide("/Game1AnimationText1.png", 4));
		slides.add(new Slide("/Game1AnimationText2.png", 4));
		slides.add(new Slide("/Game1AnimationText3.png", 4){{
			setFadeEveryThingOut(true);
		}});
		slides.add(new Slide("/Black.png", 1){{
			
		}});
		slides.add(new Slide("/Game1AnimationSlide1.png", 4));
		slides.add(new Slide("/Game1AnimationSlide2.png", 4));
		slides.add(new Slide("/Game1AnimationSlide3.png", 4));
		slides.add(new Slide("/Game1AnimationSlide4.png", 4){{
			
		}});
		//slides.add(new Slide("/Game1AnimationSlide5.png", 6){{
		//}});
		slides.add(new Slide("/Black.png", 1){{
			
		}});
		slides.add(new Slide("/Game1AnimationInstructionSlide.png",4){{
			setFinalSlide(true);
			setFadeEverything(true);
		}});
		
		crabFish=Util.loadImage("/menuCrabFish.png",Util.getCANVAS_WIDTH_SCALED(),2000, this);
		
		slides.get(0).load();
		
		
	}
	private boolean finalSlide=false;
	@Override
	public void render(Graphics2D g) {
		if(isOnFinalSlide()){
			finalSlide=true;
		}
		if(slides.get(currentSlide).display(g)){
			
			currentSlide++;
			if(currentSlide<slides.size())
				slides.get(currentSlide).load();
			
		}
		if(finalSlide){
			fishAvoidNet.render(g);
		}
		if(currentSlide>=slides.size()){
			setIsDone(true);
		}
		if(currentSlide<=3)
			g.drawImage(crabFish, -Util.getDISTANCE_TO_EDGE(), -1000, null);
		
		
		
	}


	@Override
	public void onTick() {
		if(isOnFinalSlide()){
			fishAvoidNet.onTick();
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(currentSlide==slides.size()-1){
			slides.get(slides.size()-1).mouseClicked(e);
		}
		
	}


	private boolean isOnFinalSlide(){
		return currentSlide==slides.size()-1;
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
		if(currentSlide==slides.size()-1){
			slides.get(slides.size()-1).mouseMoved(e);
		}
		
	}
	
	
	
	
	
	
	
	
}
