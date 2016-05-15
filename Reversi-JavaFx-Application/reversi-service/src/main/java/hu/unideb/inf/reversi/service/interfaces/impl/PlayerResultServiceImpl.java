package hu.unideb.inf.reversi.service.interfaces.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.unideb.inf.reversi.core.repository.PlayerResultRepository;
import hu.unideb.inf.reversi.service.interfaces.PlayerResultService;
import hu.unideb.inf.reversi.service.mapper.PlayerResultMapper;
import hu.unideb.inf.reversi.service.vo.PlayerResultVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerResultServiceImpl implements PlayerResultService {
	
	@Autowired
	PlayerResultRepository playerResultRepository;

	@Override
	public void add(PlayerResultVo playerResultVo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PlayerResultVo> modifyByPlayerId() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PlayerResultVo> getAll() throws Exception {
		return PlayerResultMapper.toVo(playerResultRepository.findAll());
	}

	
}
