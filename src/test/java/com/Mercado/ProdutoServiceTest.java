package com.Mercado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.Mercado.dto.ProdutoDTO;
import com.Mercado.dto.ProdutoSaveDTO;
import com.Mercado.mapper.ProdutoMapper;
import com.Mercado.model.Produto;
import com.Mercado.service.ProdutoService;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoServiceTest {

	
	@Autowired
	ProdutoService service;
	
	@Autowired
	ProdutoMapper mapper;
	
	@Test
	@DisplayName("Salvar produto sucesso")
	void salvarProduto() {
	ProdutoSaveDTO dto=new ProdutoSaveDTO(
			"Produto nome", 
			"Produto Descricao", 
			"Produto categoria", 
			"Produto imagem",
			"Produto imagem2", 
			"Produto imagem3", 
			10.0, 
			false,
			0, 
			0, 
			List.of("p","pp","m","gg"),
			100
);
	
	Produto produto=mapper.toEntity(dto);
	service.salvarProduto(produto);
	
	assertNotNull(produto.getId(),"Id do produto criado!");
	
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
}
