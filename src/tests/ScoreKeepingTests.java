package tests;

import scorekeeping.CrabSaveScore;
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
	
}
