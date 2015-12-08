package ALLTESTS;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import model.characters.CharacterTests;
import model.enemies.EnemyTests;
import model.games.GameTests;
import model.misc.MiscTests;
import model.scorekeeping.ScoreKeepingTests;

@RunWith(Suite.class)
@SuiteClasses({ CharacterTests.class, EnemyTests.class, GameTests.class, MiscTests.class, ScoreKeepingTests.class })
public class ModelOnlyTests {

}
