package com.Mercado.mapper;

import org.mapstruct.Mapper;

import com.Mercado.dto.ProdutoDTO;
import com.Mercado.dto.ProdutoPromocaoDTO;
import com.Mercado.dto.ProdutoSaveDTO;
import com.Mercado.model.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

	Produto toEntity(ProdutoDTO dto);
	
	ProdutoDTO toDTO(Produto produto);
	
	
	ProdutoPromocaoDTO toPromocaoDTO(Produto produto);
	
	Produto toEntity(ProdutoPromocaoDTO dto);
	
	
	ProdutoSaveDTO toSaveProdutoDTO (Produto produto);
	
	Produto toEntity(ProdutoSaveDTO dto);
	
}
 