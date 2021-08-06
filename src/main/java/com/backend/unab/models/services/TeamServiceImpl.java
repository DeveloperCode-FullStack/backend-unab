package com.backend.unab.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.unab.models.dao.ITeamDao;
import com.backend.unab.models.entity.Team;

@Service
public class TeamServiceImpl implements ITeamService {
	
	@Autowired
	private ITeamDao teamDao;

	@Override
	@Transactional(readOnly = true)
	public List<Team> findAll() {
		// TODO Auto-generated method stub
		return (List<Team>)teamDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Team findById(Long id) {
		// TODO Auto-generated method stub
		return teamDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Team save(Team team) {
		// TODO Auto-generated method stub
		return teamDao.save(team);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		teamDao.deleteById(id);
		
	}

}
