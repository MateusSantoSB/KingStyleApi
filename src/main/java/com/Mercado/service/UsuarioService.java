package com.Mercado.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Mercado.model.ROLE;
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
		String login=usuario.getLogin();
		Optional<Usuario> busca=repository.findLoginUser(login);
		
		if(busca.isEmpty()) {
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			usuario.setRole(ROLE.USER);
			this.repository.save(usuario);	
		}else {
			throw new RuntimeException("Login ja cadastrado");
		}
		
		
	}

	
	
}
