package hu.unideb.inf.reversi.view.utility;

import java.util.ArrayList;
import java.util.List;

import hu.unideb.inf.reversi.service.vo.PlayerResultVo;
import hu.unideb.inf.reversi.view.bean.PlayerResultBean;

public class PlayerResultBeanConverter {
	
	public static PlayerResultBean toPlayerResultUtil(PlayerResultVo playerResultVo) {
		if (playerResultVo == null) {
			return null;
		}

		PlayerResultBean playerResultBean = new PlayerResultBean();
		playerResultBean.setPlayerName(playerResultVo.getPlayer().getUserName());
		playerResultBean.setNumberOfMatches(String.valueOf(playerResultVo.getNumberOfMatches()));

		playerResultBean.setWin(String.valueOf(playerResultVo.getWin()));
		playerResultBean.setDraw(String.valueOf(playerResultVo.getDraw()));
		playerResultBean.setLose(String.valueOf(playerResultVo.getLose()));
		playerResultBean.setWonPieces(String.valueOf(playerResultVo.getWonPieces()));
		playerResultBean.setLostPieces(String.valueOf(playerResultVo.getLostPieces()));

		Integer differentPieces = playerResultVo.getWonPieces() - playerResultVo.getLostPieces();
		playerResultBean.setDifferentPieces(String.valueOf(differentPieces));

		Integer score = playerResultVo.getWin() * 3 + playerResultVo.getDraw();
		playerResultBean.setScore(String.valueOf(score));

		return playerResultBean;
	}

	public static List<PlayerResultBean> toPlayerResultUtil(List<PlayerResultVo> playerResultVos) {
		List<PlayerResultBean> playerResultBeans = new ArrayList<PlayerResultBean>();
		for (PlayerResultVo playerResultVo : playerResultVos) {
			playerResultBeans.add(toPlayerResultUtil(playerResultVo));
		}
		System.out.println(playerResultBeans.toString());
		return playerResultBeans;
	}
}
