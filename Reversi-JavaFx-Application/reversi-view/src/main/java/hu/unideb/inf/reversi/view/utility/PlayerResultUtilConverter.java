package hu.unideb.inf.reversi.view.utility;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

public class PlayerResultUtilConverter {
	
	public static PlayerResultUtil toPlayerResultUtil(PlayerResultVo playerResultVo) {
		if (playerResultVo == null) {
			return null;
		}

		PlayerResultUtil playerResultUtil = new PlayerResultUtil();
		playerResultUtil.setPlayerName(playerResultVo.getPlayer().getUserName());
		playerResultUtil.setNumberOfMatches(String.valueOf(playerResultVo.getNumberOfMatches()));

		playerResultUtil.setWin(String.valueOf(playerResultVo.getWin()));
		playerResultUtil.setDraw(String.valueOf(playerResultVo.getDraw()));
		playerResultUtil.setLose(String.valueOf(playerResultVo.getLose()));
		playerResultUtil.setWonPieces(String.valueOf(playerResultVo.getWonPieces()));
		playerResultUtil.setLostPieces(String.valueOf(playerResultVo.getLostPieces()));

		Integer differentPieces = playerResultVo.getWonPieces() - playerResultVo.getLostPieces();
		playerResultUtil.setDifferentPieces(String.valueOf(differentPieces));

		Integer score = playerResultVo.getWin() * 3 + playerResultVo.getDraw();
		playerResultUtil.setScore(String.valueOf(score));

		return playerResultUtil;
	}

	public static List<PlayerResultUtil> toPlayerResultUtil(List<PlayerResultVo> playerResultVos) {
		List<PlayerResultUtil> playerResultUtils = new ArrayList<PlayerResultUtil>();
		for (PlayerResultVo playerResultVo : playerResultVos) {
			playerResultUtils.add(toPlayerResultUtil(playerResultVo));
		}
		System.out.println(playerResultUtils.toString());
		return playerResultUtils;
	}
}
