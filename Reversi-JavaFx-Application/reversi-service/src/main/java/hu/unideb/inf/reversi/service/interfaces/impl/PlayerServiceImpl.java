package hu.unideb.inf.reversi.service.interfaces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.repository.PlayerRepository;
import hu.unideb.inf.reversi.service.interfaces.PlayerService;
import hu.unideb.inf.reversi.service.mapper.PlayerMapper;
import hu.unideb.inf.reversi.service.vo.PlayerVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	@Override
	public PlayerVo getByUserName(String userName) throws Exception {
		return PlayerMapper.toVo(playerRepository.findByUserName(userName));
	}

}
