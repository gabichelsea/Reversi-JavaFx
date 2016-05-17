package hu.unideb.inf.reversi.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.entity.PlayerResult;

/**
 * JátékosEredményTároló interfész, amely tartalmazza a legfontosabb müveleteket
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface PlayerResultRepository extends JpaRepository<PlayerResult, Long> {

	/**
	 * Megkeresi felhasználóId szerint az adott felhasználóhoz tartozó eredményeket
	 * @param playerId Az a játékosId, ami alapján lekérjük a játékoshoz tartozó eredményeket 
	 * @return PlayerResult Visszaadja az adott felhasználóhoz tartozó eredményeket
	 * @throws Exception Általános kivétel dobása
	 */
	public PlayerResult findByPlayerId(Long playerId) throws Exception;

	/**
	 * Eredmény törlése a paraméterként szereplő playerId alapján
	 * @param playerId Ezen playerId alapján történik a törlés
	 * @throws Exception Általános kivétel dobása
	 */
	public void deleteByPlayerId(Long playerId) throws Exception;
}
