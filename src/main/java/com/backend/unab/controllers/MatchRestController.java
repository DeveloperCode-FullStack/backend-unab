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

import com.backend.unab.models.entity.Match;
import com.backend.unab.models.services.IMatchService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/matchs")
public class MatchRestController {

	@Autowired
	private IMatchService matchService;
	
	
	@GetMapping("all")
	public List<?> all() {
		return matchService.all();
	}
	
	@GetMapping("")
	public List<Match> index() {
		return matchService.findAll();
	}
	
	@GetMapping("{id}")
	public Match show(@PathVariable Long id) {
		return matchService.findById(id);
	}
	
	@GetMapping("match/{id}")
	public Match matchFindId(@PathVariable Long id) {
		return matchService.matchFindId(id);
	}
	
	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Match save(@RequestBody Match match) {
		return matchService.save(match);
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Match update(@PathVariable Long id, @RequestBody Match match) {
		Match matchUpdate = matchService.findById(id);
		
		matchUpdate.setFecha(match.getFecha());
		matchUpdate.setGolesLocal(match.getGolesLocal());
		matchUpdate.setGolesVisitante(match.getGolesVisitante());
		matchUpdate.setLocal(match.getLocal());
		matchUpdate.setUsuario(match.getUsuario());
		matchUpdate.setVisitante(match.getVisitante());
		
		return matchService.save(matchUpdate);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		matchService.delete(id);
	}
	
}
