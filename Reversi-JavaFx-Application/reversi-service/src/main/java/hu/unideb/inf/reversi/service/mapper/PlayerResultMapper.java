package hu.unideb.inf.reversi.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.unideb.inf.reversi.core.entity.PlayerResult;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

public class PlayerResultMapper {
	private static final Mapper mapper = new DozerBeanMapper();

	public static PlayerResultVo toVo(PlayerResult playerResultDto) {
		if (playerResultDto == null) {
			return null;
		}
		return mapper.map(playerResultDto, PlayerResultVo.class);
	}

	public static PlayerResult toDto(PlayerResultVo playerResultVo) {
		if (playerResultVo == null) {
			return null;
		}
		return mapper.map(playerResultVo, PlayerResult.class);
	}

	public static List<PlayerResultVo> toVo(List<PlayerResult> playerResultDtos) {
		List<PlayerResultVo> playerResultVos = new ArrayList<>();
		for (PlayerResult playerResultDto : playerResultDtos) {
			playerResultVos.add(toVo(playerResultDto));
		}
		return playerResultVos;
	}

	public static List<PlayerResult> toDto(List<PlayerResultVo> playerResultVos) {
		List<PlayerResult> playerResultDtos = new ArrayList<>();
		for (PlayerResultVo playerResultVo : playerResultVos) {
			playerResultDtos.add(toDto(playerResultVo));
		}
		return playerResultDtos;
	}

}
