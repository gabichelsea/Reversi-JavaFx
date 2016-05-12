package hu.unideb.inf.reversi.service.interfaces.impl;

import org.springframework.stereotype.Service;

import hu.unideb.inf.reversi.service.board.ReversiGameBoard;
import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.interfaces.ReversiGameManager;
import hu.unideb.inf.reversi.service.model.CellPosition;

@Service
public class ReversiGameManagerImpl implements ReversiGameManager {
	
	private ReversiGameBoard gameBoard;

	public ReversiGameManagerImpl() {
	}

	public ReversiGameManagerImpl(ReversiGameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	@Override
	public void newGame() {
		gameBoard.fillAllGrid(CellType.EMPTY);
		gameBoard.setCell(new CellPosition(3, 3), CellType.RED);
		gameBoard.setCell(new CellPosition(3, 4), CellType.BLACK);
		gameBoard.setCell(new CellPosition(4, 3), CellType.BLACK);
		gameBoard.setCell(new CellPosition(4, 4), CellType.RED);
	}

	@Override
	public void updateStatus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void nextTurn() {
		// TODO Auto-generated method stub

	}

}
