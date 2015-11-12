package misc;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	
	private BufferedImage image;
	
	private int rows,cols,rowWidth,colHeight;
	
	
	private BufferedImage[][] sprites;
	
	public SpriteSheet(BufferedImage image,int rows,int cols,int rowWidth,int colHeight){
		this.image=image;
		this.rows =rows;
		this.cols = cols;
		this.rowWidth = rowWidth;
		this.colHeight=colHeight;
		
		sprites = new BufferedImage[rows][cols];
		loadSprites();
	}
	
	
	public BufferedImage getSprite(int row,int col){
		return sprites[row][col];
	}
	
	private void loadSprites(){
		int rows2=0;
		int cols2;
		while(rows2<=rows){
			cols2=0;
			while(cols2<=cols){
				sprites[rows2][cols2] = getSubImage(rows2, cols2);
				cols2++;
			}
			
			rows2++;
		}
		
		
	}
	
	
	
	private BufferedImage getSubImage(int row, int col){
		
		BufferedImage img = image.getSubimage((col-1) *(rowWidth) , ((row-1) * colHeight), rowWidth, colHeight);
		return img; 
	}
	

	private BufferedImage getSubImage(int row, int col,int xCrop, int yCrop){
	
		BufferedImage img = image.getSubimage((col-1) *(rowWidth) , ((row-1) * colHeight), rowWidth-xCrop, colHeight-yCrop);
		return img; 
}

}