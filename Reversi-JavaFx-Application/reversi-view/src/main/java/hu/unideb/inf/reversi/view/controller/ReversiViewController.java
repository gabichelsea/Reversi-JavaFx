package hu.unideb.inf.reversi.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.board.ReversiGameBoard;
import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.interfaces.impl.ReversiGameManagerImpl;
import hu.unideb.inf.reversi.service.vo.PlayerVo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

@Component
public class ReversiViewController {

	@FXML
	Label statusLabel;
	@FXML
	private ReversiGameBoard gameBoard;
	@Autowired
	private LoginViewController loginViewController;

	private PlayerVo firstPlayer;
	private PlayerVo secondPlayer;
	private ReversiGameManagerImpl gameManager;

	@FXML
	protected void initialize() {
		ClassLoader classLoader = getClass().getClassLoader();
		gameBoard.getImageContainer().addImage(CellType.RED, classLoader.getResource("img/red.png").getFile());
		gameBoard.getImageContainer().addImage(CellType.BLACK, classLoader.getResource("img/black.png").getFile());
		gameBoard.getImageContainer().addImage(CellType.EMPTY, classLoader.getResource("img/empty.png").getFile());

		initPlayers();
		initReversiGameManager();
		gameManager.newGame();
	}

	private void initReversiGameManager() {
		gameManager = new ReversiGameManagerImpl();
		gameManager.setUp(firstPlayer, secondPlayer, gameBoard);
		gameManager.setStatusLabel(statusLabel);
	}

	private void initPlayers() {
		firstPlayer = loginViewController.getFirstPlayer();
		secondPlayer = loginViewController.getSecondPlayer();
	}

	@FXML
	protected void newGameButtonAction() {
		gameManager.newGame();
	}

	@FXML
	public void mouseClicked(MouseEvent mouseEvent) {
		gameManager.mouseClicked(mouseEvent);
	}

}
