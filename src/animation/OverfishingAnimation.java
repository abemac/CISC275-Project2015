package animation;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;

import misc.SoundDoer;
import misc.Util;

public class OverfishingAnimation {

	
	private ArrayList<Slide> slides;
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
		slides.add(new Slide(Color.BLACK, 4));
		slides.add(new Slide(Util.loadImage("/Game1AnimationSlide3.png",
				Util.getCANVAS_WIDTH_SCALED(),Util.getCANVAS_HEIGHT_SCALED(), this), 4));
		
		
	}
	
	
	
	
	
	
	
	
}
