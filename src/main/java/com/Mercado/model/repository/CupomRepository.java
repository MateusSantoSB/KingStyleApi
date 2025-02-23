package com.Mercado.model.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mercado.model.Cupom;

public interface CupomRepository extends JpaRepository<Cupom, UUID> {

	
	Optional<Cupom> findByNomeIgnoreCase(String nome);
}