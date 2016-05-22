package hu.unideb.inf.reversi.service.mapper;

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
}
