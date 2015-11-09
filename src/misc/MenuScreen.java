package misc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.PaintContext;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;

public class MenuScreen implements Tickable,Renderable,MouseListener,KeyListener{

	private boolean isDone;
	private final RectBounds startButton = new RectBounds(-300, -200, 600, 400);
	private final Font titleFont = new Font("default",Font.BOLD,200);
	private final Font startFont =new Font("default",Font.BOLD,150);
	public MenuScreen(){
		isDone = false;
	}
	
	
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(-Util.DISTANCE_TO_EDGE, -1000, 2*Util.DISTANCE_TO_EDGE, 2000);
		g.setColor(Color.ORANGE);
		g.setFont(titleFont); //change size later
		Util.drawCenteredString("Estuary Adventure!", 0, -500, g);
		
		g.setColor(Color.GREEN);
		g.fillRect(startButton.getX(),startButton.getY(),startButton.getXLength(),startButton.getYLength());
		g.setColor(Color.BLUE);
		Util.drawCenteredString("Start!", 0, 50, g);
		
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
