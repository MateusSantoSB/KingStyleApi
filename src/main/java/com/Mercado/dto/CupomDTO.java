package com.Mercado.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CupomDTO(
		
		UUID id, 
		
		@NotBlank(message = "O campo Nome não pode ser vazio")
		@Size(max=55, message = "O Nome e muito grande")
		String nome,
		
		
		@NotNull(message = "O campo Valor não pode ser Nulo")
		double valor,
		
		@NotNull(message = "O campo Valido não pode ser nulo")
		boolean valido) {

}
