package hu.unideb.inf.reversi.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.board.ReversiGameBoard;
import hu.unideb.inf.reversi.service.enums.ActualPlayer;
import hu.unideb.inf.reversi.service.enums.CellType;
import hu.unideb.inf.reversi.service.interfaces.PlayerResultService;
import hu.unideb.inf.reversi.service.interfaces.impl.ReversiGameManagerImpl;
import hu.unideb.inf.reversi.service.utility.TimerUtility;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;
import hu.unideb.inf.reversi.service.vo.PlayerVo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

@Component
public class ReversiViewController {

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

	private void registerResult(PlayerVo firstPlayer, PlayerVo secondPlayer) throws Exception {

		PlayerResultVo firstPlayerResultVo = playerResultService.getByPlayerId(firstPlayer.getId());
		PlayerResultVo secondPlayerResultVo = playerResultService.getByPlayerId(secondPlayer.getId());

		setUpResults(firstPlayerResultVo, secondPlayerResultVo);

		playerResultService.removeByPlayerId(firstPlayer.getId());
		playerResultService.removeByPlayerId(secondPlayer.getId());
		playerResultService.add(firstPlayerResultVo);
		playerResultService.add(secondPlayerResultVo);
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
	}

	@FXML
	public void mouseClicked(MouseEvent mouseEvent) {
		gameManager.mouseClicked(mouseEvent);
		TimerUtility.runDelayed(500, new Runnable() {

			@Override
			public void run() {
				if ((firstPlayer.getScore() + secondPlayer.getScore()) == (gameBoard.getRows() * gameBoard.getColumns())
						|| gameManager.getActualPlayer().equals(ActualPlayer.NOBODY)) {
					try {
						registerResult(firstPlayer, secondPlayer);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
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
}
