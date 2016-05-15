package hu.unideb.inf.reversi.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.entity.Player;

/**
 * JátékosTároló interfész, amely tartalmazza a Játékos osztályhoz tartozó
 * legfontosabb müveleteket
 */
@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface PlayerRepository extends JpaRepository<Player, Long> {

	/**
	 * Visszadja az adott felhasználónevű játékos objektumot
	 * @param userName Az a felhasználónév ami alapján keressük a Játékos objektumot
	 * @return Visszadja az adott Játékos objektumot
	 * @throws Exception Kivétel dobása, amennyiben kivétel váltódik ki
	 */
	public Player findByUserName(String userName) throws Exception;
}
