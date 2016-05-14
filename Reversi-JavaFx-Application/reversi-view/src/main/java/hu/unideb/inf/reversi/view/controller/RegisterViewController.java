package hu.unideb.inf.reversi.view.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
public class RegisterViewController {
	private static final Logger logger = LogManager.getLogger(RegisterViewController.class);

	@Autowired
	PlayerService playerService;

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
			playerService.add(playerVo);
			succesRegister();
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage(), e);
			statusLabel.setText(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			statusLabel.setText(TextContainer.REGISTER_CONSTRAINT);
		}
	}
	
	@FXML
	protected void backToTheMainPageButtonAction(ActionEvent event) {
		NavigationControllerUtility.loadMainPageView(MainApp.primaryStage);
	}
	
	private void succesRegister() {
		statusLabel.setText("Siker");
		userNameField.setText(null);
		passwordField.setText(null);
		passwordAgainField.setText(null);
	}

	private void setUpPlayer() {
		playerVo = new PlayerVo();
		Boolean isEqualPassword = passwordField.getText().equals(passwordAgainField.getText());
		if (isEqualPassword) {
			String userName = userNameField.getText().trim();
			String password = passwordField.getText().trim();
			playerVo.setUserName(userName);
			playerVo.setPassword(password);
			System.out.println(userName);
			System.out.println(password);
		} else {
			throw new IllegalArgumentException(TextContainer.PASSWORDS_ARE_NOT_EQUAL);
		}
		
	}
}
