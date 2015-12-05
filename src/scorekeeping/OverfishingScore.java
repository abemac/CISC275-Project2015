package scorekeeping;

public class OverfishingScore extends GameScore{
	
	private int distance;
	private int numFishLeft;
	public OverfishingScore(int distance,int numFishLeft){
		this.distance=distance;
		this.numFishLeft=numFishLeft;
	}
	
	public int getCalculatedScore(){
		int distanceScore=0;
		int fishScore=0;
		if(distance>=240){
			distanceScore=25;
		}
		fishScore = numFishLeft*5;
		return distanceScore+fishScore;
	}
	
}

