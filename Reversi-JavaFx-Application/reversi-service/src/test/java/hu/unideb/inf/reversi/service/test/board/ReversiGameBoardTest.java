package hu.unideb.inf.reversi.service.test.board;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.unideb.inf.reversi.service.board.ReversiGameBoard;
import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.model.CellPosition;

public class ReversiGameBoardTest {
	ReversiGameBoard gameBoard;

	@Before
	public void setUp() {
		gameBoard = new ReversiGameBoard();
		gameBoard.setRows(10);
		gameBoard.setColumns(10);

		CellPosition cellPosition = new CellPosition();
		cellPosition.setRowIndex(10);
		cellPosition.setColumnIndex(10);

		gameBoard.setCell(cellPosition, CellType.EMPTY);
	}

	@Test
	public void getCellByPositionNullTest() {
		CellPosition invalidCellPosition = new CellPosition(-1, -1);
		Assert.assertTrue(gameBoard.getCellByPosition(invalidCellPosition) == null);
	}

	@Test
	public void applyCellNullTest() {
		Assert.assertTrue(gameBoard.applyCell((cellPosition) -> new CellPosition(5, 5), null) == null);
	}

}