package games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import characters.Crab;
import enemies.TheHuman;
import enemies.Trash;
import misc.ArbitraryLine;
import misc.TrashCan;
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
	private TrashCan trashCan;
	
	
	private Crab crab;
	private Color sand = new Color(255,237,108);
	private Color sky = new Color(130,202,255);
	private BufferedImage sun,bg,pond;
	
	private ArbitraryLine pondLine,skyLine;
	
	/**
	 * calls the super constructor
	 */
	public CrabSaveGame(){
		super();
		loadRes();
	}
	/**
	 * gets called in the constructor to initialized components of the game
	 */
	public void init(){
		crab=new Crab(0, 0, 100,this);
		trashCan=new TrashCan(375, -930);
		int[]pts={0,148,110,80,176,58,374,126,546,164,678,140,822,64,978,64,1176,144,1294,134,1500,224};
		pondLine=new ArbitraryLine(pts, Util.getDISTANCE_TO_EDGE()/(1500/2f), 500f/330f, 500);
		pondLine.setX(-Util.getDISTANCE_TO_EDGE());
		int[]pts2={0,428,232,390,406,390,820,460,990,442,1246,338,1526,382,1826,418,1882,424,2000,406};
		skyLine=new ArbitraryLine(pts2, Util.getDISTANCE_TO_EDGE()/(2000/2f), 600f/800f, -850);
		skyLine.setX(-Util.getDISTANCE_TO_EDGE());
		
		trash=new ArrayList<Trash>();
		trash.add(new Trash(0, -300, Trash.BANANA));
		trash.add(new Trash(-900,-400,Trash.BOTTLE));
		trash.add(new Trash(500,0,Trash.ROPE));
		trash.add(new Trash(-1000,0,Trash.MILK_JUG));
		trash.add(new Trash(900,-400,Trash.SHOPPING_BAG));
		trash.add(new Trash(1000,500,Trash.SODA_CAN));
	}
	
	
	/**
	 * loads the resources needed
	 */
	private void loadRes(){
		try {
			sun = Util.loadImage("/sun.png", this);
			bg= Util.loadImage("/Game2Background(smaller).png",Util.getCANVAS_WIDTH_SCALED(),800, this);
			pond = Util.loadImage("/game2water.png",Util.getCANVAS_WIDTH_SCALED(),500, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * gets called 60 times/sec and handles updates to the game
	 */
	@Override
	public void onTick() {
		
		crab.onTick();
		if(pondLine.isBelowLine(crab.getX(), crab.getY()+400)){
			crab.setY(crab.getY()-6*(crab.getY()+1000)/1500.0);
			crab.setX(crab.getX()+.5);
			
		}
		if(skyLine.isAboveLine(crab.getX(), crab.getY())){
			crab.setY(crab.getY()+6*(crab.getY()+1000)/1500.0);
			crab.setX(crab.getX()-.5);
		}
		
		for(Trash t: trash){
			t.act();
		}
		
		tellCrabToHoldTrash();
		
	}
	
	/**
	 * adds trash back if crab missed the throw
	 * @param t
	 */
	public void addBackTrash(Trash t){
		trash.add(t);
	}
	
	
	private void tellCrabToHoldTrash(){
		Iterator<Trash> i = trash.iterator();
		while(i.hasNext()){
			Trash t = i.next();
			if(crab.isTouchingTrash(t) && !crab.isHoldingTrash()){
				crab.holdTrash(t);
				crab.setIsHoldingTrash(true);
				i.remove();
			}
		}
	}
	
	/**
	 * draws the crabSaveGame
	 * @param g the graphcis to draw to
	 */
	public void render(Graphics2D g){
		
		g.setColor(sand);
		g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), 2000);
		g.setColor(sky);
		g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), 600);
		g.drawImage(bg,-Util.getDISTANCE_TO_EDGE(),-1000,null);	
		g.drawImage(sun, -Util.getDISTANCE_TO_EDGE()-400,-1600,1000,1300,null);
		g.drawImage(pond, -Util.getDISTANCE_TO_EDGE(), 500, null);
		
		trashCan.render(g);
		
		for(Trash t: trash){
			t.render(g);
		}
		crab.render(g);
		trashCan.renderOverlay(g);
		crab.renderThrownTrash(g);
		
		
		
		//pondLine.testRender(g); //GOOD
		//skyLine.testRender(g);  //GOOD
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
	
	
	/**
	 * returns true if this game isDone
	 * @return boolean showing whether the game is done or not
	 */
	public boolean isDone(){
		return false;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		crab.keyPressed(arg0);
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		crab.keyReleased(arg0);
		
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
