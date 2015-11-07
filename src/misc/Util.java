package misc;

import java.awt.event.MouseEvent;

public class Util {

	public static double scaleFactor =-1;
	public static double canvasWidth=-1;
	public static double canvasHeight=-1;
	
	
	
	
	public boolean isInBox(MouseEvent e,int scaleSizeX,int scaleSizeY){
		int scaleX = (int) ((e.getX()-canvasWidth/2.0)/scaleFactor);
		int scaleY = (int) ((e.getY() - canvasHeight/2.0)/scaleFactor);
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public static void setCanvasWidth(int width){
		if(canvasWidth==-1){
			canvasWidth = width;
		}
	}
	public static void setCanvasHeight(int height){
		if(canvasHeight==-1)
			canvasHeight=height;
	}
	
	
	public static void setCurrentScaleFactor(double sf){
		if(scaleFactor ==-1){
			scaleFactor =sf;
		}
	}
	
}
