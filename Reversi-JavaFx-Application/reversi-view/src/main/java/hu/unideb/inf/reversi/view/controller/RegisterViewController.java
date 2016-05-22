// CHECKSTYLE:OFF
package hu.unideb.inf.reversi.view.controller;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.container.TextContainer;
import hu.unideb.inf.reversi.service.interfaces.PlayerResultService;
import hu.unideb.inf.reversi.service.interfaces.PlayerService;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;
import hu.unideb.inf.reversi.service.vo.PlayerVo;
import hu.unideb.inf.reversi.view.main.MainApp;
import hu.unideb.inf.reversi.view.utility.NavigationControllerUtility;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

@Component
public class RegisterViewController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterViewController.class);

	@Autowired
	PlayerService playerService;
	@Autowired
	PlayerResultService playerResultService;

	private PlayerVo playerVo;

	@FXML
	private Label statusLabel;
	@FXML
	private TextField userNameField;
	@FXML
	private TextField passwordField;
	@FXML
	private TextField passwordAgainField;

	@FXML
	private Button registerButton;
	@FXML
	private Button backToTheMainPage;

	@FXML
	protected void registerButtonAction() {
		try {
			setUpPlayer();
			registerPlayer(playerVo);
			succesRegister();
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			statusLabel.setText(e.getMessage());
		} catch (ConstraintViolationException e) {
			logger.error(e.getMessage(), e);
			statusLabel.setText(TextContainer.REGISTER_CONSTRAINT);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			statusLabel.setText(TextContainer.USER_IS_EXIST);
		}
	}

	@FXML
	protected void backToTheMainPageButtonAction(ActionEvent event) {
		NavigationControllerUtility.loadMainPageView(MainApp.primaryStage);
	}

	private void succesRegister() {
		statusLabel.setText("Siker");
		userNameField.setText("");
		passwordField.setText("");
		passwordAgainField.setText("");
	}

	private void setUpPlayer() {
		playerVo = new PlayerVo();
		Boolean isEqualPassword = passwordField.getText().equals(passwordAgainField.getText());
		if (isEqualPassword) {
			String userName = userNameField.getText().trim();
			String password = passwordField.getText().trim();
			playerVo.setUserName(userName);
			playerVo.setPassword(password);
		} else {
			throw new IllegalArgumentException(TextContainer.PASSWORDS_ARE_NOT_EQUAL);
		}
	}

	private void registerPlayer(PlayerVo playerVo) throws Exception {
		PlayerResultVo playerResultVo = new PlayerResultVo();
		playerResultVo.setPlayer(playerVo);
		playerResultService.add(playerResultVo);
	}

}
