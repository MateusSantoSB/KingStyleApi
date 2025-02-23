package com.Mercado.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.Mercado.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, UUID>{

	UserDetails findByLogin(String login); 
	
}
