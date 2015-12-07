package scorekeeping;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import misc.Renderable;
import misc.Tickable;
import misc.Util;

public class StatsScreen implements Tickable,Renderable,KeyListener,MouseListener,MouseMotionListener{

	private boolean isDone=false;
	private BufferedImage bg;
	//private ScoreKeeper scoreKeeper;
	private int OFScore;
	private int CSScore;
	private int PScore;
	private int avg;
	private Color barColor = new Color(125,112,165);
	private Color timerColor=new Color(178,170,236);
	private final Font timerFont = new Font("default",Font.BOLD,70);
	
	public StatsScreen(ScoreKeeper scorekeeper) {
		loadRes();
//		OFScore=scorekeeper.getOverfishingScore().getCalculatedScore();
//		CSScore = scorekeeper.getCrabSaveScore().getCalculatedScore();
//		PScore = scorekeeper.getPollutionScore().getCalculatedScore();
		OFScore=75;
		CSScore = 50;
		PScore = 100;
		avg=(OFScore+CSScore+PScore)/3;
		bar1Pos=-xAxisPos;
		bar2Pos=-xAxisPos;
		bar3Pos=-xAxisPos;
		bar4Pos=-xAxisPos;
	}
	
	
	private void loadRes(){
		try {
			bg = Util.loadImage("/stats.png",Util.getCANVAS_WIDTH_SCALED(),Util.getCANVAS_HEIGHT_SCALED(), this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private double bar1Pos,bar2Pos,bar3Pos,bar4Pos;
	private int xAxisPos=323;
	private double scale=10;
	
	@Override
	public void render(Graphics2D g) {
		g.drawImage(bg, -Util.getDISTANCE_TO_EDGE(), -1000, null);
		
	    g.setColor(barColor);
	    g.fillRect((int)(-Util.getDISTANCE_TO_EDGE()/1.4f),(int)( xAxisPos-bar1Pos),350,(int)( xAxisPos+bar1Pos));
	    g.fillRect((int)(-Util.getDISTANCE_TO_EDGE()/3.5f),(int)( xAxisPos-bar2Pos),350,(int)( xAxisPos+bar2Pos));
	    g.fillRect((int)(Util.getDISTANCE_TO_EDGE()/7f),(int)( xAxisPos-bar3Pos),350,(int)( xAxisPos+bar3Pos));
	    g.fillRect((int)(Util.getDISTANCE_TO_EDGE()/1.85f),(int)( xAxisPos-bar4Pos),350,(int)( xAxisPos+bar4Pos));
	    
	    
	    g.setFont(timerFont);
	 //   g.setColor(timerColor);
	    Util.drawCenteredString(""+(int)((bar1Pos+xAxisPos)/scale+1),(int)(-Util.getDISTANCE_TO_EDGE()/1.4f+170),(int)(xAxisPos-bar1Pos)-20,g);
	    Util.drawCenteredString(""+(int)((bar2Pos+xAxisPos)/scale+1),(int)(-Util.getDISTANCE_TO_EDGE()/3.5f+170),(int)(xAxisPos-bar2Pos)-20,g);
	    Util.drawCenteredString(""+(int)((bar3Pos+xAxisPos)/scale+1),(int)(Util.getDISTANCE_TO_EDGE()/7f+170),(int)(xAxisPos-bar3Pos)-20,g);
	    Util.drawCenteredString(""+(int)((bar4Pos+xAxisPos)/scale+1),(int)(Util.getDISTANCE_TO_EDGE()/1.85f+170),(int)(xAxisPos-bar4Pos)-20,g);

	}
	
	
	@Override
	public void onTick() {
		
		bar1Pos+=(OFScore*scale-(bar1Pos+xAxisPos))/15f;
		bar2Pos+=(CSScore*scale-(bar2Pos+xAxisPos))/15f;
		bar3Pos+=(PScore*scale-(bar3Pos+xAxisPos))/15f;
		bar4Pos+=(avg*scale-(bar4Pos+xAxisPos))/15f;
	}
	
	public boolean isDone(){
		return isDone;
	}

	


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
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
	public void keyPressed(KeyEvent e) {
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyTyped(KeyEvent e) {
		isDone=true;
		
	}

}
