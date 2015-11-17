package misc;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

public class ArbitraryLine implements Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1316185101345685629L;
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
	public ArbitraryLine(int[] pts,double xScale,double yScale,double yOffset){
		points=new ArrayList<Point>();
		this.xScale=xScale;
		this.yOffset=yOffset;
		
		int i=0;
		while(i<pts.length-1){
			points.add(new Point(pts[i]*xScale, pts[i+1]*yScale+yOffset));
			i+=2;
		}
		calculateSlopes();
		
		
	}
	
	/**
	 * positive slope is actually downward due to screen coordinates
	 */
	private void calculateSlopes(){
		slopes=new ArrayList<Double>();
		for(int i=0;i<points.size()-1;i++){
			slopes.add((points.get(i+1).y-points.get(i).y)/(points.get(i+1).x-points.get(i).x));
			//System.out.println(slopes.get(i));
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
		if(xPos+points.get(0).x>=x || x>=xPos+points.get(points.size()-1).x){
			return false;
		}
		while(xPos+points.get(++i).x<x){}
		return Util.isBelowSlope(xPos+points.get(i).x,points.get(i).y, slopes.get(i-1), x, y);
	}
	
	
	public void setX(double x){
		this.xPos=x;
	}
	public void setY(double y){
		this.yPos=y;
	}
	
	
	
	public void testRender(Graphics2D g){
		int i=0;
		while(i<points.size()-1){
			g.setColor(Color.BLACK);
			g.drawLine((int)(xPos+points.get(i).x), (int)points.get(i).y, (int)(xPos+points.get(i+1).x), (int)points.get(i+1).y);
			i++;
		}
		
	}
	
	
	
	
	
	
	
	
}
