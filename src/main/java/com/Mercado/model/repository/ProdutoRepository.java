package com.Mercado.model.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Mercado.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {

	@Query(value="SELECT * FROM PRODUTO WHERE promocao=true",nativeQuery = true)
	Page<Produto> produtosEmPromocao(Pageable page);
	
	
	Page<Produto> findByNomeContainingIgnoreCase(String nome,PageRequest page);

	
	 
}
