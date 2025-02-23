package com.Mercado.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Mercado.exceptions.NotFoundExeption;
import com.Mercado.model.Produto;
import com.Mercado.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	
	private final ProdutoRepository repository;
	
	
	
	public ProdutoService(ProdutoRepository repository) {
		this.repository=repository;
	}
	
	
	
	
	
	public void salvarProduto(Produto produto) {
		this.repository.save(produto);	
	}
	
	
	public Optional<Produto> buscarProduto(UUID id) {
		
		
		Optional<Produto> produto=this.repository.findById(id);
		if(produto.isEmpty()) {
		  throw new NotFoundExeption("Produto de id:"+id+" Não encontrado");
		}
		
		
		return produto;
	}
	 
	
	
	public org.springframework.data.domain.Page<Produto> listaProdutoPaginada(int pagina,int tamanho){
		
		org.springframework.data.domain.Page<Produto> produtos=repository.findAll(PageRequest.of(pagina, tamanho));
		return produtos;
	}
	
	
	
	
	public org.springframework.data.domain.Page<Produto> listaProdutoPaginadaPromocao(int pagina,int tamanho){
		
		org.springframework.data.domain.Page<Produto> produtos=repository.produtosEmPromocao(PageRequest.of(pagina, tamanho));
		return produtos;
	}
	
	
	
	public org.springframework.data.domain.Page<Produto> buscarProdutoPaginadaPorNome(String nome,int pagina,int tamanho) {
		
		
		return  repository.findByNomeContainingIgnoreCase(nome,PageRequest.of(pagina,tamanho));
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
