package hu.unideb.inf.reversi.view.main;

import java.io.IOException;

import hu.unideb.inf.reversi.view.utility.NavigationControllerUtility;
import hu.unideb.inf.reversi.view.utility.SpringFxmlLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

	public static Stage primaryStage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {
		primaryStage = stage;
		NavigationControllerUtility.loadMainPageView(primaryStage);
	}

	@Override
	public void stop() throws Exception {
		SpringFxmlLoader.close();
	}

}
