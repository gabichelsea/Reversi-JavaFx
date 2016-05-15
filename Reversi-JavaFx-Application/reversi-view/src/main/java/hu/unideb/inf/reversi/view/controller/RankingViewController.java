package hu.unideb.inf.reversi.view.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hu.unideb.inf.reversi.service.interfaces.PlayerResultService;
import hu.unideb.inf.reversi.service.utility.PlayerResultVoComparator;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;
import hu.unideb.inf.reversi.view.utility.PlayerResultUtil;
import hu.unideb.inf.reversi.view.utility.PlayerResultUtilConverter;
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
	private TableView<PlayerResultUtil> table = new TableView<PlayerResultUtil>();
	@FXML
	private TableColumn<PlayerResultUtil, String> playerNameColumn;
	@FXML
	private TableColumn<PlayerResultUtil, String> numberOfMatchesColumn;
	@FXML
	private TableColumn<PlayerResultUtil, String> winColumn;
	@FXML
	private TableColumn<PlayerResultUtil, String> drawColumn;
	@FXML
	private TableColumn<PlayerResultUtil, String> loseColumn;
	@FXML
	private TableColumn<PlayerResultUtil, String> wonPiecesColumn;
	@FXML
	private TableColumn<PlayerResultUtil, String> lostPiecesColumn;
	@FXML
	private TableColumn<PlayerResultUtil, String> differentPiecesColumn;
	@FXML
	private TableColumn<PlayerResultUtil, String> scoreColumn;
	private ObservableList<PlayerResultUtil> data;

	@FXML
	protected void initialize() throws Exception {
		List<PlayerResultVo> playerVoList = playerResultService.getAll().stream()
				.sorted(new PlayerResultVoComparator().reversed())
				.collect(Collectors.toList());
		data = FXCollections.observableList(PlayerResultUtilConverter.toPlayerResultUtil(playerVoList));

		setUpTablewView();
	}

	private void setUpTablewView() {

		playerNameColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultUtil, String>("playerName"));
		numberOfMatchesColumn
				.setCellValueFactory(new PropertyValueFactory<PlayerResultUtil, String>("numberOfMatches"));
		winColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultUtil, String>("win"));
		drawColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultUtil, String>("draw"));
		loseColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultUtil, String>("lose"));
		wonPiecesColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultUtil, String>("wonPieces"));
		lostPiecesColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultUtil, String>("lostPieces"));
		differentPiecesColumn
				.setCellValueFactory(new PropertyValueFactory<PlayerResultUtil, String>("differentPieces"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<PlayerResultUtil, String>("score"));

		table.setItems(data);
	}

}
