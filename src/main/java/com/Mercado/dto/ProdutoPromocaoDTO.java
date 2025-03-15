package com.Mercado.dto;

import java.util.UUID;

public record ProdutoPromocaoDTO(

		UUID id,
		
		String nome,
		
		String imagem,
		
		double valor,
		
		double valorPromocao,
		
		 int quantidadeEstoque
		
		
		) {

}
