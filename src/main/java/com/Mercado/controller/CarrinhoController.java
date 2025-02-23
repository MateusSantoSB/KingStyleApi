package com.Mercado.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mercado.dto.CarrinhoDTO;
import com.Mercado.mapper.CarrinhoMapper;
import com.Mercado.model.Carrinho;
import com.Mercado.service.CarrinhoService;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	
	private final CarrinhoService service;
	private final CarrinhoMapper mapper;
	
	public CarrinhoController(CarrinhoService service,CarrinhoMapper mapper) {
		this.service=service;
		this.mapper=mapper;
	}
	
	
	@PostMapping
	public ResponseEntity<CarrinhoTotalDTO> salvar(@RequestBody CarrinhoDTO dto){
		Carrinho carrinho=mapper.toEntity(dto);
		Carrinho carrinhoTotal=service.finalizarCarrinho(carrinho);
		
		CarrinhoTotalDTO total=mapper.toTotalDTO(carrinhoTotal);
		
		return ResponseEntity.ok(total);
	}
	
	
	

	
	
}
