package games;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import characters.Game3Crab;
import characters.Game3Fish;
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
	private Game3Fish fish;
	
	/**
	 * calls the super constructor
	 */
	public PollutionGame(){
		super();
		loadRes();
		
	}

	
	public void init(){
		
		double[]pts={0.00,217.50, 33.00,208.50, 33.00,208.50,
	             33.00,208.50, 78.00,180.00 ,78.00,180.00,
	             78.00,180.00, 99.00,163.50 ,99.00,163.50,
	             99.00,163.50, 126.00,151.50, 126.00,151.50,
	             126.00,151.50 ,141.00,148.50 ,141.00,148.50,
	             141.00,148.50, 169.50,150.00, 169.50,150.00,
	             169.50,150.00, 196.50,162.00 ,196.50,162.00,
	             196.50,162.00, 232.50,180.00, 232.50,180.00,
	             232.50,180.00 ,264.00,210.00, 264.00,210.00,
	             264.00,210.00, 297.00,249.00, 297.00,249.00,
	             297.00,249.00, 319.50,289.50 ,319.50,289.50,
	             319.50,289.50, 334.50,321.00, 334.50,321.00,
	             334.50,321.00, 354.00,349.50, 354.00,349.50,
	             354.00,349.50, 375.00,358.50 ,375.00,358.50,
	             375.00,358.50, 394.50,366.00 ,394.50,366.00,
	             394.50,366.00, 429.00,372.00, 429.00,372.00,
	             429.00,372.00, 466.50,373.50 ,466.50,373.50,
	             466.50,373.50, 490.50,369.00 ,490.50,369.00,
	             490.50,369.00, 523.50,358.50 ,523.50,358.50,
	             523.50,358.50, 543.00,348.00 ,543.00,348.00,
	             543.00,348.00, 565.50,340.50, 565.50,340.50,
	             565.50,340.50 ,595.50,325.50 ,595.50,325.50,
	             595.50,325.50, 618.00,313.50 ,618.00,313.50,
	             618.00,313.50, 651.00,306.00, 651.00,306.00,
	             651.00,306.00, 682.50,298.50, 682.50,298.50,
	             682.50,298.50, 721.50,295.50, 721.50,295.50,
	             721.50,295.50 ,753.00,285.00 ,753.00,285.00,
	             753.00,285.00, 781.50,274.50, 781.50,274.50,
	             781.50,274.50, 814.50,258.00, 814.50,258.00,
	             814.50,258.00, 846.00,247.50,846.00,247.50,
	             846.00,247.50, 876.00,243.00 ,876.00,243.00,
	             876.00,243.00, 904.50,240.00, 904.50,240.00,
	             904.50,240.00, 925.50,241.50 ,925.50,241.50,
	             925.50,241.50, 949.50,243.00 ,949.50,243.00,
	             949.50,243.00, 973.50,249.00 ,973.50,249.00,
	             973.50,249.00, 993.00,258.00, 993.00,258.00,
	             993.00,258.00, 1015.50,270.00 ,1015.50,270.00,
	             1015.50,270.00, 1038.00,282.00, 1038.00,282.00,
	             1038.00,282.00, 1054.50,291.00, 1054.50,291.00,
	             1054.50,291.00, 1081.50,297.00 ,1081.50,297.00,
	             1081.50,297.00, 1099.50,304.50, 1099.50,304.50,
	             1099.50,304.50, 1123.50,313.50 ,1123.50,313.50,
	             1123.50,313.50 ,1152.00,324.00 ,1152.00,324.00,
	             1152.00,324.00, 1182.00,328.50 ,1182.00,328.50,
	             1182.00,328.50, 1210.50,333.00 ,1210.50,333.00,
	             1210.50,333.00 ,1236.00,334.50 ,1236.00,334.50,
	             1236.00,334.50 ,1266.00,333.00 ,1266.00,333.00,
	             1266.00,333.00, 1294.50,325.50 ,1294.50,325.50,
	             1294.50,325.50, 1318.50,316.50, 1318.50,316.50,
	             1318.50,316.50, 1336.50,312.00 ,1336.50,312.00,
	             1336.50,312.00 ,1354.50,303.00, 1354.50,303.00,
	             1354.50,303.00, 1374.00,286.50 ,1374.00,286.50,
	             1374.00,286.50, 1393.50,273.00 ,1393.50,273.00,
	             1393.50,273.00 ,1416.00,262.50 ,1416.00,262.50,
	             1416.00,262.50, 1434.00,253.50 ,1434.00,253.50,
	             1434.00,253.50, 1456.50,249.00 ,1456.50,249.00,
	             1456.50,249.00, 1477.50,250.50 ,1477.50,250.50,
	             1477.50,250.50, 1492.50,250.50 ,1500,250.50};
		seaFloorLine = new ArbitraryLine(pts, Util.getDISTANCE_TO_EDGE()/750.0,750.0/500.0, 250);
		seaFloorLine.setX(-Util.getDISTANCE_TO_EDGE());
		crab=new Game3Crab(0, 100,seaFloorLine);
		
		fish=new Game3Fish(crab);
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
		fish.onTick();
	}
	/**
	 * defines how to draw the pollution game
	 */
	public void render(Graphics2D g){
		g.setColor(water);
		g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), 2000);
		g.drawImage(seaFloor, -Util.getDISTANCE_TO_EDGE(), 250, null);
		crab.render(g);
		//seaFloorLine.testRender(g);//GOOD
		fish.render(g);
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
