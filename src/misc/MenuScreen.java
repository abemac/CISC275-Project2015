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
	
	public MenuScreen(){
		isDone = false;
	}
	
	
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.ORANGE);
		g.setFont(new Font("default",Font.BOLD,200)); //change size later
		g.drawString("Estuary Adventure", -900, -500);//change loc later
		
		g.setColor(Color.GREEN);
		g.fillRect(-300, -200, 600, 400);
		g.setColor(Color.WHITE);
		g.drawString("Start!", -250, 50);
		
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
		if(Util.isInBox(e, new RectBounds(-300, -200, 600, 400))){
			isDone = true;
		}
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
