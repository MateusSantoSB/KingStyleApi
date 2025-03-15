package com.Mercado.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ProdutoSaveDTO(
		@NotBlank(message = "O campo Nome não pode ser vazio")
		@Size(min=1 ,max=255, message = "O Nome e muito grande")
		String nome,
		
		@NotBlank(message = "O campo Descricao não pode ser vazio")
		@Size(max=255,message="A descricao e muito grande")
		String descricao,	
		
		@NotBlank(message = "O campo Categoria não pode ser vazio")
		@Size(max=55, message="A categoria e muito grande")
		String categoria,
		
		@NotBlank(message = "O campo Imagem não pode ser vazio")
		String imagem,
		
		@NotBlank(message = "O campo Imagem não pode ser vazio")
		String imagem2,
		
		@NotBlank(message = "O campo Imagem não pode ser vazio")
		String imagem3,
		
		@NotNull(message = "O campo Valor não pode ser nulo")
		double valor,
		
		@NotNull(message = "O campo Promocao não pode ser nulo")
		boolean promocao,
		
		@NotNull(message = "O campo ValorPromocao não pode ser nulo")
		double valorPromocao,
		
		double quantidade,
		
		List<String> tamanhos,
		
		@NotNull(message="O campo Quantidade Estoque não pode ser nulo")
		int quantidadeEstoque
		
		) {

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	

	
	
}
