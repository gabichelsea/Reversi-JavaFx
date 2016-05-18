package hu.unideb.inf.reversi.service.interfaces;

import java.util.List;

import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

/**
 * Adott játékoshoz tartozó eredmények müveleteiért felelős osztály
 */
public interface PlayerResultService {
	
	/**
	 * Hozzáadjuk a paraméterként szereplő Játékos Eredmény Érték objektumot az adatbázisban szereplő táblánkhoz
	 * @param playerResultVo Játékos Eredmény Érték objektum, amelyet hozzáfogunk adni az adatbázishoz
	 * @throws Exception Kivétel lép fel, amennyiben bármelyik validációs megszorítás sérül
	 */
	public void add(PlayerResultVo playerResultVo) throws Exception;
	
	/**
	 * Visszaadja a paraméterként szereplő játékosId-hoz tartozó eredményt
	 * @param playerId A paraméterként szereplő játékosId alapján kérjük le a hozzá tartozó eredményeket
	 * @return Visszaadjuk a az adott játékosId-hoz tartozó eredményt
	 * @throws Exception Általános kivétel dobása
	 */
	public PlayerResultVo getByPlayerId(Long playerId) throws Exception;
	
	/**
	 * Visszadja az összes játékoshoz tartozó eredményeket
	 * @return Az összes játékoshoz tartozó eredmény
	 * @throws Exception Általános kivétel dobása
	 */
	public List<PlayerResultVo> getAll() throws Exception;
	
	/**
	 * Kitöröljük a paraméterként szereplő játékosId-hoz tartozó eredményt
	 * @param playerId A paraméterként szereplő játékosId alapján töröljük ki az eredményt
	 * @throws Exception Általános kivétel dobása
	 */
	public void removeByPlayerId(Long playerId) throws Exception;
}
