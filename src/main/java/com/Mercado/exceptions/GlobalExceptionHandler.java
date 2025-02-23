package com.Mercado.exceptions;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Forbidden;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity<ErroResponse> handlerNotFound(NotFoundExeption e){
		
		ErroResponse erro=new ErroResponse("401", e.getMessage());
		
		
		return new ResponseEntity<>(erro,HttpStatus.NOT_FOUND);
	}
	
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErroResponse> handerException(Exception ex){
		ErroResponse erro=new ErroResponse("500", ex.getMessage());
		
		return new ResponseEntity<>(erro,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<ErroResponse> handleValidationException(MethodArgumentNotValidException ex) {
	    String erroDefault=ex.getBindingResult().getAllErrors().stream().map(erro->erro.getDefaultMessage()).findFirst().orElse("Erro no campo!!");
		 ErroResponse errorResponse = new ErroResponse("400", erroDefault);
	        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	    }
	 
	 
	 
	 

	
	
	
	
	
	
	
}
