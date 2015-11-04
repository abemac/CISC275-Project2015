package games;

import misc.Tickable;
import view.View;

public class EstuaryAdventureMain implements Runnable,Tickable {

	
	
	private boolean running= false;
	private Thread thread;
	private View view;
	
	//Variables used to control updating frequency in run()
	
	private long lastTime,now;
	private final double ticksPerSecond = 60.0;
	private double nanosPerTick = 1000000000.0 / ticksPerSecond;
	private double deltaNs = 0;
	
	/**
	 * starts the main game loop on its own thread
	 */
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	};

	/**
	 * stops the main game loop
	 */
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);

	};

	/**
	 * implements run() from Runnable. gets called in start
	 */

	public void run() {
		view.requestFocus();
		lastTime = System.nanoTime();

		while (running) {
			now = System.nanoTime();
			deltaNs += (now - lastTime);
			lastTime = now;
			if (deltaNs > nanosPerTick) {
				onTick();
				deltaNs -= nanosPerTick; // possible set it to 0 alternatively,
											// depending on certain factors
			}

			view.render();

		}

		stop();

	}
	
	
	@Override
	public void onTick(){
		
	}

	/**
	 * 
	 * @return whether or not the game is currently running
	 */
	public boolean isRunning() {
		return running;
	}

}
