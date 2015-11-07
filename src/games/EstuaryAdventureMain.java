package games;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import misc.GameState;
import misc.Tickable;
import view.EstuaryView;

public class EstuaryAdventureMain extends JPanel implements Runnable,Tickable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4347325551128251031L;

	private static final Dimension PREFERRED_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	
	private boolean running= false;
	private Thread thread;
	private EstuaryView view;
	private GameState state;
	
	//Variables used to control updating frequency in run()
	private long lastTime,now;
	private final double ticksPerSecond = 60.0;
	private double nanosPerTick = 1000000000.0 / ticksPerSecond;
	private double deltaNs = 0;
	
	
	public EstuaryAdventureMain(){
		init();
	}
	
	
	private void init(){
		view = new EstuaryView();
		state = GameState.MENU_SCREEN;
		view.setPreferredSize(PREFERRED_SIZE);
		
		view.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
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
		//view.render(state);
		while (running) {
			now = System.nanoTime();
			deltaNs += (now - lastTime);
			lastTime = now;
			if (deltaNs > nanosPerTick) {
				onTick();
				deltaNs -= nanosPerTick; // possible set it to 0 alternatively,
				updateView();							// depending on certain factors
			}
			
			

		}

		stop();

	}
	
	
	@Override
	public void onTick(){
		
	}
	
	private void updateView(){
		view.render(new OverfishingGame());
		
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
		EstuaryAdventureMain game = new EstuaryAdventureMain();
		frame = new JFrame("Estuary Adventure!");
		frame.add(game.view);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.pack();
		frame.setLocationRelativeTo(null);		
		frame.setVisible(true);
		game.start();
		
		
		
	}
	
	
	
	

}
