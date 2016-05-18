package hu.unideb.inf.reversi.service.interfaces.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.repository.PlayerRepository;
import hu.unideb.inf.reversi.service.interfaces.PlayerService;
import hu.unideb.inf.reversi.service.mapper.PlayerMapper;
import hu.unideb.inf.reversi.service.vo.PlayerVo;

/**
 * Játékos szolgáltatásokat tartalmazó interfész
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerServiceImpl implements PlayerService {
	private static final Logger logger = LogManager.getLogger(PlayerServiceImpl.class);

	@Autowired
	PlayerRepository playerRepository;

	/**
	 * Visszaadjuk az adott felhasználónévvel rendelkező játékost
	 * @param userName Az adott felhasználónév, amely alapján keressük a játékost
	 * @return Visszaadjuk az adott felhasznlónévvel rendelekező Játékost
	 * @throws Exception Általános kivétel dobása
	 */
	@Override
	public PlayerVo getByUserName(String userName) throws Exception {
		return PlayerMapper.toVo(playerRepository.findByUserName(userName));
	}

	/**
	 * A paraméterként szereplő felhasználó hozzáadását végző metódus
	 * @param playerVo Az a játékos, akit hozzá szeretnénk adni az adatbázishoz
	 * @throws Exception Általános kivétel dobása
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
