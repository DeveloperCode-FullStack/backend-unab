package com.backend.unab.models.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.unab.models.dao.IUsuarioDao;

@Service
public class UsuarioService implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UsuarioService.class);
	
	@Autowired 
	private IUsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.backend.unab.models.entity.User usuario = usuarioDao.findByUsername(username);
		
		if (usuario == null) {
			logger.error("No existe el usuario en el sistema");
			throw new UsernameNotFoundException("No existe el usuario en el sistema");
		}
		
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority(role.getName()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))
				.collect(Collectors.toList());
		
		return new User(usuario.getUsername(), usuario.getPassword(), true, true, true, true, authorities);
	}
	
	@Transactional(readOnly = true)
	public List<com.backend.unab.models.entity.User> findAll() {
		return (List<com.backend.unab.models.entity.User>) usuarioDao.findAll();
	}
	
	
	@Transactional
	public com.backend.unab.models.entity.User save(com.backend.unab.models.entity.User user) {
		return usuarioDao.save(user);
	}

}
