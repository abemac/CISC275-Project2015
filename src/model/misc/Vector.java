package model.misc;

import java.io.Serializable;

public class Vector implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double x,y,z;
	
	public Vector(double x,double y){
		this.x=x;
		this.y=y;
		this.z=0;
	}
	
	public Vector(double x,double y,double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	
	public double getX(){
		return x;
	}
	public double getY(){
		return y;
	}
	public double getZ(){
		return z;
	}
	
	public void setX(double x){
		this.x=x;
	}
	public void setY(double y){
		this.y=y;
	}
	public void setZ(double z){
		this.z=z;
	}
	
	public void add(Vector a){
		x+=a.x;
		y+=a.y;
		z+=a.z;
	}
	

}
