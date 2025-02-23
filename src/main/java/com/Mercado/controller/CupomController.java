package com.Mercado.controller;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Mercado.dto.CupomDTO;
import com.Mercado.mapper.CupomMapper;
import com.Mercado.model.Cupom;
import com.Mercado.service.CupomService;

@RestController
@RequestMapping("/cupom")
public class CupomController {

	private final CupomMapper mapper;
	private final CupomService service;
	
	public CupomController(CupomMapper mapper,CupomService service) {
		this.mapper=mapper;
		this.service=service;
	}
	
	
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody CupomDTO dto){
		Cupom cupom=mapper.toEntity(dto);
		this.service.salvar(cupom);
		
		URI loc=ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/"+cupom.getId())
				.build()
				.toUri();
		
		
		return ResponseEntity.created(loc).build();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<CupomDTO> buscar(@PathVariable UUID id){
		Optional<Cupom> cupom=this.service.buscar(id);
		if(cupom==null) {
			return null;
		}
		
		CupomDTO dto=mapper.toDTO(cupom.get());
	
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("search")
	public ResponseEntity<CupomDTO> buscarCupom(@RequestParam String nome){
		Optional<Cupom> cupom=this.service.buscarNome(nome);
		
		if(cupom.isEmpty()) {
			return null;
		}
		
		CupomDTO dto=mapper.toDTO(cupom.get());
		return ResponseEntity.ok(dto);
	}
	
	
	
	
}

