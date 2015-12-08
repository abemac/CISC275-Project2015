package tests;

import scorekeeping.CrabSaveScore;
import scorekeeping.OverfishingScore;
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
		OverfishingScore overfishingScore2 = new OverfishingScore(240, 10);
		assertEquals(overfishingScore2.getCalculatedScore(), 75);
		OverfishingScore overfishingScore3 = new OverfishingScore(240, 10);
		assertEquals(overfishingScore3.getCalculatedScore(), 75);
		OverfishingScore overfishingScore4 = new OverfishingScore(260, 15);
		assertTrue(overfishingScore4.getDistance()==260);
		assertTrue(overfishingScore4.getnumFishLeft()==15);
		assertTrue(overfishingScore4.getCalculatedScore()==100);
	}
	
	
}
