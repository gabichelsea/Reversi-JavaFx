package hu.unideb.inf.reversi.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.unideb.inf.reversi.core.entity.Player;
import hu.unideb.inf.reversi.service.vo.PlayerVo;

/**
 * Játékosokat konvertáló osztály.
 */
public class PlayerMapper {
	private static Mapper mapper = new DozerBeanMapper();


	/**
	 * A paraméterként szereplő DTO-ból Vo-t csinál.
	 * @param playerDto Az eredmény DTO-ként.
	  * @return A paraméterként lévő eredmény VO-ként.
	 */
	public static PlayerVo toVo(Player playerDto) {
		if (playerDto == null) {
			return null;
		}
		return mapper.map(playerDto, PlayerVo.class);
	}

	/**
	 * A paraméterként szereplő VO-ból DTO-t csinál.
	 * @param playerVo Az eredmény DTO-ként.
	 * @return A paraméterként lévő eredmény DTO-ként.
	 */
	public static Player toDto(PlayerVo playerVo) {
		if (playerVo == null) {
			return null;
		}
		return mapper.map(playerVo, Player.class);
	}

	/**
	 * A paraméterként szereplő DTO-ból Vo-kat csinál.
	 * @param playerDtos Az eredmények DTO-ként.
	  * @return A paraméterként lévő eredmények VO-ként.
	 */
	public static List<PlayerVo> toVo(List<Player> playerDtos) {
		List<PlayerVo> playerVos = new ArrayList<>();
		for (Player playerDto : playerDtos) {
			playerVos.add(toVo(playerDto));
		}
		return playerVos;
	}

	/**
	 * A paraméterként szereplő VO-ból DTO-t csinál.
	 * @param playerVos Az eredmény VO-ként.
	 * @return A paraméterként lévő eredmények DTO-ként.
	 */
	public static List<Player> toDto(List<PlayerVo> playerVos) {
		List<Player> playerDtos = new ArrayList<>();
		for (PlayerVo playerVo : playerVos) {
			playerDtos.add(toDto(playerVo));
		}
		return playerDtos;
	}
}
