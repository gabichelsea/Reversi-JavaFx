package hu.unideb.inf.reversi.service.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.unideb.inf.reversi.service.board.ReversiGameBoard;
import hu.unideb.inf.reversi.service.container.TextContainer;
import hu.unideb.inf.reversi.service.enums.ActualPlayer;
import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.interfaces.impl.ReversiGameManagerImpl;
import hu.unideb.inf.reversi.service.model.CellPosition;
import hu.unideb.inf.reversi.service.vo.PlayerVo;

public class ReversiGameManagerImplTest {
	private ReversiGameManagerImpl gameManager;

	@Before
	public void setUp() {
		PlayerVo firstPlayer = new PlayerVo();
		firstPlayer.setUserName("firstPlayer");
		firstPlayer.setScore(3);

		PlayerVo secondPlayer = new PlayerVo();
		secondPlayer.setUserName("secondPlayer");
		secondPlayer.setScore(3);

		ReversiGameBoard gameBoard = new ReversiGameBoard();
		gameBoard.setRows(10);
		gameBoard.setColumns(10);
		gameManager = new ReversiGameManagerImpl(firstPlayer, secondPlayer, gameBoard);
	}

	@Test
	public void newGameTest() {
		gameManager.newGame();
		Assert.assertEquals(CellType.RED, gameManager.getGameBoard().getCellByPosition(new CellPosition(4, 4)));
		Assert.assertEquals(CellType.RED, gameManager.getGameBoard().getCellByPosition(new CellPosition(5, 5)));
		Assert.assertEquals(CellType.BLACK, gameManager.getGameBoard().getCellByPosition(new CellPosition(4, 5)));
		Assert.assertEquals(CellType.BLACK, gameManager.getGameBoard().getCellByPosition(new CellPosition(5, 4)));
		Assert.assertEquals(CellType.EMPTY, gameManager.getGameBoard().getCellByPosition(new CellPosition(1, 0)));
		Assert.assertEquals(CellType.EMPTY, gameManager.getGameBoard().getCellByPosition(new CellPosition(9, 9)));
	}

	@Test
	public void checkAnotherPlayerTest() {
		gameManager.setActualPlayer(ActualPlayer.FIRST_PLAYER);
		Assert.assertEquals(ActualPlayer.SECOND_PLAYER, gameManager.checkAnotherPlayer());
		gameManager.setActualPlayer(ActualPlayer.SECOND_PLAYER);
		Assert.assertEquals(ActualPlayer.FIRST_PLAYER, gameManager.checkAnotherPlayer());
		gameManager.setActualPlayer(ActualPlayer.NOBODY);
		Assert.assertEquals(ActualPlayer.NOBODY, gameManager.checkAnotherPlayer());
	}

	@Test
	public void nextTurnTest() {
		gameManager.newGame();

		gameManager.setActualPlayer(ActualPlayer.FIRST_PLAYER);
		gameManager.nextTurn();
		Assert.assertEquals(ActualPlayer.SECOND_PLAYER, gameManager.getActualPlayer());

		gameManager.setActualPlayer(ActualPlayer.SECOND_PLAYER);
		gameManager.nextTurn();
		Assert.assertEquals(ActualPlayer.FIRST_PLAYER, gameManager.getActualPlayer());

		gameManager.getGameBoard().setCell(new CellPosition(4, 4), CellType.EMPTY);
		gameManager.getGameBoard().setCell(new CellPosition(4, 5), CellType.EMPTY);
		gameManager.getGameBoard().setCell(new CellPosition(5, 4), CellType.EMPTY);
		gameManager.getGameBoard().setCell(new CellPosition(5, 5), CellType.EMPTY);

		gameManager.setActualPlayer(ActualPlayer.FIRST_PLAYER);
		gameManager.nextTurn();
		Assert.assertEquals(ActualPlayer.NOBODY, gameManager.getActualPlayer());

		gameManager.setActualPlayer(ActualPlayer.SECOND_PLAYER);
		gameManager.nextTurn();
		Assert.assertEquals(ActualPlayer.NOBODY, gameManager.getActualPlayer());

	}

	@Test
	public void updateGameOverStatusTest() {
		gameManager.setActualPlayer(ActualPlayer.NOBODY);
		gameManager.getFirstPlayer().setScore(3);
		gameManager.getSecondPlayer().setScore(2);
		gameManager.updateGameOverStatus();

		Assert.assertEquals("firstPlayer" + TextContainer.WON + "\nfirstPlayer: 3\t" + "secondPlayer: 2",
				gameManager.getStatus());

		gameManager.getFirstPlayer().setScore(2);
		gameManager.getSecondPlayer().setScore(3);
		gameManager.updateGameOverStatus();
		Assert.assertEquals("secondPlayer" + TextContainer.WON + "\nfirstPlayer: 2\t" + "secondPlayer: 3",
				gameManager.getStatus());

		gameManager.getFirstPlayer().setScore(3);
		gameManager.getSecondPlayer().setScore(3);
		gameManager.updateGameOverStatus();
		Assert.assertEquals(TextContainer.DRAW + "\nfirstPlayer: 3\t" + "secondPlayer: 3", gameManager.getStatus());
	}

}
