package hu.unideb.inf.reversi.view.utility;

import hu.unideb.inf.reversi.service.container.TextContainer;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class NavigationControllerUtility {
	private static final SpringFxmlLoader loader = new SpringFxmlLoader();

	private NavigationControllerUtility() {
	}

	public static void loadMainPageView(Stage primaryStage) {
		Parent root = (Parent) loader.load("/fxml/MainPageView.fxml");
		Scene scene = new Scene(root);
		scene.getStylesheets().add(NavigationControllerUtility.class.getResource("/css/mainPage.css").toExternalForm());

		primaryStage.setTitle(TextContainer.MAIN_PAGE_TITLE);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
		primaryStage.show();
	}

	public static void loadRegisterView(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/RegisterView.fxml");
		Scene scene = new Scene(parent);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(TextContainer.REGISTER_VIEW_TITLE);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.centerOnScreen();
	}

	public static void loadLoginView(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/LoginView.fxml");
		Scene scene = new Scene(parent);
		scene.getStylesheets().add(NavigationControllerUtility.class.getResource("/css/login.css").toExternalForm());
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(TextContainer.LOGIN_VIEW_TITLE);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.centerOnScreen();
	}

	public static void loadGameView(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/ReversiView.fxml");
		Scene scene = new Scene(parent);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(TextContainer.REVERSI_VIEW_TITLE);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.centerOnScreen();
	}

	public static void loadRankingView(ActionEvent event) {
		Parent parent = (Parent) loader.load("/fxml/RankingView.fxml");
		Scene scene = new Scene(parent);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setTitle(TextContainer.RANKING_VIEW_TITLE);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.centerOnScreen();
	}

}
