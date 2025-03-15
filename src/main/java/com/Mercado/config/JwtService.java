package com.Mercado.config;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Date;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Mercado.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import ch.qos.logback.core.subst.Token;



@Service
public class JwtService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	private String emissor="authKingStyle";
	
	
	public String gerarToken(Usuario usuario) {
		
		try {
			Algorithm algorithm=Algorithm.HMAC256(secret);
			String token=JWT.create()
					.withIssuer(emissor)
					.withSubject(usuario.getNome())
					.withClaim("role", usuario.getRole().toString())
					.withExpiresAt(this.gerarExpiredAt())
					.sign(algorithm);
			
			return token;
		} catch (JWTCreationException e) {
			
			throw new JWTCreationException("Erro ao Gerar Token!!",e);
		}
		
		
	}
	
	
	public String validarToken(String token) {
		try {
			
			Algorithm algorithm=Algorithm.HMAC256(secret);
			return JWT.require(algorithm)
					.withIssuer(emissor)
					.build()
					.verify(token)
					.getSubject();
			
			
		} catch (Exception e) {
			
			
			throw new RuntimeException("Usuario sem permissão!");
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	 public Instant gerarExpiredAt() {
	        Instant agora = Instant.now();
	        Instant expiracao = agora.plusSeconds(3600);
	        return expiracao;
	 }
	
	
	
	
	
	
	
	
	
	
}
