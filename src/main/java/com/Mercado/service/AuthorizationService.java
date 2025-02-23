package com.Mercado.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Mercado.model.repository.UsuarioRepository;

@Service
public class AuthorizationService implements UserDetailsService{

	private final UsuarioRepository repository;
	
	public AuthorizationService(UsuarioRepository repository) {
			this.repository=repository;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		return repository.findByLogin(username);
	}

	
	
	
	
	
	
	
	
	
}
