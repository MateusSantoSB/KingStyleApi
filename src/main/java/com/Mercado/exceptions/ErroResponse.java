package com.Mercado.exceptions;

public class ErroResponse {

	private String erroCode;
	private String mensagem;
	
	
	
	
	public ErroResponse(String erroCode, String mensagem) {
		super();
		this.erroCode = erroCode;
		this.mensagem = mensagem;
	}
	
	
	public String getErroCode() {
		return erroCode;
	}
	public void setErroCode(String erroCode) {
		this.erroCode = erroCode;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
	
	
	
	
	
	
	
	
}
