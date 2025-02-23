package com.Mercado.model.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Mercado.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, UUID> {

}
