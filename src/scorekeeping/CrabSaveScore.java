package scorekeeping;

public class CrabSaveScore extends GameScore {
	
	private int getNumTrash;
	private double time;
	public CrabSaveScore(int getNumTrash, double time){
		this.getNumTrash = getNumTrash;
		this.time = time;
	}
	public int getTrashNum(){
		return getNumTrash;
	}
	
	public double getTime(){
		return time;
	}
	public int getCalculatedScore(){
		int trashScore = 0;
		int timeScore=0;
		//double time = 60-time;
		trashScore = ((6-getNumTrash)*11);
		if(time >= 34){
			timeScore = 34;
		}
		else{
			timeScore = (int) time;
		}
		return timeScore+trashScore;
	}
	
	
	
}
