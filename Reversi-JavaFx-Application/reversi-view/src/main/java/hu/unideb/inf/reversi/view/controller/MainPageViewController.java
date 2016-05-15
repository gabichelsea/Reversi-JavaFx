package hu.unideb.inf.reversi.view.controller;

import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.view.utility.NavigationControllerUtility;
import hu.unideb.inf.reversi.view.utility.SpringFxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

@Component
public class MainPageViewController {

	@FXML
	private Button registerButton;
	@FXML
	private Button loginButton;
	@FXML
	private Button rankingButton;
	@FXML
	private Button exitButton;

	@FXML
	protected void registerButtonAction(ActionEvent event) {
		NavigationControllerUtility.loadRegisterView(event);
	}

	@FXML
	protected void loginButtonAction(ActionEvent event) {
		NavigationControllerUtility.loadLoginView(event);
	}

	@FXML
	protected void rankingButtonAction(ActionEvent event) {
		NavigationControllerUtility.loadRankingView(event);
	}

	@FXML
	protected void exitButtonAction(ActionEvent event) {
		SpringFxmlLoader.close();
		System.exit(0);
	}
}
