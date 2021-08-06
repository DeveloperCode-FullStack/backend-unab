package com.backend.unab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.backend.unab.models.entity.Team;
import com.backend.unab.models.services.ITeamService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/teams")
public class TeamRestController {

	@Autowired
	private ITeamService teamService;
	
	@GetMapping("")
	public List<Team> index() {
		return teamService.findAll();
	}
	
	@GetMapping("{id}")
	public Team show(@PathVariable Long id) {
		return teamService.findById(id);
	}
	
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Team save(@RequestBody Team team) {
		return teamService.save(team);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Team update(@PathVariable Long id, @RequestBody Team team) {
		Team teamUpdate = teamService.findById(id);
		
		teamUpdate.setNombre(team.getNombre());
		
		return teamService.save(teamUpdate);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		teamService.delete(id);
	}
	
}
