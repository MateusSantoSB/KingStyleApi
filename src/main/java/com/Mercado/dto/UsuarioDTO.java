package com.Mercado.dto;

import com.Mercado.model.ROLE;

import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
		
		
		@NotBlank(message = "Campo Nome é obrigatorio")
		String nome,
		
		@NotBlank(message = "Campo Login é obrigatorio")
		String login,
		
		@NotBlank(message = "Campo Senha é obrigatorio")
		String senha,
		
		@NotBlank(message = "Campo Email é obrigatorio")
		String email) {

}
