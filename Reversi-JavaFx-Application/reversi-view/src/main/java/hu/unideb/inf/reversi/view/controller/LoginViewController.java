package hu.unideb.inf.reversi.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.container.TextContainer;
import hu.unideb.inf.reversi.service.interfaces.PlayerService;
import hu.unideb.inf.reversi.service.vo.PlayerVo;
import hu.unideb.inf.reversi.view.main.MainApp;
import hu.unideb.inf.reversi.view.utility.NavigationControllerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@Component
public class LoginViewController {

	@Autowired
	PlayerService playerService;

	private PlayerVo firstPlayer;
	private PlayerVo secondPlayer;
	
	@FXML
	private Label titleLabel;

	@FXML
	private Label firstPlayerUserNameLabel;
	@FXML
	private Label firstPlayerPasswordLabel;
	@FXML
	private Label secondPlayerUserNameLabel;
	@FXML
	private Label secondPlayerPasswordLabel;
	@FXML
	private Button firstPlayerLoginButton;
	@FXML
	private Button secondPlayerLoginButton;

	@FXML
	private Label firstPlayerLoginLabel;
	@FXML
	private TextField firstPlayerUserNameTextField;
	@FXML
	private TextField firstPlayerPasswordTextField;

	@FXML
	private Label secondPlayerLoginLabel;
	@FXML
	private TextField secondPlayerUserNameTextField;
	@FXML
	private TextField secondPlayerPasswordTextField;

	@FXML
	private Button registerNewPlayer;
	@FXML
	private Button startGame;

	@FXML
	protected void firstPlayerLoginButtonAction() throws Exception {
		String userName = firstPlayerUserNameTextField.getText();
		if (checkFirstPlayerByName(userName)) {
			firstPlayer = playerService.getByUserName(userName);
			if (firstPlayer != null) {
				String password = firstPlayerPasswordTextField.getText();
				if (checkFirstPlayerByPassword(password)) {
					firstPlayerLoginLabel.setText(TextContainer.SUCCES_LOGIN);
					hideFirstPlayerComponents();

				} else {
					firstPlayerLoginLabel.setText(TextContainer.INCORRECT_PASSWORD);
					firstPlayer = null;
				}
			} else {
				firstPlayerLoginLabel.setText(TextContainer.USER_NOT_EXISTS);
				firstPlayer = null;
			}
		} else {
			firstPlayerLoginLabel.setText(TextContainer.THIS_USER_IS_ALREADY_LOGGED_IN);
		}
		showStartGameButton();
	}

	@FXML
	protected void secondPlayerLoginButtonAction() throws Exception {
		String userName = secondPlayerUserNameTextField.getText();
		if (checkSecondPlayerByName(userName)) {
			secondPlayer = playerService.getByUserName(userName);
			if (secondPlayer != null) {
				String password = secondPlayerPasswordTextField.getText();
				if (checkSecondPlayerByPassword(password)) {
					secondPlayerLoginLabel.setText(TextContainer.SUCCES_LOGIN);
					hideSecondPlayerComponents();

				} else {
					secondPlayerLoginLabel.setText(TextContainer.INCORRECT_PASSWORD);
					secondPlayer = null;
				}
			} else {
				secondPlayerLoginLabel.setText(TextContainer.USER_NOT_EXISTS);
				secondPlayer = null;
			}
		} else {
			secondPlayerLoginLabel.setText(TextContainer.THIS_USER_IS_ALREADY_LOGGED_IN);
		}
		showStartGameButton();
	}

	@FXML
	protected void startGameButtonAction(ActionEvent event) {
		NavigationControllerUtility.loadGameView(event);
	}
	
	@FXML
	protected void backToTheMainPage() {
		NavigationControllerUtility.loadMainPageView(MainApp.primaryStage);
	}

	private Boolean checkFirstPlayerByName(String userName) throws Exception {
		return (secondPlayer == null || !secondPlayer.getUserName().equals(userName));
	}

	private Boolean checkSecondPlayerByName(String userName) throws Exception {
		return (firstPlayer == null || !firstPlayer.getUserName().equals(userName));
	}

	private Boolean checkFirstPlayerByPassword(String password) {
		return firstPlayer.getPassword().equals(password);
	}

	private Boolean checkSecondPlayerByPassword(String password) {
		return secondPlayer.getPassword().equals(password);
	}

	private void hideFirstPlayerComponents() {
		firstPlayerUserNameLabel.setVisible(false);
		firstPlayerUserNameTextField.setVisible(false);
		firstPlayerPasswordLabel.setVisible(false);
		firstPlayerPasswordTextField.setVisible(false);
		firstPlayerLoginButton.setVisible(false);
	}

	private void hideSecondPlayerComponents() {
		secondPlayerUserNameLabel.setVisible(false);
		secondPlayerUserNameTextField.setVisible(false);
		secondPlayerPasswordLabel.setVisible(false);
		secondPlayerPasswordTextField.setVisible(false);
		secondPlayerLoginButton.setVisible(false);
	}

	private void showStartGameButton() {
		if (firstPlayer != null && secondPlayer != null) {
			startGame.setVisible(true);
		}
	}

	public PlayerVo getFirstPlayer() {
		return firstPlayer;
	}

	public void setFirstPlayer(PlayerVo firstPlayer) {
		this.firstPlayer = firstPlayer;
	}

	public PlayerVo getSecondPlayer() {
		return secondPlayer;
	}

	public void setSecondPlayer(PlayerVo secondPlayer) {
		this.secondPlayer = secondPlayer;
	}
}
