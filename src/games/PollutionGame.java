package games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import characters.Game3Crab;
import enemies.Pollutant;
import misc.ArbitraryLine;
import misc.Util;

/**
 * Models the Pollution Game
 * @author abraham
 *
 */
public class PollutionGame extends Game {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4135658807008338789L;
	private int numCollided;
	private int numRemoved;
	private ArrayList<Pollutant> pollutants;
	private Color water = new Color(114,145,215);
	private BufferedImage seaFloor;
	private ArbitraryLine seaFloorLine;
	
	private Game3Crab crab;
	
	/**
	 * calls the super constructor
	 */
	public PollutionGame(){
		super();
		loadRes();
		
	}

	
	public void init(){
		
		
		
		crab=new Game3Crab(0, 0, 100,seaFloorLine);
	}
	
	private void loadRes(){
		
		try {
			seaFloor=Util.loadImage("/sea floor (smaller-forgame3).png",Util.getCANVAS_WIDTH_SCALED(),750, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * gets called 60 times per second.  Handles updating
	 */
	@Override
	public void onTick() {
		
		crab.onTick();
	}
	/**
	 * defines how to draw the pollution game
	 */
	public void render(Graphics2D g){
		g.setColor(water);
		g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), 2000);
		g.drawImage(seaFloor, -Util.getDISTANCE_TO_EDGE(), 250, null);
		crab.render(g);
	}
	
	/**
	 * starts the pollution flow
	 */
	public void startPollutionFlow(){};
	/**
	 * stops the pollution flow
	 */
	public void stopPollutionFlow(){}

	/**
	 * 
	 * @return the number of pollution ojbects the fish has collided with
	 */
	public int getNumCollided() {
		return numCollided;
	}
	/**
	 * 
	 * @return the numbmer of pollution objects the fish has helped remove
	 */
	public int getNumRemoved() {
		return numRemoved;
	}
	
	/**
	 * @return the ArrayList of pollutants
	 */
	public ArrayList<Pollutant> getPollutants() {
		return pollutants;
	};
	
	/**
	 * returns whether or not this game is done
	 * @return boolean whether or not game is done
	 */
	public boolean isDone(){
		return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		crab.keyPressed(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		crab.keyReleased(e);
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
