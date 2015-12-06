package animation;

import java.awt.Graphics2D;

import misc.Renderable;
import misc.Tickable;

public class AnimationFishAvoidNet implements Tickable,Renderable {

	private AnimationFish animationFish;
	
	public AnimationFishAvoidNet() {
		animationFish = new AnimationFish(0, 0, 0, 0);
	}
	
	@Override
	public void render(Graphics2D g) {
		animationFish.render(g);
		
	}
	
	@Override
	public void onTick() {
		animationFish.onTick();
		
	}
	

}
