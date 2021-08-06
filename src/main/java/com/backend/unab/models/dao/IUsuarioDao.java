package com.backend.unab.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.backend.unab.models.entity.User;

public interface IUsuarioDao extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
	
}
