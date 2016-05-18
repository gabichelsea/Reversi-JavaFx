package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.vo.PlayerVo;

/**
 * Játékos szolgáltatásokat tartalmazó interfész
 */
public interface PlayerService {
	
	/**
	 * Visszaadjuk az adott felhasználónévvel rendelkező játékost
	 * @param userName Az adott felhasználónév, amely alapján keressük a játékost
	 * @return Visszaadjuk az adott felhasznlónévvel rendelekező Játékost
	 * @throws Exception Általános kivétel dobása
	 */
	public PlayerVo getByUserName(String userName) throws Exception;
	
	/**
	 * A paraméterként szereplő felhasználó hozzáadását végző metódus
	 * @param playerVo Az a játékos, akit hozzá szeretnénk adni az adatbázishoz
	 * @throws Exception Általános kivétel dobása
	 */
	public void add(PlayerVo playerVo) throws Exception;
}
