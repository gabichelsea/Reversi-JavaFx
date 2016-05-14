package hu.unideb.inf.reversi.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.entity.Player;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	public Player findByUserName(String userName) throws Exception;

}
