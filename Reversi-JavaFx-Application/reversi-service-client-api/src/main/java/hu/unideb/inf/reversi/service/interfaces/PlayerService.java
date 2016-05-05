package hu.unideb.inf.reversi.service.interfaces;

import hu.unideb.inf.reversi.service.vo.PlayerVo;

public interface PlayerService {
	
	public PlayerVo getByUserName(String userName) throws Exception;
}
