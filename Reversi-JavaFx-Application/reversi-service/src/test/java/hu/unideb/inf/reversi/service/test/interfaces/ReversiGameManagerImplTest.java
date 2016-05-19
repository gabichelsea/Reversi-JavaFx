package hu.unideb.inf.reversi.service.test.interfaces;

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
	private static final String FIRST_PLAYER_NAME = "firstPlayer";
	private static final String SECOND_PLAYER_NAME = "secondPlayer";

	@Before
	public void setUp() {
		PlayerVo firstPlayer = new PlayerVo();
		firstPlayer.setUserName(FIRST_PLAYER_NAME);
		firstPlayer.setScore(3);

		PlayerVo secondPlayer = new PlayerVo();
		secondPlayer.setUserName(SECOND_PLAYER_NAME);
		secondPlayer.setScore(3);

		ReversiGameBoard gameBoard = new ReversiGameBoard();
		gameBoard.setRows(10);
		gameBoard.setColumns(10);
		gameManager = new ReversiGameManagerImpl(firstPlayer, secondPlayer, gameBoard);
		gameManager.setActualPlayer(ActualPlayer.FIRST_PLAYER);
		gameManager.newGame();
	}

	@Test
	public void newGameTest() {
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
	
	@Test
	public void mouseClickedTest() {
		Boolean isWrongClick = gameManager.mouseClicked(-1, -1);
		Assert.assertFalse(isWrongClick);
		
		gameManager.setActualPlayer(ActualPlayer.NOBODY);
		Boolean isGameOver = gameManager.mouseClicked(1, 1);
		Assert.assertFalse(isGameOver);
		
		gameManager.setActualPlayer(ActualPlayer.FIRST_PLAYER);
		Boolean isSucces = gameManager.mouseClicked(4, 6);
		Assert.assertTrue(isSucces);
	}
	
	@Test
	public void getPlayerNameTest() {
		Assert.assertEquals(FIRST_PLAYER_NAME, gameManager.getPlayerName(ActualPlayer.FIRST_PLAYER));
		Assert.assertEquals(SECOND_PLAYER_NAME, gameManager.getPlayerName(ActualPlayer.SECOND_PLAYER));
		Assert.assertEquals(null, gameManager.getPlayerName(ActualPlayer.NOBODY));
	}
	
	@Test
	public void getCellTypeByPlayer() {
		Assert.assertEquals(CellType.RED, gameManager.getCellTypeByPlayer(ActualPlayer.FIRST_PLAYER));
		Assert.assertEquals(CellType.BLACK, gameManager.getCellTypeByPlayer(ActualPlayer.SECOND_PLAYER));
		Assert.assertEquals(CellType.EMPTY, gameManager.getCellTypeByPlayer(ActualPlayer.NOBODY));
	}
}
