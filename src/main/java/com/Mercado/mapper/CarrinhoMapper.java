package com.Mercado.mapper;

import org.mapstruct.Mapper;

import com.Mercado.controller.CarrinhoTotalDTO;
import com.Mercado.dto.CarrinhoDTO;
import com.Mercado.model.Carrinho;

@Mapper(componentModel = "spring")
public interface CarrinhoMapper {

	
	Carrinho toEntity(CarrinhoDTO dto);
	
	CarrinhoDTO toDTO(Carrinho carrinho);
	
	
	CarrinhoTotalDTO toTotalDTO(Carrinho carrinho);
	
}
