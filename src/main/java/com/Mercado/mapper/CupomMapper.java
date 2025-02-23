package com.Mercado.mapper;

import org.mapstruct.Mapper;

import com.Mercado.dto.CupomDTO;
import com.Mercado.model.Cupom;

@Mapper(componentModel ="spring")
public interface CupomMapper {

	Cupom toEntity(CupomDTO dto);
	
	CupomDTO toDTO(Cupom cupom);
	
}
