package hu.unideb.inf.reversi.service.test.utility;

import org.junit.Test;

import hu.unideb.inf.reversi.service.utility.TimerUtility;

public class TimerUtilityTest {

	@Test(timeout = 2000)
	public void runDelayTest() {
		TimerUtility.runDelayed(500);
	}

}
