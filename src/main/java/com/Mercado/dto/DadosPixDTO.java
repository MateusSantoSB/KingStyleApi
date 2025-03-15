package com.Mercado.dto;

import java.math.BigDecimal;

public record DadosPixDTO(
		String nomeDestinatario,
		String chaveDestinatario,
		BigDecimal valor,
		String cidadeRemetente,
		String descricao) {

}
