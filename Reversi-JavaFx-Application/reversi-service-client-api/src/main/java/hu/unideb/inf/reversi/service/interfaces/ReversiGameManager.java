package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.enums.ActualPlayer;
import javafx.scene.input.MouseEvent;

public interface ReversiGameManager extends BoardGameManager {

	public Integer countPieces(ActualPlayer actualPlayer);

	public Integer countRemainingValidCells(ActualPlayer actualPlayer);

	public ActualPlayer getActualPlayer();

	public void mouseClicked(MouseEvent mouseEvent);
	
	public String getStatus();

}
