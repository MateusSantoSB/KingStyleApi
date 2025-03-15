package com.Mercado.mapper;

import org.mapstruct.Mapper;

import com.Mercado.dto.DadosPixDTO;
import com.Mercado.model.PagamentoDestinoPix;

@Mapper(componentModel = "spring")
public interface PagamentoPixMapper {

	PagamentoDestinoPix toEntity(DadosPixDTO dto);
	
	DadosPixDTO toDTO(PagamentoDestinoPix entity);
	
}
