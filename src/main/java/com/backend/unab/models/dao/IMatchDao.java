package com.backend.unab.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.backend.unab.models.entity.Match;

public interface IMatchDao extends CrudRepository<Match, Long> {
	
	@Query(value = "select p.id, u.username, local.nombre as local, p.goles_local, visit.nombre as visitante, p.goles_visitante, p.fecha from partidos as p inner join users as u on u.id = p.usuario inner join equipos as local on local.id = p.local inner join equipos as visit on visit.id = p.visitante ", nativeQuery = true)
	public List<?> all();
	
	@Query(value = "select id, usuario as usuario_id, visitante as visitante_id, goles_visitante as golesVisitante, goles_local as golesLocal, fecha from partidos where id = ?", nativeQuery = true)
	public Match matchFindId(Long id);
	
}
