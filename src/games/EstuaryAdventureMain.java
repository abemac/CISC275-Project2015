package games;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JFrame;

import animation.CrabSaveAnimation;
import animation.OverfishingAnimation;
import misc.GameState;
import misc.MenuScreen;
import misc.Tickable;
import misc.Util;
import view.EstuaryView;

/**
 * This main control structure of this game is very similar to an online 
 * tutorial series entitled "Java Game Development"  
 * This is because Abraham made a game a couple of years ago using these
 * tutorials for fun, and so our implementation ended up being very similar.
 * However, we made slight optimizations so that the rendering is more efficient.
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
	private OverfishingAnimation overfishingAnimation;
	private OverfishingGame overfishingGame;
	private CrabSaveAnimation crabSaveAnimation;
	private CrabSaveGame crabSaveGame;
	private PollutionGame pollutionGame;
	
	private static final BufferedImage blankImage = new BufferedImage(16,16,BufferedImage.TYPE_INT_ARGB);
	private static final Cursor blankCursor=
			Toolkit.getDefaultToolkit().createCustomCursor(blankImage, new java.awt.Point(0, 0), "blank cursor");
	
	
	
	private static BufferedImage menuCursorImage;
	private static Cursor menuCursor;
	/**
	 * creates the Main Game by calling init()
	 */
	public EstuaryAdventureMain(){
		init();
	}
	
	/**
	 * gets called in the constructor to initilize components
	 */
	private void init(){
		view = new EstuaryView();
		DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		view.setPreferredSize(new Dimension(dm.getWidth(), dm.getHeight()));
		state = GameState.MENU_SCREEN;
		view.addKeyListener(this);
		
		try {
			menuCursorImage=Util.loadImage("/menu-cursor3.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		menuCursor=Toolkit.getDefaultToolkit().createCustomCursor(menuCursorImage, new java.awt.Point(0,0), "menu cursor");
		
		
		
	}
	
	/**
	 * starts the main game loop on its own thread
	 */
	public synchronized void start() {
		if (!running) {
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}

	/**
	 * stops the main game loop
	 */
	public synchronized void stop(boolean exit) {
		if(exit){
			System.exit(0);
		}else{
			reset();
		}

	}

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
				deltaNs -= nanosPerTick;// possible set it to 0 alternatively,
				updateView();			// depending on certain factors
			}
			
			

		}
		

	}
	
	/**
	 * gets called at 60Hz in the main game loop
	 */
	@Override
	public void onTick(){
		if(state == GameState.MENU_SCREEN){
			if(menu == null){
				showMenuCursor();
				menu = new MenuScreen();
				view.addMouseListener(menu);
				view.addKeyListener(menu);
				view.addMouseMotionListener(menu);
			}
			menu.onTick();
			if(menu.isDone()){
				state = GameState.OVERFISHING_GAME_ANIMATION;
				view.removeKeyListener(menu);
				view.removeMouseListener(menu);
				view.removeMouseMotionListener(menu);
				menu = null;
			}
			
		}
		else if (state == GameState.OVERFISHING_GAME_ANIMATION){
			if(overfishingAnimation==null){
				overfishingAnimation = new OverfishingAnimation();
				view.addMouseListener(overfishingAnimation);
				view.addKeyListener(overfishingAnimation);
				view.addMouseMotionListener(overfishingAnimation);
				hideCursor();
				lastTime=System.nanoTime();
			}
			overfishingAnimation.onTick();
			if(overfishingAnimation.isDone()){
				state = GameState.OVERFISHING_GAME;
				view.removeKeyListener(overfishingAnimation);
				view.removeMouseListener(overfishingAnimation);
				view.removeMouseMotionListener(overfishingAnimation);
				overfishingAnimation=null;
			}else if(overfishingAnimation.sentStopSignal()){
				stop(false);
			}
			
			
		}
		else if (state == GameState.OVERFISHING_GAME){
			if(overfishingGame==null){
				overfishingGame = new OverfishingGame();
				view.addMouseListener(overfishingGame);
				view.addKeyListener(overfishingGame);
				view.addMouseMotionListener(overfishingGame);
				hideCursor();
				lastTime=System.nanoTime();
			}
			overfishingGame.onTick();
			if(overfishingGame.isDone()){
				
				///**** save GAME 1 stuff here ******/////
				
				state = GameState.CRAB_SAVE_GAME_ANIMATION;
				view.removeKeyListener(overfishingGame);
				view.removeMouseListener(overfishingGame);
				view.removeMouseMotionListener(overfishingGame);
				overfishingGame=null;
			}else if(overfishingGame.sentStopSignal()){
				stop(false);
			}
			
			
		}
		else if (state == GameState.CRAB_SAVE_GAME_ANIMATION){
			if(crabSaveAnimation==null){
				crabSaveAnimation = new CrabSaveAnimation();
				view.addMouseListener(crabSaveAnimation);
				view.addKeyListener(crabSaveAnimation);
				view.addMouseMotionListener(crabSaveAnimation);
				hideCursor();
				lastTime=System.nanoTime();
			}
			crabSaveAnimation.onTick();
			if(crabSaveAnimation.isDone()){
				state = GameState.CRAB_SAVE_GAME;
				view.removeKeyListener(crabSaveAnimation);
				view.removeMouseListener(crabSaveAnimation);
				view.removeMouseMotionListener(crabSaveAnimation);
				crabSaveAnimation=null;
			}else if(crabSaveAnimation.sentStopSignal()){
				stop(false);
			}
			
			
		}
		
		else if (state==GameState.CRAB_SAVE_GAME){
			if(crabSaveGame==null){
				crabSaveGame = new CrabSaveGame();
				view.addMouseListener(crabSaveGame);
				view.addKeyListener(crabSaveGame);
				view.addMouseMotionListener(crabSaveGame);
				hideCursor();
				lastTime=System.nanoTime();
			}
			crabSaveGame.onTick();
			if(crabSaveGame.isDone()){
				
				///**** save GAME 2 stuff here ******/////
				state = GameState.POLLUTION_GAME;
				view.removeKeyListener(crabSaveGame);
				view.removeMouseListener(crabSaveGame);
				view.removeMouseMotionListener(crabSaveGame);
				crabSaveGame=null;
			}else if(crabSaveGame.sentStopSignal()){
				stop(false);
			}
		}
		else if (state==GameState.POLLUTION_GAME){
			if(pollutionGame==null){
				pollutionGame = new PollutionGame();
				view.addMouseListener(pollutionGame);
				view.addKeyListener(pollutionGame);
				view.addMouseMotionListener(pollutionGame);
				lastTime=System.nanoTime();
				hideCursor();
			}
			pollutionGame.onTick();
			if(pollutionGame.isDone()){
				///**** save GAME 3 stuff here ******/////
				state = GameState.SHOW_STATS;
				view.removeKeyListener(pollutionGame);
				view.removeMouseListener(pollutionGame);
				view.removeMouseListener(pollutionGame);
				pollutionGame=null;
			}else if(pollutionGame.sentStopSignal()){
				stop(false);
			}
		}
	}
	
	/**
	 * redraws the screen when an onTick() has occurred.  Gets called right after all tick
	 */
	private void updateView(){
		if(state==GameState.MENU_SCREEN && menu!=null){
			view.render(menu);	
			
		}
		else if (state ==GameState.OVERFISHING_GAME_ANIMATION && overfishingAnimation!=null){
			view.render(overfishingAnimation);
		}
		else if (state == GameState.OVERFISHING_GAME && overfishingGame!=null){
			view.render(overfishingGame);
			
		}
		else if (state==GameState.CRAB_SAVE_GAME_ANIMATION && crabSaveAnimation!=null){
			view.render(crabSaveAnimation);
		}
		else if (state==GameState.CRAB_SAVE_GAME && crabSaveGame!=null){
			view.render(crabSaveGame);
		}
		else if (state==GameState.POLLUTION_GAME && pollutionGame!=null){
			view.render(pollutionGame);
		}
		
	}

	
	/**
	 * 
	 * @return whether or not the game is currently running
	 */
	public boolean isRunning() {
		return running;
	}
	
	
	public static void hideCursor(){
		frame.getContentPane().setCursor(blankCursor);
	}
	public static void showMenuCursor(){
		frame.getContentPane().setCursor(menuCursor);
	}
	
	private void reset(){
		state = GameState.MENU_SCREEN;
		overfishingGame=null;
		crabSaveGame=null;
		pollutionGame=null;
		
		
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
		
		if(e.getKeyCode()==KeyEvent.VK_1){
			state=GameState.OVERFISHING_GAME;
		}
		if(e.getKeyCode()==KeyEvent.VK_2){
			state=GameState.CRAB_SAVE_GAME_ANIMATION;
		}
		if(e.getKeyCode()==KeyEvent.VK_3){
			state=GameState.CRAB_SAVE_GAME;
		}
		if(e.getKeyCode()==KeyEvent.VK_4){
			state=GameState.POLLUTION_GAME;
		}
		if(e.getKeyCode()==KeyEvent.VK_5){
			state=GameState.POLLUTION_GAME;
		}
		if(e.getKeyCode()==KeyEvent.VK_6){
			state=GameState.POLLUTION_GAME;
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
