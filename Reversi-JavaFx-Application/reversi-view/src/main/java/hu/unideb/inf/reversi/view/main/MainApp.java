// CHECKSTYLE:OFF
package hu.unideb.inf.reversi.view.main;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import hu.unideb.inf.reversi.service.container.TextContainer;
import hu.unideb.inf.reversi.view.utility.NavigationControllerUtility;
import hu.unideb.inf.reversi.view.utility.SpringFxmlLoader;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
	private static final Logger logger = LoggerFactory.getLogger(MainApp.class);
	
	public static Stage primaryStage;

	public static void main(String[] args) {
		logger.info(TextContainer.APP_START_LOG);
		launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {
		primaryStage = stage;
		NavigationControllerUtility.loadMainPageView(primaryStage);
	}

	@Override
	public void stop() throws Exception {
		logger.info(TextContainer.APP_STOP_LOG);
		SpringFxmlLoader.close();
	}

}
