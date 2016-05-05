package hu.unideb.inf.reversi.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.unideb.inf.reversi.core.entity.Player;
import hu.unideb.inf.reversi.service.vo.PlayerVo;

public class PlayerMapper {
	private static Mapper mapper = new DozerBeanMapper();

	public static PlayerVo toVo(Player playerDto) {
		if (playerDto == null) {
			return null;
		}
		return mapper.map(playerDto, PlayerVo.class);
	}

	public static Player toDto(PlayerVo playerVo) {
		if (playerVo == null) {
			return null;
		}
		return mapper.map(playerVo, Player.class);
	}

	public static List<PlayerVo> toVo(List<Player> playerDtos) {
		List<PlayerVo> playerVos = new ArrayList<>();
		for (Player playerDto : playerDtos) {
			playerVos.add(toVo(playerDto));
		}
		return playerVos;
	}

	public static List<Player> toDto(List<PlayerVo> playerVos) {
		List<Player> playerDtos = new ArrayList<>();
		for (PlayerVo playerVo : playerVos) {
			playerDtos.add(toDto(playerVo));
		}
		return playerDtos;
	}
}
