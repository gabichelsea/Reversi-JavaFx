package hu.unideb.inf.reversi.view.main;

import java.io.IOException;

import hu.unideb.inf.reversi.view.util.SpringFxmlLoader;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
	private static final SpringFxmlLoader loader = new SpringFxmlLoader();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = (Parent) loader.load("/LoginView.fxml");
		Scene scene = new Scene(root);

		primaryStage.setTitle("Bejelentkező nézet");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		SpringFxmlLoader.close();
	}

}
