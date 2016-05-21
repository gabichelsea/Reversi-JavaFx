package hu.unideb.inf.reversi.service.test.interfaces;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.service.interfaces.PlayerService;
import hu.unideb.inf.reversi.service.vo.PlayerVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-service.xml")
@Transactional(propagation = Propagation.REQUIRED)
@Rollback(true)
public class PlayerServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(PlayerServiceTest.class);

	@Autowired
	private PlayerService playerService;

	@Before
	public void setUp() {
		PlayerVo playerVo = new PlayerVo();
		playerVo.setUserName("userName");
		playerVo.setPassword("password");
		try {
			playerService.add(playerVo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	@Test(expected = Exception.class)
	public void addTestWithFail() throws Exception {
		PlayerVo playerVo = new PlayerVo();
		playerVo.setUserName("userName");
		playerVo.setPassword("password");
		playerService.add(playerVo);
	}

	@Test
	public void getByUserNameTest() {
		try {
			PlayerVo playerVo = playerService.getByUserName("userName");
			Assert.assertEquals("userName", playerVo.getUserName());
			Assert.assertEquals("password", playerVo.getPassword());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			Assert.fail();
		}
	}

}
