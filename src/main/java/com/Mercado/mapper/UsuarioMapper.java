package com.Mercado.mapper;

import org.mapstruct.Mapper;

import com.Mercado.dto.UsuarioDTO;
import com.Mercado.model.Usuario;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	Usuario toEntity(UsuarioDTO dto);
	
	UsuarioDTO toDTO(Usuario usuario);
	
	
}
