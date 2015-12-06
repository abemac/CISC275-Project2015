package animation;

import java.awt.Graphics2D;

import misc.Renderable;
import misc.Tickable;

public class AnimationBlowBubble implements Tickable,Renderable {

	private AnimationGame3Crab crab;
	private AnimationGame3Fish fish;
	
	
	public AnimationBlowBubble() {
		
		crab=new AnimationGame3Crab(0, 100, 0);
		fish = new AnimationGame3Fish(crab);
	}
	@Override
	public void render(Graphics2D g) {
		crab.render(g);
		fish.render(g);
		
	}

	@Override
	public void onTick() {
		crab.onTick();
		fish.onTick();
		
	}

}
