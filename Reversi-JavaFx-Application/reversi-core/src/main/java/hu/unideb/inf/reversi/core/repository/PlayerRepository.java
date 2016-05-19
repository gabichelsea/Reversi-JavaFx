package hu.unideb.inf.reversi.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.entity.Player;

/**
 * Ezen interfész tárolja a játékoshoz tartozó legfontosabb műveleteket.
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface PlayerRepository extends JpaRepository<Player, Long> {

	/**
	 * Megkeresi és visszadja az adott felhasználónevű játékost.
	 * @param userName Az a felhasználónév ami alapján keressük a játékost.
	 * @return A keresett felhasználónevű játékos.
	 * @throws Exception Adatbázis elérése közben fellépő hiba esetén.
	 */
	public Player findByUserName(String userName) throws Exception;
}
