package com.Mercado.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Mercado.dto.DadosPixDTO;
import com.Mercado.dto.PixGerado;
import com.Mercado.mapper.PagamentoPixMapper;
import com.Mercado.model.PagamentoDestinoPix;
import com.Mercado.service.PagamentoPixService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoPixController {

	private PagamentoPixMapper mapper;
	private PagamentoPixService service;
	
	public PagamentoPixController(PagamentoPixMapper mapper,PagamentoPixService service) {
		this.mapper=mapper;
		this.service=service;
		}
	
	@PostMapping
	public ResponseEntity<PixGerado> gerarPix(@org.springframework.web.bind.annotation.RequestBody DadosPixDTO dto){

		PagamentoDestinoPix dados=mapper.toEntity(dto);
		
		 PixGerado pix=new PixGerado(service.iniciar(dados));
		
		
		return ResponseEntity.ok(pix);
	}
	
	
	
}
