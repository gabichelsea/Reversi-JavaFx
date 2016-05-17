package hu.unideb.inf.reversi.service.test.utility;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.unideb.inf.reversi.service.utility.PlayerResultVoComparator;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

public class PlayerResultVoComparatorTest {
	
	private PlayerResultVo firstPlayerResultVo;
	private PlayerResultVo secondPlayerResultVo;
	
	@Before
	public void setUp() {
		firstPlayerResultVo = new PlayerResultVo();
		firstPlayerResultVo.setWin(1);
		firstPlayerResultVo.setDraw(1);
		firstPlayerResultVo.setLose(1);
		firstPlayerResultVo.setWonPieces(10);
		firstPlayerResultVo.setLostPieces(1);
		
		secondPlayerResultVo = new PlayerResultVo();
		secondPlayerResultVo.setWin(1);
		secondPlayerResultVo.setDraw(1);
		secondPlayerResultVo.setLose(1);
		secondPlayerResultVo.setWonPieces(1);
		secondPlayerResultVo.setLostPieces(1);
	}
	
	@Test
	public void compareTest() {
		PlayerResultVoComparator playerResultVoComparator = new PlayerResultVoComparator();
		
		firstPlayerResultVo.setWonPieces(5);
		Integer value = playerResultVoComparator.compare(firstPlayerResultVo, secondPlayerResultVo);
		Assert.assertEquals(1, value.intValue());
		
		firstPlayerResultVo.setWin(2);
		value = playerResultVoComparator.compare(firstPlayerResultVo, secondPlayerResultVo);
		Assert.assertEquals(1, value.intValue());
		
	}
}
