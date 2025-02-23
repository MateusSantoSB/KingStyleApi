package com.Mercado.model;

public enum ROLE {

	ADMIN("admin"),
	
	USER("USER");

	private String role;
	
	ROLE(String role) {
		this.role=role;
	}
	
	public String getRole() {
		return this.role;
	}
	
	
}
