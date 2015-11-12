package misc;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	
	private BufferedImage image;
	
	private int rows,cols,rowHeight,colWidth;
	
	
	private BufferedImage[][] sprites;
	
	public SpriteSheet(BufferedImage image,int rows,int cols,int rowHeight,int colWidth){
		this.image=image;
		this.rows =rows;
		this.cols = cols;
		this.rowHeight = rowHeight;
		this.colWidth=colWidth;
		
		sprites = new BufferedImage[rows][cols];
		loadSprites();
		
	}
	
	
	public BufferedImage getSprite(int row,int col){
		return sprites[row-1][col-1];
	}
	
	private void loadSprites(){
		int rows2=0;
		int cols2;
		while(rows2<rows){
			cols2=0;
			while(cols2<cols){
				sprites[rows2][cols2] = getSubImage(rows2+1, cols2+1);
				cols2++;
			}
			
			rows2++;
		}
		
		
	}
	
	private BufferedImage getSubImage(int row, int col){
		
		BufferedImage img = image.getSubimage((col-1) *(colWidth) , ((row-1) * rowHeight), colWidth, rowHeight);
		return img; 
	}
	
	
	@SuppressWarnings("unused")
	private BufferedImage getSubImage(int row, int col,int xCrop, int yCrop){
	
		BufferedImage img = image.getSubimage((col-1) *(colWidth) , ((row-1) * rowHeight), colWidth-xCrop, rowHeight-yCrop);
		return img; 
}

}