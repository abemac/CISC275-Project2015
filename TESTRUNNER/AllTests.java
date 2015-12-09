import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({characters.CharacterTests.class,enemies.EnemyTests.class,games.GameTests.class,
	misc.MiscTests.class,scorekeeping.ScoreKeepingTests.class,animation.AnimationTests.class})
public class AllTests {

}
