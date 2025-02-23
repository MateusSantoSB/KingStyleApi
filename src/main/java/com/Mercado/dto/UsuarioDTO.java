package com.Mercado.dto;

import com.Mercado.model.ROLE;

public record UsuarioDTO(String nome,String login,String senha,ROLE role) {

}
