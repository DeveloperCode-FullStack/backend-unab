package com.backend.unab.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.unab.models.entity.Team;

public interface ITeamDao extends CrudRepository<Team, Long> {

}
