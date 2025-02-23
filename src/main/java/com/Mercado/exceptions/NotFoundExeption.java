package com.Mercado.exceptions;




public class NotFoundExeption extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NotFoundExeption(String mensagem) {
		super(mensagem);
	}
	
	
}
