package com.Mercado.config;

import java.io.IOException;
import java.nio.file.AccessDeniedException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Mercado.model.repository.UsuarioRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	private final JwtService service;
	
	private final UsuarioRepository repository;
	
	public SecurityFilter(JwtService service,UsuarioRepository repository) {
		this.service=service;
		this.repository=repository;
	}
	
	
	
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		var token=this.recoverToken(request);
		
		
		if(token!=null) {
			var login=service.validarToken(token);
			UserDetails user=repository.findByLogin(login);
			

			var auth=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		filterChain.doFilter(request, response);
	}

	public String recoverToken(HttpServletRequest request) {
		var authHeader=request.getHeader("Authorization");
		if(authHeader==null) {
		 return null;
		}
		return authHeader.replace("Bearer ", "");
	}
	
	
	
	
}
