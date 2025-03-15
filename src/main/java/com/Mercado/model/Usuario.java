package com.Mercado.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="login_user")
	private String login;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="role")
	private ROLE role;
	
	@Column(name="email")
	private String email;
	
	
	public Usuario() {
		
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public ROLE getRole() {
		return role;
	}


	public void setRole(ROLE role) {
		this.role = role;
	}


	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public int hashCode() {
		return Objects.hash(email, id, login, nome, role, senha);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(login, other.login)
				&& Objects.equals(nome, other.nome) && role == other.role && Objects.equals(senha, other.senha);
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		if(this.role==ROLE.ADMIN) {
		return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),new SimpleGrantedAuthority("ROLE_USER"));
		
	}
		return List.of(new SimpleGrantedAuthority("ROLE_USER")) ;
	}


	@Override
	public String getPassword() {
		return this.senha;
	}


	@Override
	public String getUsername() {
		return this.login;
	}
	
	
	
	
	
	
}
