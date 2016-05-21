package hu.unideb.inf.reversi.service.interfaces.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.repository.PlayerResultRepository;
import hu.unideb.inf.reversi.service.interfaces.PlayerResultService;
import hu.unideb.inf.reversi.service.mapper.PlayerResultMapper;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

/**
 * Adott játékoshoz tartozó eredmények müveleteiért felelős osztály.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerResultServiceImpl implements PlayerResultService {
	private static final Logger logger = LoggerFactory.getLogger(PlayerResultServiceImpl.class);

	@Autowired
	PlayerResultRepository playerResultRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(PlayerResultVo playerResultVo) throws Exception {
		try {
			playerResultRepository.saveAndFlush(PlayerResultMapper.toDto(playerResultVo));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlayerResultVo getByPlayerId(Long playerId) throws Exception {
		return PlayerResultMapper.toVo(playerResultRepository.findByPlayerId(playerId));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<PlayerResultVo> getAll() throws Exception {
		return PlayerResultMapper.toVo(playerResultRepository.findAll());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void removeByPlayerId(Long playerId) throws Exception {
		playerResultRepository.deleteByPlayerId(playerId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modify(PlayerResultVo playerResultVo) throws Exception {
		try {
			playerResultRepository.saveAndFlush(PlayerResultMapper.toDto(playerResultVo));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
