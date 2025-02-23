package com.Mercado.dto;

import java.util.List;
import java.util.UUID;

public record ProdutoDTO(
		
		UUID id,
		
		String nome,
		
		String descricao,
		
		String categoria,
		
		String imagem,
		
		String imagem2,
		
		String imagem3,
		
		double valor,
		
		boolean promocao,
		
		double valorPromocao,
		
		double quantidade,
		
		List<String> tamanhos,
		
		int quantidadeEstoque
		
		) {

	
	 
	
}
