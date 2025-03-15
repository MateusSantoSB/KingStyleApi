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
	
		public void atualizarproduto(UUID id,Produto prod) {
			Optional<Produto> busca=repository.findById(id);
			
			if(busca.isPresent()) {	
				Produto produto=busca.get();
				
				produto.setId(id);
				produto.setNome(prod.getNome());
				produto.setDescricao(prod.getDescricao());
				produto.setCategoria(prod.getCategoria());
				produto.setImagem(prod.getImagem());
				produto.setImagem2(prod.getImagem());
				produto.setImagem3(prod.getImagem3());
				produto.setValor(prod.getValor());
				produto.setPromocao(prod.getPromocao());
				produto.setValorPromocao(prod.getValorPromocao());
				produto.setQuantidade(prod.getQuantidade());
				produto.setQuantidadeEstoque(prod.getQuantidadeEstoque());
				produto.setTamanhos(prod.getTamanhos());
				
				repository.save(produto);
				
			}else {
				throw new RuntimeException("Produto não encontrado!!");
			}
			
			
		}
		
		public void removerProduto(UUID id) {
			Optional<Produto> busca=repository.findById(id);
			
			if(busca.isPresent()) {
				Produto produto=busca.get();
				repository.delete(produto);
				
			}else {
				throw new RuntimeException("Produto de id:"+id+" não encontrado!!");			}
			
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
