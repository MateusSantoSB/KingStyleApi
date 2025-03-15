package com.Mercado.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig { 

	private final SecurityFilter filter;
	
	
	public SecurityConfig(SecurityFilter filter) {
		this.filter=filter;
	}
	
	
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.csrf(csrf ->csrf.disable())
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(auth->auth
						
						//autenticação
						.requestMatchers(HttpMethod.POST,"/auth/login").permitAll()
						.requestMatchers(HttpMethod.POST,"/auth/register").permitAll()
						
						
						
						
						//configuração de permição swagger
						.requestMatchers(HttpMethod.GET,"/swagger-ui/**").permitAll()
						.requestMatchers(HttpMethod.POST,"/swagger-ui/**").permitAll()
						.requestMatchers(HttpMethod.GET,"/v3/api-docs/**").permitAll()
						.requestMatchers(HttpMethod.POST,"/v3/api-docs/**").permitAll()

						
						// /PRODUTO
						.requestMatchers(HttpMethod.POST,"/produto/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.PUT,"/produto/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.DELETE,"/produto/**").hasRole("ADMIN")

						.requestMatchers(HttpMethod.GET,"/produto/**").permitAll()
						
						// /CUPOM
						.requestMatchers(HttpMethod.POST,"/cupom/**").hasRole("ADMIN")
						.requestMatchers(HttpMethod.GET,"/cupom/**").permitAll()
						
						// /CARRINHO
						.requestMatchers(HttpMethod.POST,"/carrinho/*").hasRole("ADMIN")


						
						
						
						.anyRequest().authenticated()
					
						)
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class )
				
				
				.build();
	}
	
	
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	
	 @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();
	        configuration.setAllowedOrigins(List.of("http://localhost:4200"));
	        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	        configuration.setAllowedHeaders(List.of("*"));
	        configuration.setAllowCredentials(true); 
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
	    }
	
	
	
	
}
