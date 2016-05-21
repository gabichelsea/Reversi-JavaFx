package hu.unideb.inf.reversi.service.interfaces.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.reversi.service.board.ReversiGameBoard;
import hu.unideb.inf.reversi.service.container.TextContainer;
import hu.unideb.inf.reversi.service.enums.ActualPlayer;
import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.interfaces.CellApplyService;
import hu.unideb.inf.reversi.service.interfaces.ReversiGameManager;
import hu.unideb.inf.reversi.service.model.CellPosition;
import hu.unideb.inf.reversi.service.utility.TimerUtility;
import hu.unideb.inf.reversi.service.vo.PlayerVo;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

/**
 * A játék logikájának vezérlését végző osztály.
 */
public class ReversiGameManagerImpl implements ReversiGameManager {
	private static final Logger logger = LoggerFactory.getLogger(ReversiGameManagerImpl.class);

	private ReversiGameBoard gameBoard;
	private PlayerVo firstPlayer;
	private PlayerVo secondPlayer;
	private ActualPlayer actualPlayer = ActualPlayer.FIRST_PLAYER;
	private String status;

	/**
	 * Paraméter nélküli üres konstruktor.
	 */
	public ReversiGameManagerImpl() {
	}

	/**
	 * A függőségek kiemelésért felelős konstruktor.
	 * 
	 * @param firstPlayer
	 *            A beállítandó első játékos.
	 * @param secondPlayer
	 *            A beállítandó második játékos.
	 * @param gameBoard
	 *            A beállítandó játéktábla.
	 */
	public ReversiGameManagerImpl(PlayerVo firstPlayer, PlayerVo secondPlayer, ReversiGameBoard gameBoard) {
		logger.info(TextContainer.DEPENDENCIES_INIT_LOG);
		setUp(firstPlayer, secondPlayer, gameBoard);
	}

	private void setUp(PlayerVo firstPlayer, PlayerVo secondPlayer, ReversiGameBoard gameBoard) {
		this.firstPlayer = firstPlayer;
		this.secondPlayer = secondPlayer;
		this.gameBoard = gameBoard;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void newGame() {
		logger.info(TextContainer.NEW_GAME_LOG);
		gameBoard.fillAllGrid(CellType.EMPTY);
		gameBoard.setCell(new CellPosition(4, 4), CellType.RED);
		gameBoard.setCell(new CellPosition(4, 5), CellType.BLACK);
		gameBoard.setCell(new CellPosition(5, 4), CellType.BLACK);
		gameBoard.setCell(new CellPosition(5, 5), CellType.RED);

		updateStatus();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void nextTurn() {
		if (countRemainingValidCells(checkAnotherPlayer()) > 0) {
			actualPlayer = checkAnotherPlayer();
			logger.info(TextContainer.NEXT_TURN_LOG);
		}
		if (countRemainingValidCells(actualPlayer) == 0) {
			actualPlayer = ActualPlayer.NOBODY;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateStatus() {
		String firstPlayerName = firstPlayer.getUserName();
		String secondPlayerName = secondPlayer.getUserName();
		firstPlayer.setScore(countPieces(ActualPlayer.FIRST_PLAYER));
		secondPlayer.setScore(countPieces(ActualPlayer.SECOND_PLAYER));
		status = firstPlayerName + ": " + firstPlayer.getScore() + "\t" + secondPlayerName + ": "
				+ secondPlayer.getScore() + "\n";

		status += getPlayerName(actualPlayer) + TextContainer.NEXT;
		
		updateGameOverStatus();
		logger.info(TextContainer.GAME_STATUS_UPDATE_LOG);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void updateGameOverStatus() {
		if (actualPlayer.equals(ActualPlayer.NOBODY)) {
			if (firstPlayer.getScore() > secondPlayer.getScore()) {
				status = firstPlayer.getUserName() + TextContainer.WON;
			} else if (secondPlayer.getScore() > firstPlayer.getScore()) {
				status = secondPlayer.getUserName() + TextContainer.WON;
			} else {
				status = TextContainer.DRAW;
			}
			status += "\n" + firstPlayer.getUserName() + ": " + firstPlayer.getScore();
			status += "\t" + secondPlayer.getUserName() + ": " + secondPlayer.getScore();
			logger.info(TextContainer.GAME_OVER_STATUS_LOG);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer countPieces(ActualPlayer actualPlayer) {
		logger.info(TextContainer.COUNT_PIECES_LOG);
		CellType cellType = getCellTypeByPlayer(actualPlayer);
		return countCellsIf((cellPosition) -> cellType.equals(gameBoard.getCellByPosition(cellPosition)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer countRemainingValidCells(ActualPlayer actualPlayer) {
		logger.info(TextContainer.REMAINING_VALID_CELLS_LOG);
		return countCellsIf((cellPosition) -> turnPieces(actualPlayer, cellPosition, false) > 0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ActualPlayer getActualPlayer() {
		return actualPlayer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		Node child = mouseEvent.getPickResult().getIntersectedNode();
		gameBoard.applyCell((cellPosition) -> mouseClicked(cellPosition.getRowIndex(), cellPosition.getColumnIndex()),
				child);
		logger.info(TextContainer.MOUSE_CLICKED_LOG);
	}
	
	/**
	 * A kattintás sikeres volt-e játék logika és cella pozíció alapján.
	 * 
	 * @param x
	 *            A cella sora.
	 * @param y
	 *            A cella oszlopa.
	 * @return Érvényes kattintás volt-e.
	 */
	public Boolean mouseClicked(Integer x, Integer y) {
		CellPosition cellPosition = new CellPosition(x, y);
		if (!gameBoard.isValidCellPosition(cellPosition) || actualPlayer.equals(ActualPlayer.NOBODY)) {
			logger.info(TextContainer.NON_VALID_MOUSE_CLICKED);
			return false;
			
		}

		Integer count = turnPieces(actualPlayer, cellPosition, false);
		if (count > 0) {
			logger.info(TextContainer.VALID_MOUSE_CLICKED);
			gameBoard.setCell(cellPosition, getCellTypeByPlayer(actualPlayer));

			TimerUtility.runDelayed(250, () -> {
				turnPieces(actualPlayer, cellPosition, true);
				nextTurn();
				updateStatus();
			});
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getStatus() {
		return status;
	}

	/**
	 * Visszaadja az ellenfél játékost ha nincs játék vége.
	 * @return Az aktuális játékos.
	 */
	public ActualPlayer checkAnotherPlayer() {
		if (actualPlayer.equals(ActualPlayer.FIRST_PLAYER)) {
			return ActualPlayer.SECOND_PLAYER;
		} else if (actualPlayer.equals(ActualPlayer.SECOND_PLAYER)) {
			return ActualPlayer.FIRST_PLAYER;
		} else {
			return ActualPlayer.NOBODY;
		}
	}

	/**
	 * Visszaadja az aktuális játékos nevét.
	 * 
	 * @param player
	 *            Az aktuális játékos.
	 * @return Az aktuális játékos neve.
	 */
	public String getPlayerName(ActualPlayer player) {
		if (player.equals(ActualPlayer.FIRST_PLAYER)) {
			return firstPlayer.getUserName();
		} else if (player.equals(ActualPlayer.SECOND_PLAYER)) {
			return secondPlayer.getUserName();
		} else {
			return null;
		}
	}

	/**
	 * Visszaadja a cella típusát az aktuális játékos által.
	 * 
	 * @param actualPlayer
	 *            Az aktuális játékos.
	 * @return A cella, amely az aktuális játékoshoz tartozik.
	 */
	public CellType getCellTypeByPlayer(ActualPlayer actualPlayer) {
		if (actualPlayer.equals(ActualPlayer.FIRST_PLAYER)) {
			return CellType.RED;
		} else if (actualPlayer.equals(ActualPlayer.SECOND_PLAYER)) {
			return CellType.BLACK;
		} else {
			return CellType.EMPTY;
		}
	}

	private Integer turnPieces(ActualPlayer actualPlayer, CellPosition cellPosition, Boolean reallyTurn) {
		Integer count = 0, x = cellPosition.getRowIndex(), y = cellPosition.getColumnIndex();
		if (gameBoard.getCellByPosition(new CellPosition(x, y)).equals(CellType.EMPTY) || reallyTurn) {
			for (int dx = -1; dx <= 1; ++dx) {
				for (int dy = -1; dy <= 1; ++dy) {
					if (dx != 0 || dy != 0) {
						count += turnPieces(actualPlayer, new CellPosition(x + dx, y + dy), dx, dy, reallyTurn);
					}
				}
			}
		}
		return count;
	}

	private Integer turnPieces(ActualPlayer actualPlayer, CellPosition cellPosition, Integer dx, Integer dy,
			Boolean reallyTurn) {
		Integer count = 0;
		Integer x = cellPosition.getRowIndex(), y = cellPosition.getColumnIndex();
		while (gameBoard.isValidCellPosition(new CellPosition(x + count * dx, y + count * dy))) {
			CellType cellType = gameBoard.getCellByPosition(new CellPosition(x + count * dx, y + count * dy));
			if (cellType.equals(CellType.EMPTY)) {
				return 0;
			} else if (cellType.equals(getCellTypeByPlayer(actualPlayer))) {
				if (reallyTurn) {
					for (int i = 0; i < count; i++) {
						gameBoard.setCell(new CellPosition(x + i * dx, y + i * dy), getCellTypeByPlayer(actualPlayer));
					}
				}
				return count;
			}
			count++;
		}
		return 0;
	}

	private Integer countCells(CellApplyService<Integer> cellApplyService) {
		Integer startX = 0, startY = 0, sum = 0;
		for (int x = startX; x < gameBoard.getColumns(); ++x) {
			for (int y = startY; y < gameBoard.getRows(); ++y) {
				sum += cellApplyService.applyCell(new CellPosition(x, y));
			}
		}
		return sum;
	}

	private Integer countCellsIf(CellApplyService<Boolean> cellApplyService) {
		return countCells((cellPosition) -> cellApplyService.applyCell(cellPosition) ? 1 : 0);
	}

	

	/**
	 * Visszaadja az első játékost.
	 * @return Az első játékos.
	 */
	public PlayerVo getFirstPlayer() {
		return firstPlayer;
	}

	/**
	 * Visszaadja a második játékost.
	 * @return A második játékos.
	 */
	public PlayerVo getSecondPlayer() {
		return secondPlayer;
	}

	/**
	 * Visszaadjuk a játéktáblát.
	 * @return A játéktábla.
	 */
	public ReversiGameBoard getGameBoard() {
		return gameBoard;
	}

	/**
	 * Az aktuális játékos beállítása.
	 * @param actualPlayer A beállítandó aktuális játékos.
	 */
	public void setActualPlayer(ActualPlayer actualPlayer) {
		this.actualPlayer = actualPlayer;
	}

}
