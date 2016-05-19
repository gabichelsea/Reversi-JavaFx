package hu.unideb.inf.reversi.service.utility;

import java.util.Comparator;

import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

/**
 * Két eredményt rangsorolni képest osztály.
 */
public class PlayerResultVoComparator implements Comparator<PlayerResultVo> {

	/**
	 * A két paraméterként kapott eredmény rangsorolása pontszám számítása alapján.
	 */
	@Override
	public int compare(PlayerResultVo firstPlayerResultVo, PlayerResultVo secondPlayerResultVo) {
		Integer firstPlayerScore = firstPlayerResultVo.getWin() * 3 + firstPlayerResultVo.getDraw();
		Integer secondPlayerScore = secondPlayerResultVo.getWin() * 3 + secondPlayerResultVo.getDraw();

		if (firstPlayerScore.equals(secondPlayerScore)) {
			Integer firstPlayerPiecesNumber = firstPlayerResultVo.getWonPieces() - firstPlayerResultVo.getLostPieces();
			Integer secondPlayerPiecesNumber = secondPlayerResultVo.getWonPieces()
					- secondPlayerResultVo.getLostPieces();

			return Integer.compare(firstPlayerPiecesNumber, secondPlayerPiecesNumber);
		} else {
			return Integer.compare(firstPlayerScore, secondPlayerScore);
		}
	}

}
