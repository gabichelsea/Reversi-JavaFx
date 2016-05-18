package hu.unideb.inf.reversi.service.interfaces.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.repository.PlayerResultRepository;
import hu.unideb.inf.reversi.service.interfaces.PlayerResultService;
import hu.unideb.inf.reversi.service.mapper.PlayerResultMapper;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

/**
 * Adott játékoshoz tartozó eredmények müveleteiért felelős osztály
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerResultServiceImpl implements PlayerResultService {
	private static final Logger logger = LogManager.getLogger(PlayerResultServiceImpl.class);

	@Autowired
	PlayerResultRepository playerResultRepository;

	/**
	 * Hozzáadjuk a paraméterként szereplő Játékos Eredmény Érték objektumot az adatbázisban szereplő táblánkhoz
	 * @param playerResultVo Játékos Eredmény Érték objektum, amelyet hozzáfogunk adni az adatbázishoz
	 * @throws Exception Kivétel lép fel, amennyiben bármelyik validációs megszorítás sérül
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
	 * Visszaadja a paraméterként szereplő játékosId-hoz tartozó eredményt
	 * @param playerId A paraméterként szereplő játékosId alapján kérjük le a hozzá tartozó eredményeket
	 * @return Visszaadjuk a az adott játékosId-hoz tartozó eredményt
	 * @throws Exception Általános kivétel dobása
	 */
	@Override
	public PlayerResultVo getByPlayerId(Long playerId) throws Exception {
		return PlayerResultMapper.toVo(playerResultRepository.findByPlayerId(playerId));
	}

	/**
	 * Visszadja az összes játékoshoz tartozó eredményeket
	 * @return Az összes játékoshoz tartozó eredmény
	 * @throws Exception Általános kivétel dobása
	 */
	@Override
	public List<PlayerResultVo> getAll() throws Exception {
		return PlayerResultMapper.toVo(playerResultRepository.findAll());
	}

	/**
	 * Kitöröljük a paraméterként szereplő játékosId-hoz tartozó eredményt
	 * @param playerId A paraméterként szereplő játékosId alapján töröljük ki az eredményt
	 * @throws Exception Általános kivétel dobása
	 */
	@Override
	public void removeByPlayerId(Long playerId) throws Exception {
		playerResultRepository.deleteByPlayerId(playerId);
	}

}
