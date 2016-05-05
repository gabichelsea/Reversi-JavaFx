package hu.unideb.inf.reversi.view.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.interfaces.PlayerService;
import hu.unideb.inf.reversi.service.vo.PlayerVo;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@Component
public class LoginViewController {

	@Autowired
	PlayerService playerService;

	private PlayerVo firstPlayer;
	private PlayerVo secondPlayer;

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
	protected void firstPlayerLoginButtonAction() throws Exception {
		System.out.println("First player");
	}

	@FXML
	protected void secondPlayerLoginButton() {
		System.out.println("Second player");
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
