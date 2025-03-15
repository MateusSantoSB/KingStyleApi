package com.Mercado.model.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.Mercado.model.Usuario;

public interface UsuarioRepository  extends JpaRepository<Usuario, UUID>{

	UserDetails findByLogin(String login); 
	
	@Query(value="SELECT * FROM USUARIO WHERE login_user= :loginUser",nativeQuery = true)
	Optional<Usuario> findLoginUser(@Param("loginUser")String loginUser);
	

}
