package misc;

public class Util {

	public static double scaleFactor =-1;
	public static double canvasWidth=-1;
	public static double canvasHeight=-1;
	
	
	
	
	public boolean isInBox(int absX,int absY,int scaleSizeX,int scaleSizeY){
		
		
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
