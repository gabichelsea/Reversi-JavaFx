package hu.unideb.inf.reversi.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.unideb.inf.reversi.core.entity.PlayerResult;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

/**
 * Eredményeket konvertáló osztály.
 */
public class PlayerResultMapper {
	private static final Mapper mapper = new DozerBeanMapper();

	/**
	 * A paraméterként szereplő DTO-ból Vo-t csinál.
	 * @param playerResultDto Az eredmény DTO-ként.
	  * @return A paraméterként lévő eredmény VO-ként.
	 */
	public static PlayerResultVo toVo(PlayerResult playerResultDto) {
		if (playerResultDto == null) {
			return null;
		}
		return mapper.map(playerResultDto, PlayerResultVo.class);
	}

	/**
	 * A paraméterként szereplő VO-ból DTO-t csinál.
	 * @param playerResultDto Az eredmény DTO-ként.
	 * @return A paraméterként lévő eredmény DTO-ként.
	 */
	public static PlayerResult toDto(PlayerResultVo playerResultVo) {
		if (playerResultVo == null) {
			return null;
		}
		return mapper.map(playerResultVo, PlayerResult.class);
	}

	/**
	 * A paraméterként szereplő DTO-ból Vo-kat csinál.
	 * @param playerResultDtos Az eredmények DTO-ként.
	  * @return A paraméterként lévő eredmények VO-ként.
	 */
	public static List<PlayerResultVo> toVo(List<PlayerResult> playerResultDtos) {
		List<PlayerResultVo> playerResultVos = new ArrayList<>();
		for (PlayerResult playerResultDto : playerResultDtos) {
			playerResultVos.add(toVo(playerResultDto));
		}
		return playerResultVos;
	}

	/**
	 * A paraméterként szereplő VO-ból DTO-t csinál.
	 * @param playerResultVos Az eredmény VO-ként.
	 * @return A paraméterként lévő eredmények DTO-ként.
	 */
	public static List<PlayerResult> toDto(List<PlayerResultVo> playerResultVos) {
		List<PlayerResult> playerResultDtos = new ArrayList<>();
		for (PlayerResultVo playerResultVo : playerResultVos) {
			playerResultDtos.add(toDto(playerResultVo));
		}
		return playerResultDtos;
	}

}
