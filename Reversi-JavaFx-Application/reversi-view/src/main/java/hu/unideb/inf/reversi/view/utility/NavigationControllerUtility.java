package hu.unideb.inf.reversi.view.utility;



import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class NavigationControllerUtility {
	private static final SpringFxmlLoader loader = new SpringFxmlLoader();
	
	private NavigationControllerUtility() {
	}
	
	public static void loadLoginView(Stage primaryStage) {
		Parent root = (Parent) loader.load("/fxml/LoginView.fxml");
		Scene scene = new Scene(root);

		primaryStage.setTitle("Bejelentkező nézet");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void loadGameView(ActionEvent event) {
		Parent szulo = (Parent)loader.load("/fxml/GameView.fxml");
		Scene scene = new Scene(szulo);
		Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
		stage.setTitle("Reversi");
		stage.setScene(scene);
	}
	

}
