package com.Mercado.controller;

import java.net.URI;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Mercado.config.JwtService;
import com.Mercado.dto.AuthDTO;
import com.Mercado.dto.UsuarioDTO;
import com.Mercado.mapper.UsuarioMapper;
import com.Mercado.model.Usuario;
import com.Mercado.service.AuthorizationService;
import com.Mercado.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private final AuthorizationService authservice;
	
	private final AuthenticationManager authenticationManager;
	
	private final UsuarioMapper mapper;
	
	private final UsuarioService service;
	
	private final JwtService jwtService;
	
	public AuthController(AuthorizationService authservice,AuthenticationManager authenticationManager,UsuarioMapper mapper,UsuarioService service,JwtService jwtService) {
		this.authservice=authservice;
		this.authenticationManager=authenticationManager;
		this.mapper=mapper;
		this.service=service;
		this.jwtService=jwtService;
	}
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AuthDTO dto ){

		
		
				var login=new UsernamePasswordAuthenticationToken(dto.login(), dto.senha());
				var auth=authenticationManager.authenticate(login);
				
			    var token=jwtService.gerarToken((Usuario)auth.getPrincipal());
			    
				return ResponseEntity.ok(token);

			
			
			
			
		
		
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Void> salvar(@RequestBody UsuarioDTO dto){
		Usuario usuario=mapper.toEntity(dto);
		this.service.salvar(usuario);
		
		
		URI loc=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/"+usuario.getId())
				.build()
				.toUri();
		
		
		return ResponseEntity.created(loc).build();
	}
	
	
}
