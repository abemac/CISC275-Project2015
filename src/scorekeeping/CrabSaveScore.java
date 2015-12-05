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
		double timeLeft = 60-time;
		trashScore = ((6-getNumTrash)*12);
		if(timeLeft >= 32){
			timeScore = 28;
		}
		else{
			timeScore = (int) timeLeft;
		}
		return timeScore+trashScore;
	}
	
	
	
}
