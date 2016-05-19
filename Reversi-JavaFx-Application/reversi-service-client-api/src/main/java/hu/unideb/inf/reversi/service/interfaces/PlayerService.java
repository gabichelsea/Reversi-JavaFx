package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.vo.PlayerVo;

/**
 * Játékoshoz tartozó szolgáltatásokat definiáló interfész.
 */
public interface PlayerService {

	/**
	 * Visszaadjuk az adott felhasználónévvel rendelkező játékost.
	 * 
	 * @param userName
	 *            Az a felhasználónév, amely alapján keressük a játékost.
	 * @return A paraméterben lévő felhasználónevű játékos.
	 * @throws Exception
	 *             Adatbázis elérése közben fellépő hiba esetén.
	 */
	public PlayerVo getByUserName(String userName) throws Exception;

	/**
	 * A paraméterként szereplő felhasználót hozzáadjuk az adatbázishoz.
	 * 
	 * @param playerVo
	 *            Az a játékos, akit hozzá szeretnénk adni az adatbázishoz.
	 * @throws Exception
	 *             Kivétel lép fel, amennyiben bármelyik validációs megszorítás
	 *             sérül adatbázis szinten.
	 */
	public void add(PlayerVo playerVo) throws Exception;
}
