package com.Mercado.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.Mercado.model.Cupom;
import com.Mercado.model.repository.CupomRepository;

@Service
public class CupomService {

	
	private final CupomRepository repository;
	
	public CupomService(CupomRepository repository) {
		this.repository=repository;
	}
	
	
	
	public void salvar(Cupom cupom) {
	 this.repository.save(cupom);
	}
	
	public Optional<Cupom> buscar(UUID id) {
		return repository.findById(id);	
	}
	
	public Optional<Cupom> buscarNome(String nome){
		return repository.findByNomeIgnoreCase(nome);
	}
	
	
}
