// CHECKSTYLE:OFF
package hu.unideb.inf.reversi.view.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.board.ReversiGameBoard;
import hu.unideb.inf.reversi.service.enums.ActualPlayer;
import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.interfaces.PlayerResultService;
import hu.unideb.inf.reversi.service.interfaces.ReversiGameManager;
import hu.unideb.inf.reversi.service.interfaces.impl.ReversiGameManagerImpl;
import hu.unideb.inf.reversi.service.utility.TimerUtility;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;
import hu.unideb.inf.reversi.service.vo.PlayerVo;
import hu.unideb.inf.reversi.view.main.MainApp;
import hu.unideb.inf.reversi.view.utility.NavigationControllerUtility;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

@Component
public class ReversiViewController {
	private static final Logger logger = LogManager.getLogger(ReversiViewController.class);

	@Autowired
	private LoginViewController loginViewController;
	@Autowired
	private PlayerResultService playerResultService;

	@FXML
	Label statusLabel;
	@FXML
	private ReversiGameBoard gameBoard;

	private PlayerVo firstPlayer;
	private PlayerVo secondPlayer;
	private ReversiGameManager gameManager;

	@FXML
	protected void initialize() {
		gameBoard.getImageContainer().addImage(CellType.RED, "img/red.png");
		gameBoard.getImageContainer().addImage(CellType.BLACK, "img/black.png");
		gameBoard.getImageContainer().addImage(CellType.EMPTY, "img/empty.png");
		initPlayers();
		initReversiGameManager();
		gameManager.newGame();
		updateStatus();
	}

	private void registerResult(PlayerVo firstPlayer, PlayerVo secondPlayer) throws Exception {

		PlayerResultVo firstPlayerResultVo = playerResultService.getByPlayerId(firstPlayer.getId());
		PlayerResultVo secondPlayerResultVo = playerResultService.getByPlayerId(secondPlayer.getId());

		setUpResults(firstPlayerResultVo, secondPlayerResultVo);

		playerResultService.modify(firstPlayerResultVo);
		playerResultService.modify(secondPlayerResultVo);
	}

	private void setUpResults(PlayerResultVo firstPlayerResultVo, PlayerResultVo secondPlayerResultVo) {
		if (firstPlayer.getScore() > secondPlayer.getScore()) {
			firstPlayerResultVo.setWin(firstPlayerResultVo.getWin() + 1);
			secondPlayerResultVo.setLose(secondPlayerResultVo.getLose() + 1);

		} else if (firstPlayer.getScore() < secondPlayer.getScore()) {
			firstPlayerResultVo.setLose(firstPlayerResultVo.getLose() + 1);
			secondPlayerResultVo.setWin(secondPlayerResultVo.getWin() + 1);

		} else if (firstPlayer.getScore() == secondPlayer.getScore()) {
			firstPlayerResultVo.setDraw(firstPlayerResultVo.getDraw() + 1);
			secondPlayerResultVo.setDraw(secondPlayerResultVo.getDraw() + 1);
		}

		firstPlayerResultVo.setNumberOfMatches(firstPlayerResultVo.getNumberOfMatches() + 1);
		firstPlayerResultVo.setWonPieces(firstPlayerResultVo.getWonPieces() + firstPlayer.getScore());
		firstPlayerResultVo.setLostPieces(firstPlayerResultVo.getLostPieces() + secondPlayer.getScore());

		secondPlayerResultVo.setNumberOfMatches(secondPlayerResultVo.getNumberOfMatches() + 1);
		secondPlayerResultVo.setWonPieces(secondPlayerResultVo.getWonPieces() + secondPlayer.getScore());
		secondPlayerResultVo.setLostPieces(secondPlayerResultVo.getLostPieces() + firstPlayer.getScore());
	}

	@FXML
	protected void newGameButtonAction() {
		initReversiGameManager();
		gameManager.newGame();
		updateStatus();
	}

	@FXML
	protected void backToTheMainPage() {
		firstPlayer = null;
		secondPlayer = null;
		NavigationControllerUtility.loadMainPageView(MainApp.primaryStage);
	}

	@FXML
	public void mouseClicked(MouseEvent mouseEvent) {
		gameManager.mouseClicked(mouseEvent);
		TimerUtility.runDelayed(500, () -> {
			updateStatus();
			tryToRegisterResult();
		});
	}

	private void tryToRegisterResult() {
		if ((firstPlayer.getScore() + secondPlayer.getScore()) == (gameBoard.getRows() * gameBoard.getColumns())
				|| gameManager.getActualPlayer().equals(ActualPlayer.NOBODY)) {
			try {
				registerResult(firstPlayer, secondPlayer);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	private void initReversiGameManager() {
		gameManager = new ReversiGameManagerImpl(firstPlayer, secondPlayer, gameBoard);
		updateStatus();
	}

	private void initPlayers() {
		firstPlayer = loginViewController.getFirstPlayer();
		secondPlayer = loginViewController.getSecondPlayer();
	}

	private void updateStatus() {
		gameManager.updateStatus();
		statusLabel.setText(gameManager.getStatus() + getPlayerNameAndCellColorpairs());
	}
	
	private String getPlayerNameAndCellColorpairs() {
		String firstPair = firstPlayer.getUserName() + "(RED)";
		String secondPair = secondPlayer.getUserName() + "(BLACK)";
		return "\t\t\t" + firstPair + "---" + secondPair;
	}
}
