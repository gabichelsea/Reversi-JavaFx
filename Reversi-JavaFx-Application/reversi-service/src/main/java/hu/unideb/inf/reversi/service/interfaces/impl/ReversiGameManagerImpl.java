package hu.unideb.inf.reversi.service.interfaces.impl;

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

public class ReversiGameManagerImpl implements ReversiGameManager {

	private ReversiGameBoard gameBoard;
	private PlayerVo firstPlayer;
	private PlayerVo secondPlayer;
	private ActualPlayer actualPlayer = ActualPlayer.FIRST_PLAYER;
	private String status;

	public ReversiGameManagerImpl() {
	}

	public ReversiGameManagerImpl(PlayerVo firstPlayer, PlayerVo secondPlayer, ReversiGameBoard gameBoard) {
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
	public void updateStatus() {
		String firstPlayerName = firstPlayer.getUserName();
		String secondPlayerName = secondPlayer.getUserName();
		firstPlayer.setScore(countPieces(ActualPlayer.FIRST_PLAYER));
		secondPlayer.setScore(countPieces(ActualPlayer.SECOND_PLAYER));
		status = firstPlayerName + ": " + firstPlayer.getScore() + "\t" + secondPlayerName + ": "
				+ secondPlayer.getScore() + "\n";

		status += getPlayerName(actualPlayer) + TextContainer.NEXT + "\n";
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
		}
	}

	public ActualPlayer checkAnotherPlayer() {
		if (actualPlayer.equals(ActualPlayer.FIRST_PLAYER)) {
			return ActualPlayer.SECOND_PLAYER;
		} else if (actualPlayer.equals(ActualPlayer.SECOND_PLAYER)) {
			return ActualPlayer.FIRST_PLAYER;
		} else {
			return ActualPlayer.NOBODY;
		}
	}

	public String getPlayerName(ActualPlayer player) {
		if (player.equals(ActualPlayer.FIRST_PLAYER)) {
			return firstPlayer.getUserName();
		} else if (player.equals(ActualPlayer.SECOND_PLAYER)) {
			return secondPlayer.getUserName();
		} else {
			return null;
		}
	}

	public CellType getCellTypeByPlayer(ActualPlayer actualPlayer) {
		if (actualPlayer.equals(ActualPlayer.FIRST_PLAYER)) {
			return CellType.RED;
		} else if (actualPlayer.equals(ActualPlayer.SECOND_PLAYER)) {
			return CellType.BLACK;
		} else {
			return CellType.EMPTY;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer countPieces(ActualPlayer actualPlayer) {
		CellType cellType = getCellTypeByPlayer(actualPlayer);
		return countCellsIf((cellPosition) -> cellType.equals(gameBoard.getCellByPosition(cellPosition)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer countRemainingValidCells(ActualPlayer actualPlayer) {
		return countCellsIf((cellPosition) -> turnPieces(actualPlayer, cellPosition, false) > 0);
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void mouseClicked(MouseEvent mouseEvent) {
		Node child = mouseEvent.getPickResult().getIntersectedNode();
		gameBoard.applyCell((cellPosition) -> mouseClicked(cellPosition.getRowIndex(), cellPosition.getColumnIndex()),
				child);
	}

	public Boolean mouseClicked(Integer x, Integer y) {
		CellPosition cellPosition = new CellPosition(x, y);
		if (!gameBoard.isValidCellPosition(cellPosition) || actualPlayer.equals(ActualPlayer.NOBODY)) {
			return false;
		}

		Integer count = turnPieces(actualPlayer, cellPosition, false);
		if (count > 0) {
			gameBoard.setCell(cellPosition, getCellTypeByPlayer(actualPlayer));
			
			TimerUtility.runDelayed(250, () -> {
				turnPieces(actualPlayer, cellPosition, true);
				nextTurn();
				updateStatus();
				updateGameOverStatus();
			});
		}
		return true;
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
	 * {@inheritDoc}
	 */
	public ActualPlayer getActualPlayer() {
		return actualPlayer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getStatus() {
		return status;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void nextTurn() {
		if (countRemainingValidCells(checkAnotherPlayer()) > 0) {
			actualPlayer = checkAnotherPlayer();
		}
		if (countRemainingValidCells(actualPlayer) == 0) {
			actualPlayer = ActualPlayer.NOBODY;
		}
	}

	public PlayerVo getFirstPlayer() {
		return firstPlayer;
	}

	public PlayerVo getSecondPlayer() {
		return secondPlayer;
	}

	public ReversiGameBoard getGameBoard() {
		return gameBoard;
	}

	public void setActualPlayer(ActualPlayer actualPlayer) {
		this.actualPlayer = actualPlayer;
	}

}
