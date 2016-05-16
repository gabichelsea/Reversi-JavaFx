package hu.unideb.inf.reversi.service.interfaces;

import java.util.List;

import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

public interface PlayerResultService {
	
	public void add(PlayerResultVo playerResultVo) throws Exception;
	
	public PlayerResultVo getByPlayerId(Long playerId) throws Exception;
	
	public List<PlayerResultVo> getAll() throws Exception;
	
	public void removeByPlayerId(Long playerId) throws Exception;
}
