package tests;

import scorekeeping.CrabSaveScore;
import scorekeeping.OverfishingScore;
import scorekeeping.PollutionScore;
import junit.framework.TestCase;

public class ScoreKeepingTests extends TestCase{
	
	public void testCrabSaveScore(){
		CrabSaveScore crabSaveScore = new CrabSaveScore(0, 36.6);
		assertEquals(crabSaveScore.getTrashNum(), 0);
		assertEquals(crabSaveScore.getCalculatedScore(),100);
		CrabSaveScore crabSaveScore1 = new CrabSaveScore(1, 24.4);
		assertEquals(crabSaveScore1.getTrashNum(), 1);
		assertEquals(crabSaveScore1.getTime(), 24.4);
		assertEquals(crabSaveScore1.getCalculatedScore(),79);
	}
	
	public void testOverfishingScore(){
		OverfishingScore overfishingScore = new OverfishingScore(240, 15);
		assertEquals(overfishingScore.getCalculatedScore(), 100);
		OverfishingScore overfishingScore1 = new OverfishingScore(55, 0);
		assertEquals(overfishingScore1.getCalculatedScore(), 10);
		OverfishingScore overfishingScore2 = new OverfishingScore(25, 10);
		assertEquals(overfishingScore2.getCalculatedScore(), 55);
		OverfishingScore overfishingScore3 = new OverfishingScore(125, 10);
		assertEquals(overfishingScore3.getCalculatedScore(), 65);
		OverfishingScore overfishingScore03 = new OverfishingScore(152, 10);
		assertEquals(overfishingScore03.getCalculatedScore(), 70);
		OverfishingScore overfishingScore4 = new OverfishingScore(260, 15);
		assertTrue(overfishingScore4.getDistance()==260);
		assertTrue(overfishingScore4.getnumFishLeft()==15);
		assertTrue(overfishingScore4.getCalculatedScore()==100);
	}
	
	public void testPollutionScore(){
		PollutionScore pollutionScore = new PollutionScore(1);
		PollutionScore pollutionScore0 = new PollutionScore(9);
		PollutionScore pollutionScore1 = new PollutionScore(18);
		PollutionScore pollutionScore2 = new PollutionScore(27);
		PollutionScore pollutionScore3 = new PollutionScore(36);
		PollutionScore pollutionScore4 = new PollutionScore(45);
		PollutionScore pollutionScore5 = new PollutionScore(54);
		PollutionScore pollutionScore6 = new PollutionScore(63);
		PollutionScore pollutionScore7 = new PollutionScore(72);
		PollutionScore pollutionScore8 = new PollutionScore(81);
		assertEquals(pollutionScore.getCalculatedScore(), 10);
		assertEquals(pollutionScore0.getCalculatedScore(), 20);
		assertEquals(pollutionScore1.getCalculatedScore(), 30);
		assertEquals(pollutionScore2.getCalculatedScore(), 40);
		assertEquals(pollutionScore3.getCalculatedScore(), 50);
		assertEquals(pollutionScore4.getCalculatedScore(), 60);
		assertEquals(pollutionScore5.getCalculatedScore(), 70);
		assertEquals(pollutionScore6.getCalculatedScore(), 80);
		assertEquals(pollutionScore7.getCalculatedScore(), 90);
		assertEquals(pollutionScore8.getCalculatedScore(), 100);
	}
	
	
}
