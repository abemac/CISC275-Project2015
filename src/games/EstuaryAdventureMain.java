package games;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import misc.GameState;
import misc.MenuScreen;
import misc.Tickable;
import view.EstuaryView;

/**
 * This main control structure of this game is very similar to an online 
 * tutorial series entitled "Java Game Development"  
 * This is because Abraham made a game a couple of years ago using these
 * tutorials for fun, and so our implementation ended up being very similar.
 * However, we made slight optimizations so that the rendering is more efficiant.
 * @author Abraham McIlvaine
 *
 */
public class EstuaryAdventureMain implements Runnable,Tickable,KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4347325551128251031L;

	private boolean running= false;
	private Thread thread;
	private EstuaryView view;
	private GameState state;
		
	//Variables used to control updating frequency in run()
	private long lastTime,now;
	private final double ticksPerSecond = 60.0;
	private double nanosPerTick = 1000000000.0 / ticksPerSecond;
	private double deltaNs = 0;
	
	
	///////
	private MenuScreen menu;
	private OverfishingGame overfishingGame;
	
	////////
	
	public EstuaryAdventureMain(){
		init();
	}
	
	
	private void init(){
		view = new EstuaryView();
		state = GameState.MENU_SCREEN;
		DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		view.setPreferredSize(new Dimension(dm.getWidth(), dm.getHeight()));
		state = GameState.MENU_SCREEN;
		view.addKeyListener(this);
		
		
		
	}
	
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
			if (deltaNs >= nanosPerTick) {
				onTick();
				deltaNs -= nanosPerTick; // possible set it to 0 alternatively,
				updateView();			// depending on certain factors
			}
			
			

		}

		stop();

	}
	
	
	@Override
	public void onTick(){
		if(state == GameState.MENU_SCREEN){
			if(menu == null){
				menu = new MenuScreen();
				view.addMouseListener(menu);
				view.addKeyListener(menu);
			}
			menu.onTick();
			if(menu.isDone()){
				state = GameState.OVERFISHING_GAME;
				view.removeKeyListener(menu);
				view.removeMouseListener(menu);
				menu = null;
			}
			
		}
		else if (state == GameState.OVERFISHING_GAME){
			if(overfishingGame==null){
				overfishingGame = new OverfishingGame();
				view.addMouseListener(overfishingGame);
				view.addKeyListener(overfishingGame);
			}
			overfishingGame.onTick();
			if(overfishingGame.isDone()){
				state = GameState.CRAB_SAVE_GAME;
				view.removeKeyListener(overfishingGame);
				view.removeMouseListener(overfishingGame);
				overfishingGame=null;
			}
			
			
		}
	}
	
	private void updateView(){
		if(state==GameState.MENU_SCREEN && menu!=null){
			view.render(menu);	
			
		}
		else if (state == GameState.OVERFISHING_GAME && overfishingGame!=null){
			view.render(overfishingGame);
			
		}
		
	}

	
	/**
	 * 
	 * @return whether or not the game is currently running
	 */
	public boolean isRunning() {
		return running;
	}
	
	
	/////MAIN FUNCTION//////
	
	private static JFrame frame;
	
	public static void main (String[]args){
		frame = new JFrame("Estuary Adventure!");
		EstuaryAdventureMain game = new EstuaryAdventureMain();
		frame.getContentPane().add(game.view);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		game.start();
		
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()== KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
		
		if(e.getKeyCode()==KeyEvent.VK_2){
			state=GameState.CRAB_SAVE_GAME;
		}
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
