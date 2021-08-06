package com.backend.unab.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.unab.models.dao.IMatchDao;
import com.backend.unab.models.entity.Match;

@Service
public class MatchServiceImpl implements IMatchService {
	
	@Autowired
	private IMatchDao matchDao;	
	@Transactional(readOnly = true)
	public List<?> all() {
		return matchDao.all();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Match> findAll() {
		// TODO Auto-generated method stub
		return (List<Match>)matchDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Match findById(Long id) {
		// TODO Auto-generated method stub
		return matchDao.findById(id).orElse(null);
	}
	
	@Override 
	@Transactional(readOnly = true)
	public Match matchFindId(Long id) {
		return matchDao.matchFindId(id);
	}

	@Override
	@Transactional
	public Match save(Match match) {
		// TODO Auto-generated method stub
		return matchDao.save(match);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		matchDao.deleteById(id);
	}

}
 