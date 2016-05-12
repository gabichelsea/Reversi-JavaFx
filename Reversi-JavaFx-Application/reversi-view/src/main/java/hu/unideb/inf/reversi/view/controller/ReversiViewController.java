package hu.unideb.inf.reversi.view.controller;

import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.board.ReversiGameBoard;
import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.interfaces.ReversiGameManager;
import hu.unideb.inf.reversi.service.interfaces.impl.ReversiGameManagerImpl;
import javafx.fxml.FXML;

@Component
public class ReversiViewController {

	@FXML
	private ReversiGameBoard gameBoard;
	
	private ReversiGameManager gameManager;

	@FXML
	protected void initialize() {
		ClassLoader classLoader = getClass().getClassLoader();
		gameBoard.getImageContainer().addImage(CellType.RED, classLoader.getResource("img/red.png").getFile());
		gameBoard.getImageContainer().addImage(CellType.BLACK, classLoader.getResource("img/black.png").getFile());
		gameBoard.getImageContainer().addImage(CellType.EMPTY, classLoader.getResource("img/empty.png").getFile());
		initReversiGameManager();
		gameManager.newGame();
	}

	private void initReversiGameManager() {
		gameManager = new ReversiGameManagerImpl(gameBoard);
	}
	
	@FXML
	protected void newGameButtonAction() {
		gameManager.newGame();
	}
	
}
