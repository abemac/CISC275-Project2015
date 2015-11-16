package games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import enemies.TheHuman;
import enemies.Trash;
import misc.Util;

/**
 * Models the CrabSaveGame
 * @author abraham
 *
 */
public class CrabSaveGame extends Game {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1609844265788718695L;
	private int numTrashPickedup;
	private ArrayList<Trash> trash;
	private TheHuman theHuman;
	private Color sand = new Color(234,208,73);
	private Color sky = new Color(153,179,211);
	
	private BufferedImage sun;
	
	/**
	 * calls the super constructor
	 */
	public CrabSaveGame(){
		super();
		loadRes();
	}

	
	private void loadRes(){
		try {
			sun = Util.loadImage("/sun.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * gets called 60 times/sec and handles updates to the game
	 */
	@Override
	public void onTick() {
		moveHuman();
		
	}
	
	public void render(Graphics2D g){
		g.setColor(sand);
		g.fillRect(-Util.DISTANCE_TO_EDGE, -1000, 2*Util.DISTANCE_TO_EDGE, 2000);
		g.setColor(sky);
		g.fillRect(-Util.DISTANCE_TO_EDGE, -1000, 2*Util.DISTANCE_TO_EDGE, 600);
		
		g.drawImage(sun, -Util.DISTANCE_TO_EDGE-400,-1600,1000,1300,null);
		
	}
	
	
	/**
	 * moves the Human
	 */
	public void moveHuman(){};
	/**
	 * removes Trash
	 * @param t the trash to remove
	 */
	public void removeTrash(Trash t){}


	/**
	 * 
	 * @return the number of Trash the user has cleaned up
	 */
	public int getNumTrashPickedup() {
		return numTrashPickedup;
	}


	/**
	 * 
	 * @return the arrayList of all current Trash objects
	 */
	public ArrayList<Trash> getTrash() {
		return trash;
	}


	/**
	 * 
	 * @return the Human in the game
	 */
	public TheHuman getTheHuman() {
		return theHuman;
	};
	
	
	
	public boolean isDone(){
		return false;
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
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
