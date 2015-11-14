package misc;

import java.util.ArrayList;

public class ArbitraryLine {

	
	
	
	private ArrayList<Point> points;
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
	public ArbitraryLine(int[] pts,int xScale,int yOffset){
		points=new ArrayList<Point>();
		this.xScale=xScale;
		this.yOffset=yOffset;
		
		int i=0;
		while(i<pts.length-1){
			points.add(new Point(pts[i]*xScale, pts[i+1]+yOffset));
			i+=2;
		}
		calculateSlopes();
		
		
	}
	
	/**
	 * positive slope is actually downward due to screen coordinates
	 */
	private void calculateSlopes(){
		for(int i=0;i<points.size()-1;i++){
			slopes.add((points.get(i+1).y-points.get(i).y)/(points.get(i+1).x-points.get(i).x));
		}
		
	}
	
	
	/**
	 * takes SCALED coordinates
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean isBelowLine(double x, double y){
		
		int i=0;
		if(xPos+points.get(i).x>x || x>points.get(points.size()-1).x){
			return false;
		}
		while(xPos+points.get(i+1).x<x){i++;}
	
		return Util.isBelowSlope(points.get(i), slopes.get(i), x, y);
	}
	
	
	public void setX(double x){
		this.xPos=x;
	}
	public void setY(double y){
		this.yPos=y;
	}
	
	
	
	
	
	
	
	
	
	
}
