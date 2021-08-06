package com.backend.unab.models.services;

import java.util.List;

import com.backend.unab.models.entity.Match;


public interface IMatchService {
	
	public List<?> all();

	public List<Match> findAll();
	
	public Match findById(Long id);
	
	public Match matchFindId(Long id);
	
	public Match save(Match match);
	
	public void delete(Long id);
	
}
