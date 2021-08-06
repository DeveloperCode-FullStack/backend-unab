package com.backend.unab.models.services;

import java.util.List;

import com.backend.unab.models.entity.Team;

public interface ITeamService {

	public List<Team> findAll();
	
	public Team findById(Long id);
	
	public Team save(Team team);
	
	public void delete(Long id);
	
}
