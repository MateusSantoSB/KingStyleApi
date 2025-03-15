package com.Mercado.model;

import java.math.BigDecimal;

import com.Mercado.dto.DadosPixDTO;

public class PagamentoDestinoPix {


	private String nomeDestinatario;
	
	private String chaveDestinatario;
	
	private BigDecimal valor;
	
	private String cidadeRemetente;
	
	private String descricao;

	public PagamentoDestinoPix(String nomeDestinatario, String chaveDestinatario, BigDecimal valor, String cidadeRemetente,String descricao) {
		this.nomeDestinatario = nomeDestinatario;
		this.chaveDestinatario = chaveDestinatario;
		this.valor = valor;
		this.cidadeRemetente = cidadeRemetente;
		this.descricao = descricao;
	}
	

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getChaveDestinatario() {
		return chaveDestinatario;
	}

	public void setChaveDestinatario(String chaveDestinatario) {
		this.chaveDestinatario = chaveDestinatario;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCidadeRemetente() {
		return cidadeRemetente;
	}

	public void setCidadeRemetente(String cidadeRemetente) {
		this.cidadeRemetente = cidadeRemetente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	


	
}
