package hu.unideb.inf.reversi.service.interfaces.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.repository.PlayerRepository;
import hu.unideb.inf.reversi.service.interfaces.PlayerService;
import hu.unideb.inf.reversi.service.mapper.PlayerMapper;
import hu.unideb.inf.reversi.service.vo.PlayerVo;

/**
 * Játékos szolgáltatásokat tartalmazó interfész.
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerServiceImpl implements PlayerService {
	private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

	@Autowired
	PlayerRepository playerRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PlayerVo getByUserName(String userName) throws Exception {
		return PlayerMapper.toVo(playerRepository.findByUserName(userName));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(PlayerVo playerVo) throws Exception {
		try {
			playerRepository.saveAndFlush(PlayerMapper.toDto(playerVo));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

}
