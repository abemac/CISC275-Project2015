package misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

public class MenuScreen implements Tickable,Renderable,MouseListener,KeyListener,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7530214348178987192L;
	private boolean isDone;
	private final RectBounds startButton = new RectBounds(-300, -200, 600, 400);
	private final Font titleFont = new Font("default",Font.BOLD,200);
	private final Font startFont =new Font("default",Font.BOLD,150);
	private BufferedImage fish;
	public MenuScreen(){
		isDone = false;
		loadRes();
	}
	
	public void loadRes(){
		try {
			fish = Util.loadImage("/goldfish.png", this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(-Util.getDISTANCE_TO_EDGE(), -1000, Util.getCANVAS_WIDTH_SCALED(), 2000);
		g.setColor(Color.ORANGE);
		g.setFont(titleFont); //change size later
		Util.drawCenteredString("Estuary Adventure!", 0, -500, g);
		
		g.setColor(Color.GREEN);
		g.fillRect(startButton.getX(),startButton.getY(),startButton.getXLength(),startButton.getYLength());
		g.setColor(Color.BLUE);
		Util.drawCenteredString("Start!", 0, 50, g);
		
		g.drawImage(fish,-500,0,1000,1000,null);
		
	}

	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		
	}


	public boolean isDone(){
		return isDone;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
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
		if(Util.isInBox(e, startButton)){
			isDone = true;
		}
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
