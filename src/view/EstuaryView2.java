package view;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import games.EstuaryAdventureMain;
import misc.Renderable;

public class EstuaryView2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Renderable current;
	
	public EstuaryView2(){
		setDoubleBuffered(true);
		
	}
	
	
	public void paint(Graphics g){
		//Graphics2D g2d = (Graphics2D)g;
		current.render((Graphics2D)g);
		//g.dispose();
		
		
		
	}
	
	public void setRenderable(Renderable r){
		this.current = r;
	}
	
	
}
