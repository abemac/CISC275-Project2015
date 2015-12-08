package model.misc;

import java.io.Serializable;

public class RectBounds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2844190309772266987L;
	private int x;
	private int y;
	private int xl;
	private int yl;
	
	public RectBounds(int x, int y, int xLength, int yLength) {
		this.x = x;
		this.y = y;
		this.xl = xLength;
		this.yl = yLength;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getXLength() {
		return xl;
	}

	public int getYLength() {
		return yl;
	}
	
	
	
	
	
}
