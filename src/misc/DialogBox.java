package misc;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import games.Game;

public class DialogBox implements Tickable,Renderable,Serializable,MouseListener,MouseMotionListener {
	
	private BufferedImage selectedButton,leftButton,rightButton,titleCaught,titleNiceJob,titleGreat;
	private boolean overRightButton,overLeftButton;
	private Game host;
	
	private Stroke stroke = new BasicStroke(20);
	
	private Color bgColor= new Color(234,200,63);
	/**
	 * 
	 */
	private static final long serialVersionUID = 5904433052230976135L;

	public static final int TITLE_CAUGHT=0;
	public static final int TITLE_NICE_JOB=1;
	public static final int TITLE_GREAT=2;
	
	private int title;
	
	
	public DialogBox(Game host){
		this.host= host;
		loadRes();
		title=TITLE_CAUGHT;
	}
	
	private void loadRes(){
		try {
			selectedButton = Util.loadImage("/selectedButtonOverlay.png",278,282,this);
			leftButton = Util.loadImage("/DialogBox-leftButton.png",294,280, this);
			rightButton = Util.loadImage("/DialogBox-rightButton.png",304,294, this);
			titleCaught = Util.loadImage("/title-caught.png",600,200, this);
			titleNiceJob = Util.loadImage("/title-goodjob.png",600,200, this);
			titleGreat = Util.loadImage("/title-great.png",600,200, this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void render(Graphics2D g) {
		g.setColor(bgColor);
		
		g.fillRoundRect(-520, -650, 1100, 1100, 200, 200);
		g.setColor(Color.BLACK);
		g.setStroke(stroke);
		g.drawRoundRect(-520, -650, 1100, 1100, 200, 200);
		
		g.drawImage(leftButton,-270,100, null);
		g.drawImage(rightButton, 60, 100, null);
		
		if(overRightButton)
			g.drawImage(selectedButton,75,100,null);
		
		if(overLeftButton)
			g.drawImage(selectedButton, -270, 100, null);
		
		if(title==TITLE_CAUGHT){
			g.drawImage(titleCaught, -250, -600, null);
		}
		else if(title==TITLE_GREAT){
			g.drawImage(titleGreat, -250, -600, null);
		}else if(title==TITLE_NICE_JOB){
			g.drawImage(titleNiceJob, -255, -600, null);
		}
		
		
		
	}

	@Override
	public void onTick() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public void setTitle(int title){
		this.title=title;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private Point rightBCenter = new Point(180,240);
	private Point leftBCenter = new Point(-140,240);
	@Override
	public void mouseMoved(MouseEvent e) {
		if(Util.isInCircle(e, rightBCenter, 130)){
			overRightButton=true;
		}else
			overRightButton=false;
		
		if(Util.isInCircle(e, leftBCenter, 130)){
			overLeftButton=true;
		}else
			overLeftButton=false;
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(overRightButton){
			host.setIsDone(true);
		}
		if(overLeftButton){
			host.sendStopSignal();
		}
		
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
