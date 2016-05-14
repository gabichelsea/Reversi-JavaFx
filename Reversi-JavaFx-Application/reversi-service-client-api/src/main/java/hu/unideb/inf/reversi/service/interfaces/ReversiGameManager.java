package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.board.ReversiGameBoard;
import hu.unideb.inf.reversi.service.vo.PlayerVo;

public interface ReversiGameManager extends BoardGameManager {
	
	public void setUp(PlayerVo firstPlayer, PlayerVo secondPlayer, ReversiGameBoard gameBoard);
}
