package com.Mercado.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Mercado.model.Usuario;
import com.Mercado.model.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository repository;
	private final BCryptPasswordEncoder encoder;
	
	public UsuarioService(UsuarioRepository repository,BCryptPasswordEncoder encoder) {
		this.repository=repository;
		this.encoder=encoder;
	}

	public void salvar(Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getSenha()));
		this.repository.save(usuario);	
	}
	

	
	
}
