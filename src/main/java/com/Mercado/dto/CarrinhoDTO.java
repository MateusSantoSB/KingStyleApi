package com.Mercado.dto;

import java.util.List;

import com.Mercado.model.Cupom;
import com.Mercado.model.Produto;

public record CarrinhoDTO(String nome,List<Produto>produtos,Cupom cupom) {

}
