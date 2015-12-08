package model.scorekeeping;

public class ScoreKeeper {
	
	private OverfishingScore overfishingScore;
	private PollutionScore pollutionScore;
	private CrabSaveScore crabSaveScore;
	
	public boolean hasOverfishingScore(){
		return overfishingScore!=null;
	}
	
	public boolean hasPollutionScore(){
		return pollutionScore!=null;
	}
	public boolean hasCrabSaveScore(){
		return crabSaveScore!=null;
	}
	
	public void addOverfishingScore(OverfishingScore score){
		this.overfishingScore = score;
	}
	
	public OverfishingScore getOverfishingScore() {
		return overfishingScore;
	}
	
	public void addPollutionScore(PollutionScore pollutionScore){
		this.pollutionScore = pollutionScore;
	}
	
	public PollutionScore getPollutionScore(){
		return pollutionScore;
	}
	
	public void addCrabSaveScore(CrabSaveScore crabSaveScore){
		this.crabSaveScore = crabSaveScore;
	}
	
	public CrabSaveScore getCrabSaveScore(){
		return crabSaveScore;
	}
}
