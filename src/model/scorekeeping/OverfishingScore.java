package model.scorekeeping;

public class OverfishingScore extends GameScore{
	
	private int distance;
	private int numFishLeft;
	public OverfishingScore(int distance,int numFishLeft){
		this.distance=distance;
		this.numFishLeft=numFishLeft;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public int getnumFishLeft(){
		return numFishLeft;
	}
	public int getCalculatedScore(){
		int distanceScore=0;
		int fishScore=0;
		if(distance >= 0 && distance <= 50){
			distanceScore = 5;
		}
		else if(distance >= 51 && distance <= 100){
			distanceScore = 10;
		}
		else if(distance >= 101 && distance <= 150){
			distanceScore = 15;
		}
		else if(distance >= 151 && distance <= 200){
			distanceScore = 20;
		}
		else{
			distanceScore = 25;
		}
		if(distance>=240){
			distanceScore=25;
		}
		fishScore = numFishLeft*5;
		return distanceScore+fishScore;
	}
	
}
