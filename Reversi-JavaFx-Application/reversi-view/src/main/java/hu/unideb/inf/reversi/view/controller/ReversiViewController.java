package hu.unideb.inf.reversi.view.controller;

import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.model.CellPosition;
import hu.unideb.inf.reversi.view.board.ReversiGameBoard;
import javafx.fxml.FXML;

@Component
public class ReversiViewController {

	@FXML
	private ReversiGameBoard gameBoard;

	@FXML
	protected void initialize() {
		ClassLoader classLoader = getClass().getClassLoader();
		gameBoard.getImageContainer().addImage(CellType.RED, classLoader.getResource("img/red.png").getFile());
		gameBoard.getImageContainer().addImage(CellType.BLACK, classLoader.getResource("img/black.png").getFile());
		gameBoard.getImageContainer().addImage(CellType.EMPTY, classLoader.getResource("img/empty.png").getFile());

		initGameBoard();
	}

	private void initGameBoard() {
		gameBoard.fillAllGrid(CellType.EMPTY);
		gameBoard.setCell(new CellPosition(3, 3), CellType.RED);
		gameBoard.setCell(new CellPosition(3, 4), CellType.BLACK);
		gameBoard.setCell(new CellPosition(4, 3), CellType.BLACK);
		gameBoard.setCell(new CellPosition(4, 4), CellType.RED);
	}

}
