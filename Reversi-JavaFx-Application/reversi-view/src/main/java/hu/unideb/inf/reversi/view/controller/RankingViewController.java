// CHECKSTYLE:OFF
package hu.unideb.inf.reversi.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.interfaces.PlayerResultService;
import hu.unideb.inf.reversi.service.utility.PlayerResultVoComparator;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;
import hu.unideb.inf.reversi.view.bean.PlayerResultBean;
import hu.unideb.inf.reversi.view.main.MainApp;
import hu.unideb.inf.reversi.view.utility.NavigationControllerUtility;
import hu.unideb.inf.reversi.view.utility.PlayerResultBeanConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

@Component
public class RankingViewController {

	@Autowired
	PlayerResultService playerResultService;

	@FXML
	private TableView<PlayerResultBean> table = new TableView<PlayerResultBean>();
	@FXML
	private TableColumn<PlayerResultBean, String> playerNameColumn;
	@FXML
	private TableColumn<PlayerResultBean, String> numberOfMatchesColumn;
	@FXML
	private TableColumn<PlayerResultBean, String> winColumn;
	@FXML
	private TableColumn<PlayerResultBean, String> drawColumn;
	@FXML
	private TableColumn<PlayerResultBean, String> loseColumn;
	@FXML
	private TableColumn<PlayerResultBean, String> wonPiecesColumn;
	@FXML
	private TableColumn<PlayerResultBean, String> lostPiecesColumn;
	@FXML
	private TableColumn<PlayerResultBean, String> differentPiecesColumn;
	@FXML
	private TableColumn<PlayerResultBean, String> scoreColumn;
	private ObservableList<PlayerResultBean> data;

	@FXML
	protected void initialize() throws Exception {
		List<PlayerResultVo> playerVoList = playerResultService.getAll().stream()
				.sorted(new PlayerResultVoComparator().reversed())
				.collect(Collectors.toList());
		data = FXCollections.observableList(PlayerResultBeanConverter.toPlayerResultUtil(playerVoList));

		setUpTablewView();
	}

	private void setUpTablewView() {

		playerNameColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultBean, String>("playerName"));
		numberOfMatchesColumn
				.setCellValueFactory(new PropertyValueFactory<PlayerResultBean, String>("numberOfMatches"));
		winColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultBean, String>("win"));
		drawColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultBean, String>("draw"));
		loseColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultBean, String>("lose"));
		wonPiecesColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultBean, String>("wonPieces"));
		lostPiecesColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultBean, String>("lostPieces"));
		differentPiecesColumn
				.setCellValueFactory(new PropertyValueFactory<PlayerResultBean, String>("differentPieces"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultBean, String>("score"));

		table.setItems(data);
	}
	
	@FXML
	protected void backToTheMainPage() {
		NavigationControllerUtility.loadMainPageView(MainApp.primaryStage);
	}

}
