package com.backend.unab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.unab.models.services.UsuarioService;
import com.backend.unab.models.entity.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("")
	public List<User> index() {
		return usuarioService.findAll();
	}
	
	@PostMapping("")
	public User create(@RequestBody User user) {
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return usuarioService.save(user);
	}

}
