package hu.unideb.inf.reversi.service.test;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.service.interfaces.PlayerResultService;
import hu.unideb.inf.reversi.service.interfaces.PlayerService;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;
import hu.unideb.inf.reversi.service.vo.PlayerVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-service.xml")
@Transactional(propagation = Propagation.REQUIRED)
@Rollback(true)
public class PlayerResultServiceTest {
	private static final Logger logger = LogManager.getLogger(PlayerResultServiceTest.class);

	@Autowired
	private PlayerService playerService;
	@Autowired
	private PlayerResultService playerResultService;

	@Before
	public void setUp() {
		PlayerResultVo playerResultVo = new PlayerResultVo();
		PlayerVo playerVo = new PlayerVo();
		playerVo.setUserName("userName");
		playerVo.setPassword("password");

		playerResultVo.setPlayer(playerVo);
		playerResultVo.setNumberOfMatches(0);
		playerResultVo.setWin(0);
		playerResultVo.setDraw(0);
		playerResultVo.setLose(0);
		playerResultVo.setWonPieces(0);
		playerResultVo.setLostPieces(0);

		try {
			playerResultService.add(playerResultVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Test(expected = Exception.class)
	public void addTestWithFail() throws Exception {
		PlayerResultVo playerResultVo = new PlayerResultVo();
		playerResultVo.setPlayer(null);
		playerResultService.add(playerResultVo);
	}

	@Test
	public void getAllTest() {
		try {
			Integer previousListSize = playerResultService.getAll().size();

			PlayerVo playerVo = new PlayerVo();
			playerVo.setUserName("userName2");
			playerVo.setPassword("password");

			PlayerResultVo playerResultVo = new PlayerResultVo();
			playerResultVo.setPlayer(playerVo);
			playerResultService.add(playerResultVo);

			Integer actualListSize = playerResultService.getAll().size();
			Assert.assertEquals(actualListSize.intValue(), previousListSize.intValue() + 1);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			Assert.fail();
		}
	}

	@Test
	public void getByPlayerIdTest() {
		PlayerVo playerVo;
		try {
			playerVo = playerService.getByUserName("userName");
			PlayerResultVo playerResultVo = playerResultService.getByPlayerId(playerVo.getId());
			System.out.println(playerResultVo.getPlayer().getUserName());
			Assert.assertEquals(0, playerResultVo.getNumberOfMatches().intValue());
			Assert.assertEquals(0, playerResultVo.getWin().intValue());
			Assert.assertEquals(0, playerResultVo.getDraw().intValue());
			Assert.assertEquals(0, playerResultVo.getLose().intValue());
			Assert.assertEquals(0, playerResultVo.getWonPieces().intValue());
			Assert.assertEquals(0, playerResultVo.getLostPieces().intValue());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			Assert.fail();
		}
	}

	@Test
	public void removeByPlayerIdTest() {
		try {
			playerResultService.removeByPlayerId(playerService.getByUserName("userName").getId());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}


}
