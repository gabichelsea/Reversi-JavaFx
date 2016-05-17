package hu.unideb.inf.reversi.service.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import hu.unideb.inf.reversi.service.test.interfaces.PlayerResultServiceTest;
import hu.unideb.inf.reversi.service.test.interfaces.PlayerServiceTest;
import hu.unideb.inf.reversi.service.test.interfaces.ReversiGameManagerImplTest;
import hu.unideb.inf.reversi.service.test.utility.PlayerResultVoComparatorTest;
import hu.unideb.inf.reversi.service.test.utility.TimerUtilityTest;

@RunWith(Suite.class)
@SuiteClasses({ PlayerServiceTest.class, PlayerResultServiceTest.class, ReversiGameManagerImplTest.class,
		PlayerResultVoComparatorTest.class, TimerUtilityTest.class })
public class AllTestSuite {

}
