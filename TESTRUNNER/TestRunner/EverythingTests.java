package TestRunner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import animation.AnimationTests;
import characters.CharacterTests;
import enemies.EnemyTests;
import games.GameTests;
import misc.MiscTests;
import scorekeeping.ScoreKeepingTests;

@RunWith(Suite.class)
@SuiteClasses({ CharacterTests.class, EnemyTests.class, GameTests.class, MiscTests.class, ScoreKeepingTests.class,AnimationTests.class })
public class EverythingTests {
	
}
