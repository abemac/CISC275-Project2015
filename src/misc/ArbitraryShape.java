package misc;

import java.util.ArrayList;

public class ArbitraryShape {

	
	private class Pair{
		public double x;
		public double y;
		public Pair(int x,int y){
			this.x = x;
			this.y=y;
		}
	}
	
	
	private ArrayList<Pair> points;
	private ArrayList<Double> slopes;	
	
	private double xScale;
	private double yOffset;
	
	private double xPos,yPos;
	
	/**
	 * xscale = Util*Distancetoedge/(picsize/4)
	 * @param pts
	 * @param xScale
	 * @param yOffset
	 */
	public ArbitraryShape(int[] pts,int xScale,int yOffset){
		points=new ArrayList<Pair>();
		this.xScale=xScale;
		this.yOffset=yOffset;
		
		int i=0;
		while(i<pts.length-1){
			points.add(new Pair(pts[i]*xScale, pts[i+1]+yOffset));
			i+=2;
		}
		calculateSlopes();
		
		
	}
	
	private void calculateSlopes(){
		for(int i=0;i<points.size()-1;i++){
			slopes.add((points.get(i).y-points.get(i+1).y)/(points.get(i).x-points.get(i+1).x));
		}
		
	}
	
	public void setX(double x){
		this.xPos=x;
	}
	public void setY(double y){
		this.yPos=y;
	}
	
	
	
	
	
	
	
	
	
	
}
