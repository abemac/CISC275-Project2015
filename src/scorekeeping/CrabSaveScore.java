package scorekeeping;

public class CrabSaveScore extends GameScore {
	
	private int getNumTrash;
	private double time;
	public CrabSaveScore(int getNumTrash, double time){
		this.getNumTrash = getNumTrash;
		this.time = time;
	}
	
	public int getCalculatedScore(){
		int trashScore = 0;
		int timeScore=0;
		trashScore = getNumTrash*12;
		if(time <= 60){
			timeScore = 28;
		}
		else if(time > 60 && time <= 80){
			timeScore = 21;
		}
		else if(time > 80 && time <= 100){
			timeScore = 14;
		}
		else{
			timeScore = 7;
		}
		return timeScore+trashScore;
	}
}
