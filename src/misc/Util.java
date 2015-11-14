package misc;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Util {

	public static double SCALE_FACTOR =-1;
	public static double CANVAS_WIDTH=-1;
	public static double CANVAS_HEIGHT=-1;
	public static int DISTANCE_TO_EDGE=-1;
	
	
	
	public static boolean isInBox(MouseEvent e,RectBounds rb){
		int x = (int) ((e.getX()-CANVAS_WIDTH/2.0)/SCALE_FACTOR);
		int y = (int) ((e.getY() - CANVAS_HEIGHT/2.0)/SCALE_FACTOR);
		
		return (x >= rb.getX() && x<=rb.getX()+rb.getXLength() &&
				y>=rb.getY() && y <=rb.getY() + rb.getYLength());
			
	}
	
	/**
	 * takes SCALED coordinates
	 * @param start
	 * @param slope
	 * @param x
	 * @param y
	 * @return
	 */;
	public static boolean isBelowSlope(double startx,double starty,double slope,double x,double y){
		return (y>(starty+slope*(x-startx)));
	
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////
	public static void setCanvasWidth(int width){
		if(CANVAS_WIDTH==-1){
			CANVAS_WIDTH = width;
		}
	}
	public static void setCanvasHeight(int height){
		if(CANVAS_HEIGHT==-1)
			CANVAS_HEIGHT=height;
	}
	
	
	public static void setCurrentScaleFactor(double sf){
		if(SCALE_FACTOR ==-1){
			SCALE_FACTOR =sf;
		}
	}
	
	public static void setDistanceToEdge(int width,int height){
		if(DISTANCE_TO_EDGE==-1)
			DISTANCE_TO_EDGE= (int) (( (double)(width) / (double)(height) )*1000.0);
	}
	
	
	
	/**
	 * 
	 * @return the extra Distance to add to 1000 to get to the edge of the horizontal screen
	 */
	public static int getExtraDistance(){
		return DISTANCE_TO_EDGE -1000;
	}
	
	
	//////////////////////////////////////////////////////////
	private static int len;
	public static void drawCenteredString(String s, int xPos, int yPos,Graphics2D g2d){
		len = (int) g2d.getFontMetrics().stringWidth(s);
		g2d.drawString(s, xPos-len/2, yPos);
	}
	
	/////////////////////////////////////////////////////////
	
	public static BufferedImage loadImage(String path,Object host) throws IOException{
		return ImageIO.read(host.getClass().getResource(path));
	}
	
	
	
	
}
