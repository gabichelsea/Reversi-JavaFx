package hu.unideb.inf.reversi.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.entity.PlayerResult;

/**
 * Ezen interfész definiálja a legfontosabb müveleteket az eredményekhez.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface PlayerResultRepository extends JpaRepository<PlayerResult, Long> {

	/**
	 * Megkeresi és visszaadja a paraméterben szereplő játékos azonosítóhoz
	 * tartozó eredményt.
	 * 
	 * @param playerId
	 *            Az a játékos azonosító, ami alapján lekérjük a játékoshoz
	 *            tartozó eredményeket.
	 * @return A játékoshoz tartozó eredmény.
	 * @throws Exception
	 *             Adatbázis elérése közben fellépő hiba esetén.
	 */
	public PlayerResult findByPlayerId(Long playerId) throws Exception;

	/**
	 * Eredmény törlése a paraméterként szereplő játékos azonosító alapján.
	 * 
	 * @param playerId
	 *            Az a játékos azonosító ami alapján történik a törlés.
	 * @throws Exception
	 *             Adatbázis elérése közben fellépő hiba esetén.
	 */
	public void deleteByPlayerId(Long playerId) throws Exception;
}
