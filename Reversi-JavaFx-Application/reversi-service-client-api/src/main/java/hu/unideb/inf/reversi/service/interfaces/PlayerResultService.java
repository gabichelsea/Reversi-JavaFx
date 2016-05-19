package hu.unideb.inf.reversi.service.interfaces;

import java.util.List;

import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

/**
 * Ezen interfész definiálja az eredményekhez köthető legfontosabb műveleket.
 */
public interface PlayerResultService {

	/**
	 * Hozzáadjuk a paraméterben szereplő játékoshoz tartozó eredményt az
	 * adatbázisunkhoz.
	 * 
	 * @param playerResultVo
	 *            Ezen eredményt fogjuk hozzáadni az adatbázishoz.
	 * @throws Exception
	 *             Kivétel lép fel, amennyiben bármelyik validációs megszorítás
	 *             sérül.
	 */
	public void add(PlayerResultVo playerResultVo) throws Exception;

	/**
	 * Visszaadja a paraméterben szereplő játékos azonosítóhoz tartozó
	 * eredményt.
	 * 
	 * @param playerId
	 *            Azon játékos azonosító, amely alapján lekérjük a játékoshoz
	 *            tartozó eredményt.
	 * @return Az eredmény, amely a játékoshoz tartozik.
	 * @throws Exception
	 *             Adatbázis elérése közben fellépő hiba esetén.
	 */
	public PlayerResultVo getByPlayerId(Long playerId) throws Exception;

	/**
	 * Visszadja az összes játékoshoz tartozó eredményeket.
	 * 
	 * @return Az összes játékoshoz tartozó eredmények.
	 * @throws Exception
	 *             Adatbázis elérése közben fellépő hiba esetén.
	 */
	public List<PlayerResultVo> getAll() throws Exception;

	/**
	 * Kitöröljük a paraméterként szereplő játékos azonosítóhoz tartozó
	 * eredményt.
	 * 
	 * @param playerId
	 *            Azon játékos azonosító, amely alapján törüljük az eredményt.
	 * @throws Exception
	 *             Adatbázis elérése közben fellépő hiba esetén.
	 */
	public void removeByPlayerId(Long playerId) throws Exception;

	/**
	 * A paraméterként szereplő eredmény frissítése.
	 * 
	 * @param playerResultVo
	 *            A frissítendő eredmény.
	 * @throws Exception
	 *             Adatbázis elérése közben fellépő hiba esetén.
	 */
	public void modify(PlayerResultVo playerResultVo) throws Exception;
}
