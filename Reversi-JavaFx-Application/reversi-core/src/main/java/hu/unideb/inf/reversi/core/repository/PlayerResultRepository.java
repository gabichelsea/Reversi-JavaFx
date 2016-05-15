package hu.unideb.inf.reversi.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.entity.PlayerResult;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public interface PlayerResultRepository extends JpaRepository<PlayerResult, Long> {
	
//	public void updatePlayerResultByPlayerId(@Param("id") Long id) throws Exception;
}
